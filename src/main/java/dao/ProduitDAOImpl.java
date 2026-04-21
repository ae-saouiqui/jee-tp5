package dao;

import java.util.List;

import entities.Produit;

public class ProduitDAOImpl extends BaseDAO implements ProduitDAO{


    @Override
    public void addProduct(Produit p) {
        session = factory.getCurrentSession();
        session.save(p);
    }

    @Override
    public void deleteProduit(Long id) {
            session = factory.getCurrentSession();
            String query = "DELETE FROM Produit WHERE id=:id";
            session.createQuery(query)
            .setParameter("id", id)
            .executeUpdate();
    }

    @Override
    public List<Produit> findAllProduits() {
        session = factory.getCurrentSession();
        List<Produit> produits  = session.createQuery("from Produit").list();
        return produits;
    }

    @Override
    public Produit findProduitById(Long id) {
        session = factory.getCurrentSession();
        Produit produit =  (Produit) session.get(Produit.class,id);
        return produit;
    }

    @Override
    public void updateProduit(Produit p) {
        session = factory.getCurrentSession();
        session.update(p);
    }
    
}
