<%@ page contentType="text/html;charset=UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h1>Login</h1>
       <form action="LoginServlet" method="POST">
            <div>
              <label for="sizesInputDefault" class="form-label">Usuario</label>
              <input class="form-control" type="text" id="sizesInputDefault" placeholder="Default input" aria-label="Default input example">
            </div>
            <div>
              <label for="sizesInputDefault" class="form-label">Contraseña</label>
              <input class="form-control" type="text" id="sizesInputDefault" placeholder="Default input" aria-label="Default input example">
            </div>
            <button type="submit" class="btn btn-primary">
                                    Iniciar Sesion
                                </button>
       </form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>
</body>
</html>