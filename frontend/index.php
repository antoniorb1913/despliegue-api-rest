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
                            <?php if ($pet['adopt'] === FALSE): ?>
                                <td><button onclick="adoptPet(<?= $pet['id'] ?>)">Adoptar</button></td>
                            <?php else: ?>
                                <td><span>Adoptado</span></td>
                            <?php endif; ?>

                        </tr>
                    <?php endforeach; ?>
        </table> 
<script>
    // Esta función se llama cuando haces clic en "Adoptar"
    function adoptPet(petId) {
        // Le decimos al servidor que queremos adoptar la mascota con este ID
        fetch('http://localhost:8080/pet/adopt/' + petId, { 
            method: 'PUT' 
        })
        .then(response => {
            if (response.ok) {
                // Si todo va bien, recarga la página para ver el cambio
                location.reload();
            } else {
                // Si hay algún problema, muestra un mensaje
                alert('Error al adoptar la mascota');
            }
        })
        .catch(error => 
            // Si hay un error al hacer la petición, lo mostramos en la consola
            console.error('Error:', error)
        );
    }
</script>

    </body>
</html>