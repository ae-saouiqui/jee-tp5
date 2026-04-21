package services;

import java.util.List;

import dao.ProduitDAO;
import dao.ProduitDAOImpl;
import entities.Produit;

public class ProduitServiceImpl implements ProduitService {

    private static ProduitDAO dao = new ProduitDAOImpl();

    @Override
    public void addProduct(Produit p) {
        dao.addProduct(p);
    }

    @Override
    public void deleteProduit(Long p) {
        dao.deleteProduit(p);
    }

    @Override
    public Produit getProduitById(Long id) {
        return dao.findProduitById(id);
    }

    @Override
    public void updateProduit(Produit p) {
        dao.updateProduit(p);
    }

    @Override
    public List<Produit> getAllProduits() {
        return dao.findAllProduits();
    }
}
