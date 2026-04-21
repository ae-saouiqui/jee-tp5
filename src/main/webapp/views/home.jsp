<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Gestion des Produits : </title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>
</head>
<body>
<h2 class="display-6 p-5 bg-primary text-center col-6 text-light" style="margin : 10px 25%; border-radius: 40px;">Gestion des Produits :</h2>
<section class="col-10 d-flex p-3  justify-content-evenly" style="margin: 5px 10%;">
<c:if test="${user.role == 'ADMIN'}" var="isAdmin">
    <div class="card mt-2 text-bg-success col-7">
        <h3 class="card-header">Creer ou modifier un produit : </h3>
        <div class="card-body">
            <form action=
            <c:url value="/Produit">
                <c:param name="action" value="${produitEdit != null ? 'updateProduit' : 'addProduit'}"/>
            </c:url>
                 method="post">
                <input type="hidden" name="id" value="${produitEdit.id}" />
                <label class="form-label">Nom : </label>
                <input type="text" name="nom" value="${produitEdit.nom}" required class="form-control"/>
                <label class="form-label">Description : </label>
                <input type="text" name="description" value="${produitEdit.description}" required  class="form-control"/>
                <label class="form-label">Prix:</label> 
                <input type="text" name="prix" value="${produitEdit.prix}" required  class="form-control"/>
                <input type="submit" value="${produitEdit != null ? 'Modifier' : 'Ajouter'}" class="btn btn-warning col-12 mt-2" />
            </form>
        </div>
    </div>
</c:if>
    
    <div>
        <div class="card text-bg-primary text-center mt-1" style="height: 200px;">
            <h2 class="card-header text-center">Chercher un Produit</h2>
            <div class="card-body d-flex align-items-center">
                <form action=<c:url value="/Produit"/> method="get">
                <div class="input-group">
                    <input type="hidden" name="action" value="getProduit"/>
                    <input type="text" name="id" class="form-control" placeholder="Entrer ID du produit..." />
                    
                    <button class="btn btn-danger" type="submit">
                        Rechercher
                    </button>
                </div>
            </form>
        </div>
    </div>
    <div class="mt-5 col-12 p-3">
        <button type="button" class="btn btn-danger col-12"><a href="<c:url value='/User?action=logout'/>" class="text-decoration-none text-light">Logout </a></button>
    </div>
</div>
</section>
<section>
    <h2>Liste des Produits : </h2>
    <table class="table table-hover table-dark">
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Nom</th>
            <th scope="col">Description</th>
            <th scope="col">Prix</th>
            <c:if test="${isAdmin}" >    
                <th scope="col">Actions</th>
            </c:if>
        </tr>
        <c:forEach var="p" items="${Produits}">
            <tr>
                <td>${p.id}</td>
                <td>${p.nom}</td>
                <td>${p.description}</td>
                <td>${p.prix}</td>
                <c:if test="${isAdmin}">
                    <td>
                        <a href=
                        <c:url value="/Produit">
                            <c:param name="action" value="editProduit"/>
                            <c:param name="id" value="${p.id}"/>
                        </c:url>
                        class="btn btn-primary">Modifier</a> |
                        <a href=
                        <c:url value="/Produit">
                            <c:param name="action" value="deleteProduit"/>
                            <c:param name="id" value="${p.id}"/>
                        </c:url> 
                        class="btn btn-danger" onclick="return confirm('Voulez-vous vraiment supprimer ce produit ?');">Supprimer</a>
                    </td>
                </c:if>
            </tr>
    </c:forEach>
</section>
</table>
</body>
</html>
