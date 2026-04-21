<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>
    <title>Document</title>
</head>
<body>
    <section class="container mt-5 col-12">
        <div class="card col-10 ms-2">
            <h2 class="card-header text-center">Connectez-vous !!</h2>
            <div class="card-body">
                <form action=<c:url value="/User?action=login" /> method="post">
                    <label class="form-label">Nom d'utilisateur : </label>
                    <input class="form-control" type="text" name="username" required/>
                    <label class="form-label">Mot de passe : </label>
                    <input class="form-control" type="password" name="password" required/>
                    <input type="submit" value="Connecter" class="btn btn-primary mt-3">
                </form>
            </div>
            <div class="card-footer"></div>
        </div>
        </section>
</body>
</html>