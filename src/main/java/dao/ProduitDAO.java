package dao;
import java.util.List;

import entities.Produit;

public interface  ProduitDAO {
    public void addProduct(Produit p);
    public void deleteProduit(Long p);
    public Produit findProduitById(Long id);
    public void updateProduit(Produit p );
    public List<Produit> findAllProduits();
}
