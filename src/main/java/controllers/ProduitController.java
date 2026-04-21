package controllers;

import java.util.List;

import entities.Produit;
import services.ProduitService;
import services.ProduitServiceImpl;

public class ProduitController extends  Command implements Controller{

    private ProduitService service;

    public ProduitController(){
        service = new ProduitServiceImpl();
    }

    @Override
    public String process() {
        String method = req.getMethod();
        return switch (method){
            case "GET" -> this.doGet();
            case "POST" -> this.doPost();
            default -> "redirect:/Produit";
        };
    }
    
    @Override
    public String doGet() {
        String action = req.getParameter("action");
        if (action == null) action = "";
        String view  = switch(action){
            case "getProduit" -> getProduit();
            case "deleteProduit"-> deleteProuit();
            case "editProduit" -> editProduit();
            default -> getAll();
        };
        return view;
    }
    
    @Override
    public String doPost() {
        String action = req.getParameter("action");
        if (action == null) return "redirect:Produit";
        String view  = switch(action){
            case "addProduit" -> addProduit();
            case "updateProduit"-> updateProduct();
            default -> "redirect:/Produit";
        };
        return view;
    }

    private String getProduit(){
        String idParam  = req.getParameter("id");
        if (idParam!=null && !idParam.isEmpty()){
            try{

                Long id = Long.parseLong(idParam.trim());
                Produit p = service.getProduitById(id);
                if(p!=null){
                    List<Produit> products = List.of(p);
                    req.setAttribute("Produits", products);
                    return "home";
                }
            }catch(NumberFormatException nfe){}
        }
        return getAll();
    }

    private String deleteProuit(){
        String idParam  = req.getParameter("id");
        if (idParam!=null && !idParam.isEmpty()){
            Long id = Long.parseLong(idParam.trim());
            service.deleteProduit(id);
        }
        List<Produit> products =  service.getAllProduits();
        req.setAttribute("Produits", products);
        return "redirect:/Produit";
    }


    private String addProduit(){
        String nom = req.getParameter("nom").trim();
        String description = req.getParameter("description").trim();
        Double prix = Double.parseDouble(req.getParameter("prix"));
        service.addProduct(new Produit(nom, description,prix));
        List<Produit> products = service.getAllProduits();
        req.setAttribute("Produits",products);
        return "home";
    }

    private String updateProduct(){
        Long id = Long.parseLong(req.getParameter("id"));
        String nom = req.getParameter("nom");
        String description = req.getParameter("description");
        Double prix = Double.parseDouble(req.getParameter("prix"));
        Produit p = new Produit(nom,description,prix);
        p.setId(id);
        service.updateProduit(p);
        List<Produit> products = service.getAllProduits();
        req.setAttribute("Produits", products);
        return "home";
    }

    private String editProduit(){
        String prodId = req.getParameter("id").trim();
        Long id  = Long.parseLong(prodId);
        Produit p = service.getProduitById(id);
        req.setAttribute("produitEdit", p);
        req.setAttribute("Produits", service.getAllProduits());
        return "home";
    }

    private String getAll() {
        req.setAttribute("Produits", service.getAllProduits());
        return "home";
    }
    

    
}
