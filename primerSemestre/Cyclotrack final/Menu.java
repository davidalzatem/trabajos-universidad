import java.util.Scanner;

public class Menu {

    // Scanner para la entrada de datos por consola
    private Scanner teclado = new Scanner(System.in);

    // Método principal que muestra el menú principal y gestiona las opciones del usuario
    public void menuPrincipal(Cyclotrack cyclotrack) {
        Archivos archivo = new Archivos(); // Objeto para gestionar archivos
        int opcion = 0;

        // Bucle principal del menú, se repite hasta que el usuario elija salir
        while (opcion != 14) {
            System.out.println("\n====== MENÚ PRINCIPAL ======");
            System.out.println("1. Crear usuario");
            System.out.println("2. Crear ruta");
            System.out.println("3. Buscar ciclistas");
            System.out.println("4. Listar usuarios");
            System.out.println("5. Conectarse con ciclistas");
            System.out.println("6. Asociar ruta a usuario");
            System.out.println("7. Añadir estadisticas a usuario");
            System.out.println("8. Mostrar estadisticas de usuario");
            System.out.println("9. Mostrar amigos de usuario");
            System.out.println("10. Mostrar leaderboard por ruta.");
            System.out.println("11. Mostrar rutas registradas");
            System.out.println("12. Mostrar rutas de usuario");
            System.out.println("13. Guardar y salir");
            System.out.println("14. Salir sin guardar");
            System.out.print("Seleccione una opción: ");
            opcion = teclado.nextInt();

            // Estructura de control para cada opción del menú
            if (opcion == 1) {
                cyclotrack.crearUsuario(); // Crear un nuevo usuario
            } else if (opcion == 2) {
                cyclotrack.crearRuta(); // Crear una nueva ruta
            } else if (opcion == 3) {
                submenuBuscarCiclistas(cyclotrack); // Submenú para buscar ciclistas
            } else if (opcion == 4) {
                submenuListarUsuarios(cyclotrack); // Submenú para listar usuarios
            } else if (opcion == 5) {
                cyclotrack.conectarseCiclistas(); // Conectarse con otros ciclistas
            } else if (opcion == 6) {
                cyclotrack.asociarRutaUsuario(); // Asociar una ruta a un usuario
            } else if (opcion == 7) {
                cyclotrack.añadirEstadisticasUsuario(); // Añadir estadísticas a un usuario
            } else if (opcion == 8) {
                cyclotrack.mostrarEstadisticasUsuario(); // Mostrar estadísticas de un usuario
            } else if (opcion == 9) {
                cyclotrack.mostrarAmigosUsuario(); // Mostrar amigos de un usuario
            } else if (opcion == 10) {
                cyclotrack.mostrarLeaderboardPorRuta(); // Mostrar leaderboard por ruta (comentado)
            } else if (opcion == 11){
                cyclotrack.mostrarRutasRegistradas(); // Mostrar todas las rutas registradas
            } else if (opcion == 12){
                cyclotrack.mostrarRutasUsuario(); // Mostrar rutas de un usuario
            } else if (opcion == 13) {
                // Guardar datos en archivos y salir
                System.out.println("Guardando datos");

                archivo.guardarRutas(cyclotrack.getArrayRutas());
                archivo.guardarUsuarios(cyclotrack.getArrayUsuarios());
                archivo.guardarEstadisticas(cyclotrack.getArrayUsuarios());

                System.out.println("Datos guardados correctamente.");
                System.out.println("\nSaliendo del programa...");

                opcion = 14; // Termina el bucle y sale del programa

            } else if (opcion == 14){
                // Salir sin guardar
                System.out.println("\nSaliendo del programa...");

            } else {
                // Opción inválida
                System.out.println("Opción inválida. Intente de nuevo.");
            }

        }
    }

    // Submenú para buscar ciclistas según diferentes criterios
    private void submenuBuscarCiclistas(Cyclotrack cyclotrack) {
        int opcion = -1;

        while (opcion != 0) {
            System.out.println("\n--- BUSCAR CICLISTAS ---");
            System.out.println("1. Buscar por nombre");
            System.out.println("2. Buscar por ciudad");
            System.out.println("3. Buscar por tipo de ciclismo");
            System.out.println("4. Buscar por ID");
            System.out.println("0. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = teclado.nextInt();

            if (opcion == 1) {
                cyclotrack.buscarCiclistasNombre(); // Buscar ciclistas por nombre
            } else if (opcion == 2) {
                cyclotrack.buscarCiclistasPorCiudad(); // Buscar ciclistas por ciudad
            } else if (opcion == 3) {
                cyclotrack.buscarCiclistasporTipoCiclismo(); // Buscar ciclistas por tipo de ciclismo
            } else if (opcion == 4) {
                cyclotrack.buscarCiclistasporId(); // Buscar ciclistas por ID
            } else if (opcion == 0) {
                System.out.println("Volviendo al menú principal...");
            } else {
                System.out.println("Opción inválida. Intente de nuevo.");
            }
            
        }
    }

    // Submenú para listar usuarios según diferentes criterios
    private void submenuListarUsuarios(Cyclotrack cyclotrack) {
        int opcion = -1;

        while (opcion != 0) {
            System.out.println("\n--- LISTAR USUARIOS ---");
            System.out.println("1. Listar por nombre (ordenado)");
            System.out.println("2. Listar por tipo de ciclismo");
            System.out.println("3. Listar por edad (ordenado)");
            System.out.println("0. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = teclado.nextInt();

            if (opcion == 1) {
                cyclotrack.listarUsuariosPorNombre(); // Listar usuarios por nombre
            } else if (opcion == 2) {
                cyclotrack.listarUsuariosTipoCiclismo(); // Listar usuarios por tipo de ciclismo
            } else if (opcion == 3) {
                cyclotrack.listarUsuarioEdad(); // Listar usuarios por edad
            } else if (opcion == 0) {
                System.out.println("Volviendo al menú principal...");
            } else {
                System.out.println("Opción inválida. Intente de nuevo.");
            }

        }
    }
}