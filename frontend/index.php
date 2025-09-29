<?php 
    $url = "http://localhost:8080/pet/list?";
    $data = file_get_contents($url);
    $pets = json_decode($data, true);
      // var_dump($pets)

?>
<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
        <title>Listado de mascotas</title>
    </head>
    <body>
        <table class="table table-striped">
                <thead>
                <h1 style="text-align: center;">Listado de mascotas</h1>
                <br>
                    <tr>
                        <td>ID</td>
                        <td>NAME</td>
                        <td>CHIP</td>
                        <td>CATEGORY</td>
                        <td>BORN</td>
                        <td>ADOPT<td>
                    </tr>
                </thead>
                <tbody>
                    <?php foreach($pets as $pet): ?>
                        <tr>
                            <td><?php echo $pet['id'] ?></td>
                            <td><?php echo $pet['name'] ?></td>
                            <td><?php echo $pet['chip'] ?></td>
                            <td><?php echo $pet['category'] ?></td>
                            <td><?php echo $pet['born'] ?></td>
                            <td><?php echo $pet['born'] ?></td>
                            <td><?php if ($pet['adopt'] === FALSE): ?>
                                <form method="post" action="http://localhost:8080/pet/adopt/<?=$pet['id']?>">
                                    <button type="submit">Adoptar</button>
                                <?php else: ?>
                                    <span>Adoptado</span>
                                <?php endif; ?>
                                </form>
                            </td>
                        </tr>
                    <?php endforeach; ?>
        </table> 
    </body>
</html>