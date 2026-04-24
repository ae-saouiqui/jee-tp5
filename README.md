# TP Gestion des Produits - MVC2 & Front Controller

## 📌 Description

Ce projet est une application web de gestion de produits développée en Java EE dans le cadre d’un TP académique.

L’application permet la gestion des utilisateurs et des produits en respectant l’architecture **MVC2 (Model - View - Controller)** et le design pattern **Front Controller**.


### Front Controller

Toutes les requêtes HTTP passent par un **Front Controller Servlet**, qui délègue le traitement à un `Dispatcher`.


##  Table de routage des URLs
| URL | Contrôleur | Action |
|-----|------------|--------|
| `/User?action=login` | `UserController` | Authentification utilisateur |
| `/User?action=logout` | `UserController` | Déconnexion utilisateur |
| `/Produit?action=addProduit` | `ProduitController` | Ajouter un produit |
| `/Produit?action=updateProduit` | `ProduitController` | Modifier un produit |
| `/Produit?action=deleteProduit` | `ProduitController` | Supprimer un produit |
| `/Produit?action=getProduit` | `ProduitController` | Afficher un produit ou la liste des produit