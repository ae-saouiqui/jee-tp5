<%@ page isErrorPage="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Error Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>
</head>
<body>

<h2>Error</h2>

<c:choose>
    <c:when test="${not empty exception}">
        <div class="card text-bg-danger container col-7">
                <p class="card-body display-6 text-center">${exception.message}</p>
        </div>
    </c:when>
    <c:otherwise>
        <div class="card text-bg-primary container col-7">
            <p class="card-body display-6 text-center">${message}</p>
        </div>
    </c:otherwise>
</c:choose>

<button class="btn btn-primary container col-5 text-center mt-2">
    <a href="<c:url value='/Produit'/>"  class="text-decoration-none text-light">
        Retourner  la page principale
    </a>
</button>

</body>
</html>