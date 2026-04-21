package services;

import java.util.List;

import entities.Produit;

public interface ProduitService {
    public void addProduct(Produit p);
    public void deleteProduit(Long p);
    public Produit getProduitById(Long id);
    public void updateProduit(Produit p );
    public List<Produit> getAllProduits();
}
