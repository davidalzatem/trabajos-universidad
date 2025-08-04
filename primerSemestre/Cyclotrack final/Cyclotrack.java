import java.util.ArrayList;
import java.util.Scanner;

public class Cyclotrack {
    private ArrayList<Usuario> listaUsuarios;
    private ArrayList<Ruta> listaRutas;

    // Constructor: carga datos desde archivos
    public Cyclotrack() {
        Archivos archivo = new Archivos();

        System.out.println("Cargando datos desde archivos...");

        // Se carga la información desde los archivos .csv y se almacena en arreglos dinamicos
        listaRutas = archivo.cargarRutas();
        listaUsuarios = archivo.cargarUsuarios(listaRutas);
        listaUsuarios = archivo.cargarEstadisticas(listaUsuarios);

        System.out.println("Datos cargados exitosamente.");

    }

    // Crea un nuevo usuario y lo agrega a la lista
    public void crearUsuario() {
        // Definición de variables
        Scanner teclado = new Scanner(System.in);
        int id;
        String nombre;
        String fecha_nacimiento;
        String email;
        String ciudad;
        String tipo_ciclismo;
        String modelo_bicicleta;
        ArrayList<Integer> arregloIdAmigos;
        ArrayList<Ruta> rutas_usuario;
        ArrayList<Estadisticas> arregloEstadisticas;

        // Entrada de datos por usuario
        System.out.println("Ingrese el ID del usuario:");
        id = teclado.nextInt();
        teclado.nextLine();

        System.out.println("Ingrese el nombre:");
        nombre = teclado.nextLine();

        System.out.println("Ingrese la fecha de nacimiento en formato \"yyyy-MM-dd\":");
        fecha_nacimiento = teclado.nextLine();

        System.out.println("Ingrese el email:");
        email = teclado.nextLine();

        System.out.println("Ingrese la ciudad:");
        ciudad = teclado.nextLine();

        System.out.println("Ingrese el tipo de ciclismo:");
        tipo_ciclismo = teclado.nextLine();

        System.out.println("Ingrese el modelo de bicicleta:");
        modelo_bicicleta = teclado.nextLine();

        arregloIdAmigos = new ArrayList<Integer>();
        rutas_usuario = new ArrayList<Ruta>();
        arregloEstadisticas = new ArrayList<Estadisticas>();

        System.out.println("Usuario creado con éxito.");

        // Se crea el nuevo usuario y se guarda en el arreglo dinamico con todos los usuarios del programa
        Usuario usuario = new Usuario(id, nombre, fecha_nacimiento, email, ciudad, tipo_ciclismo, modelo_bicicleta, arregloIdAmigos, rutas_usuario, arregloEstadisticas);
        listaUsuarios.add(usuario);

    }

    // Crea una nueva ruta y la agrega a la lista
    public void crearRuta() {
        // Definición de variables
        Scanner teclado = new Scanner(System.in);
        int idRuta;
        String nombreRuta;
        String origenRuta;
        String destinoRuta;
        int distanciaRuta;
        String tipoTerreno;
        String nivelDificultad;
        int elevacionRuta;

        // Entrada de datos por usuario
        System.out.println("Ingrese el ID de la ruta:");
        idRuta = teclado.nextInt();
        

        System.out.println("Ingrese el nombre de la ruta:");
        nombreRuta = teclado.nextLine();
        teclado.next();

        System.out.println("Ingrese el origen de la ruta:");
        origenRuta = teclado.nextLine();
        teclado.next();

        System.out.println("Ingrese el destino de la ruta:");
        destinoRuta = teclado.nextLine();
        teclado.next();

        System.out.println("Ingrese la distancia de la ruta:");
        distanciaRuta = teclado.nextInt();

        System.out.println("Ingrese el tipo de terreno de la ruta:");
        tipoTerreno = teclado.nextLine();
        teclado.next();

        System.out.println("Ingrese el nivel de dificultad de la ruta:");
        nivelDificultad = teclado.nextLine();
        teclado.next();

        System.out.println("Ingrese la elevación de la ruta:");
        elevacionRuta = teclado.nextInt();

        // Se crea el nuevo usuario y se guarda en el arreglo dinamico con todos los usuarios del programa
        Ruta ruta = new Ruta(idRuta, nombreRuta, origenRuta, destinoRuta, distanciaRuta, tipoTerreno, nivelDificultad, elevacionRuta);
        listaRutas.add(ruta);

    }

    // Busca ciclistas por nombre
    public void buscarCiclistasNombre() {
        Scanner teclado = new Scanner(System.in);
        String nombre;
        boolean encontrado;
        Usuario usuario;

        System.out.println("\n--- BUSCAR CICLISTA POR NOMBRE ---");
        System.out.print("Ingrese el nombre del ciclista que quiere buscar:");

        //se pide el nombre del ciclista y se inicializa la bandera en false
        nombre = teclado.nextLine();
        encontrado = false; 

        // Se busca el nombre del usuario entre todos los usuarios registrados en el arreglo
        for (int i = 0; i < listaUsuarios.size(); i++) {
            usuario = listaUsuarios.get(i);

            if (usuario.getNombre().equals(nombre)) {
                System.out.println("\nCiclista encontrado:"); 
         //si se encontro el usuario la bandera cambia a true y se imprime la info del usuario
                usuario.mostrarInformacionUsuario();
                encontrado = true; //s
            }
        }

        if (encontrado == false) {//si permanece en false significa que no se encontró
            System.out.println("No se encontró ningún ciclista con ese nombre.");
        }

    }

    // Busca ciclistas por ciudad
    public void buscarCiclistasPorCiudad() {
        Scanner teclado = new Scanner(System.in);
        String ciudad;
        boolean encontrado;
        Usuario usuario;

        System.out.println("\n--- BUSCAR CICLISTA POR CIUDAD ---");
        System.out.print("Ingrese la ciudad:");

        ciudad = teclado.nextLine();
        encontrado = false; //la bandera se inicializa en false (se asume que no se ha encontrado)

        // Se busca en los ciclistas que vengan de la ciudad usada como filtro
        for (int i = 0; i < listaUsuarios.size(); i++) {
            usuario = listaUsuarios.get(i);
        // si se encuentra, se cambia la bandera a true y se imprime la info del usuario encontrado
            if (usuario.getCiudad().equals(ciudad)) {
                System.out.println("\nCiclista encontrado:"); 
                usuario.mostrarInformacionUsuario();
                encontrado = true;
            }
        }
        //si no se encuentra:
        if (encontrado == false) {
            System.out.println("No se encontró ningún ciclista registrado en esa ciudad.");
        }

    }

    // Busca ciclistas por tipo de ciclismo
    public void buscarCiclistasporTipoCiclismo() {
        Scanner teclado = new Scanner(System.in);
        String ciclismo;
        boolean encontrado;
        Usuario usuario;

        System.out.println("\n--- BUSCAR CICLISTA POR TIPO DE CICLISMO ---");
        System.out.print("Ingrese el tipo de ciclismo:");
        //se ingresa el tipo de ciclismo por el cual se quiere buscar 
        ciclismo = teclado.nextLine(); 
        encontrado = false;

        // Se filtran los usuarios según el tipo de ciclismo que practican
        for (int i = 0; i < listaUsuarios.size(); i++) {
            usuario = listaUsuarios.get(i); 
        //si coincide el tipo de ciclismo ingresado por el usuario, se cambia la bandera a true y se imprime la info 
            if (usuario.getTipoCiclismo().equals(ciclismo)) { 
                System.out.println("\nCiclista encontrado:");
                usuario.mostrarInformacionUsuario();
                encontrado = true; 
            }
        }

        if (encontrado == false) {
            System.out.println("No se encontró ningún ciclista registrado con este tipo de ciclismo.");
        }

    }

    // Busca ciclistas por ID
    public void buscarCiclistasporId() {
        Scanner teclado = new Scanner(System.in);
        int id;
        boolean encontrado;
        Usuario usuario;

        System.out.println("\n--- BUSCAR CICLISTA POR ID ---");
        System.out.print("Ingrese el id del ciclista a buscar:");

        id = teclado.nextInt(); //se le pide el id al usuario
        encontrado = false;

        // Se busca el ID del usuario entre todos los usuarios registrados en el arreglo
        for (int i = 0; i < listaUsuarios.size(); i++) {
            usuario = listaUsuarios.get(i);
        //si el id coincide con el ingresado por el usuario, cambia bandera a true y se imprime info de usuario
            if (usuario.getId() == id) {
                System.out.println("\nCiclista encontrado:"); 
                usuario.mostrarInformacionUsuario();            
                encontrado = true;                            
            }
        }
        //si no se encuentra:
        if (encontrado == false) {
            System.out.println("No se encontró ningún ciclista registrado con este ID. ");
        }

    }

    // Lista usuarios ordenados por nombre
    public void listarUsuariosPorNombre() {
        //verifica si hay usuarios registrados
        System.out.println("\n--- LISTANDO USUARIOS POR NOMBRE");
        if (listaUsuarios.size() == 0) {
            System.out.println("No hay usuarios registrados.");
            return;
        }

        // Copiar lista para no modificar la original
        ArrayList<Usuario> usuariosOrdenados = new ArrayList<>();
        for (int i = 0; i < listaUsuarios.size(); i++) {
            usuariosOrdenados.add(listaUsuarios.get(i));
        }
        // Algoritmo de burbuja
        for (int i = 0; i < usuariosOrdenados.size() - 1; i++) {
            for (int j = 0; j < usuariosOrdenados.size() - 1 - i; j++) {
                String nombre1;
                String nombre2;

                nombre1 = usuariosOrdenados.get(j).getNombre().toLowerCase();
                nombre2 = usuariosOrdenados.get(j + 1).getNombre().toLowerCase();
                //si no estan en la posicion correcta se hace swap
                
                if (nombre1.compareTo(nombre2) > 0) { //metodo compareTo sacado de chatGpt para ordenar alfabeticamente
                                                      
                    Usuario temp = usuariosOrdenados.get(j);
                    usuariosOrdenados.set(j, usuariosOrdenados.get(j + 1));
                    usuariosOrdenados.set(j + 1, temp);
                }
            }
        }
        //imprimir los usuarios ordenados
        for (int i = 0; i < usuariosOrdenados.size(); i++) {
            usuariosOrdenados.get(i).mostrarInformacionUsuario();
        }

    }

    // Lista usuarios por tipo de ciclismo
    public void listarUsuariosTipoCiclismo() {
        System.out.println("\n--- LISTANDO USUARIOS POR TIPO DE CICLISMO");
        System.out.print("Ingrese el nombre del tipo de ciclismo por el cual quiere listar:");
        
        //verificar si hay usuarios registrados
        if (listaUsuarios.size() == 0) {
            System.out.println("No hay usuarios registrados.");
            return;
        }
    
        Scanner teclado = new Scanner(System.in);
        String tipo;
        Usuario usuario;
        boolean encontrado;

        encontrado = false;
        tipo = teclado.nextLine();

        // Se enlistan los usuarios que tengan en común el tipo de ciclismo filtrado por el usuario
        for (int i = 0; i < listaUsuarios.size(); i++) {
            usuario = listaUsuarios.get(i);                 
            if (tipo.equals(usuario.getTipoCiclismo())) {   
                usuario.mostrarInformacionUsuario();    
                encontrado = true;
            }
        }
        
        if (encontrado == false) {
            System.out.println("No se encontraron usuarios con ese tipo de ciclismo para listar.");
        }

    }

    // Lista usuarios ordenados por edad (mayor a menor)
    public void listarUsuarioEdad() {

        System.out.println("\n--- LISTANDO USUARIOS POR EDAD");
        if (listaUsuarios.size() == 0) {
            System.out.println("No hay usuarios registrados.");
            return;
        }

        ArrayList<Usuario> usuariosOrdenados = new ArrayList<>(); // copiar la lista original
        for (int i = 0; i < listaUsuarios.size(); i++) {
            usuariosOrdenados.add(listaUsuarios.get(i));
        }

        for (int i = 0; i < usuariosOrdenados.size() - 1; i++) { // algoritmo de burbuja para ordenar de mayor a menor
                                                                 // edad
            for (int j = 0; j < usuariosOrdenados.size() - 1 - i; j++) {
                int edad1 = usuariosOrdenados.get(j).calcularEdad();
                int edad2 = usuariosOrdenados.get(j + 1).calcularEdad();
                if (edad1 < edad2) {
                    Usuario temp = usuariosOrdenados.get(j);
                    usuariosOrdenados.set(j, usuariosOrdenados.get(j + 1));
                    usuariosOrdenados.set(j + 1, temp);
                }
            }
        }
        
        //imprimir los usuarios ordenados de mayor a menor edad.
        for (int i = 0; i < usuariosOrdenados.size(); i++) {
            usuariosOrdenados.get(i).mostrarInformacionUsuario();
            System.out.println("Edad: " + usuariosOrdenados.get(i).calcularEdad());
        }

    }

    // Obtiene un usuario por su ID (método privado)
    private Usuario obtenerUsuarioPorId(int id) {//funcion privada porque solo se usa en esta clase
        for (int i = 0; i < listaUsuarios.size(); i++) { 
            if (listaUsuarios.get(i).getId() == id) {
                return listaUsuarios.get(i);
            }
        }
        return null;
    }

    // Conecta dos ciclistas como amigos
    public void conectarseCiclistas() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("\n--- CONECTARSE CON OTRO CICLISTA ---");
    //validar si hay al menos 2 ciclistas(usuarios)
        if (listaUsuarios.size() < 2) {
            System.out.println("Debe haber al menos 2 usuarios registrados para conectarse.");
            return;
        }
        // Mostrar usuarios para que puedan elegir
        System.out.println("\nUsuarios registrados:");

        for (int i = 0; i < listaUsuarios.size(); i++) {
            Usuario u = listaUsuarios.get(i);
            System.out.println("ID: " + u.getId() + " - Nombre: " + u.getNombre());
        }

        // elegir el usuario actual
        System.out.print("\nIngrese su ID: ");
        int idUsuario1;
        Usuario usuario1;
        Usuario usuario2;

        idUsuario1 = teclado.nextInt();
        usuario1 = obtenerUsuarioPorId(idUsuario1);

        if (usuario1 == null) {
            System.out.println("Usuario no encontrado.");
            return;
        }

        // Elegir usuario con quien se quiere conectar
        System.out.println("Ingrese el ID del ciclista con quien desea conectarse: ");
        int idUsuario2 = teclado.nextInt();
        
        //verificar que no se esté conectando consigo mismo
        if (idUsuario1 == idUsuario2) {
            System.out.println("No puede conectarse consigo mismo.");
            return;
        }
        
        //obtenemos el usuario 2
        usuario2 = obtenerUsuarioPorId(idUsuario2);
        if (usuario2 == null) {
            System.out.println("Ciclista no encontrado.");
            return;
        }

        // verificamos si ya estan conectados
        boolean yaConectados = false;
        ArrayList<Integer> amigos = usuario1.getArregloIdAmigos();

        for (int i = 0; i < amigos.size(); i++) {
            if (amigos.get(i) == idUsuario2) {
                yaConectados = true;
            }
        }
        // Validar resultado
        if (yaConectados == true) {
            System.out.println("Ya estás conectado con este ciclista.");
        }

        else {
            // Agregar como amigos mutuamente
            usuario1.getArregloIdAmigos().add(idUsuario2);
            usuario2.getArregloIdAmigos().add(idUsuario1);

            System.out.println("¡Conexión realizada con éxito!");

        }

    }

    // Asocia una ruta a un usuario
    public void asociarRutaUsuario() {
        Scanner teclado = new Scanner(System.in);
        int idU;
        int idR;
        boolean usuarioEncontrado = false;
        boolean rutaEncontrada = false;
        boolean yaAsociada = false;

        System.out.println("\n--- ASOCIAR RUTA A USUARIO ---");
        System.out.print("Ingrese el ID del usuario al cual quiere vincular una ruta: ");
        idU = teclado.nextInt();

        Usuario usuario = null;

        // Buscar el usuario por ID
        for (int i = 0; i < listaUsuarios.size(); i++) {
            if (listaUsuarios.get(i).getId() == idU) {
                usuario = listaUsuarios.get(i);
                usuarioEncontrado = true;
            }
        }
        //validar que se encuentre el usuario
        if (!usuarioEncontrado) {
            System.out.println(" No se encontró un usuario con ese ID.");
            return;
        }

        // Mostrar las rutas disponibles
        System.out.println("\nEstas son las rutas disponibles:");
        for (int i = 0; i < listaRutas.size(); i++) {
            Ruta ruta = listaRutas.get(i);
            System.out.println("ID Ruta: " + ruta.getIdRuta() + " - Nombre: " + ruta.getNombreRuta());
        }

        System.out.print("Ingrese el ID de la ruta que quiere asociar al usuario: ");
        idR = teclado.nextInt();

        Ruta rutaSeleccionada = null;

        // Buscar la ruta por ID
        for (int i = 0; i < listaRutas.size(); i++) {
            if (listaRutas.get(i).getIdRuta() == idR) {
                rutaSeleccionada = listaRutas.get(i);
                rutaEncontrada = true;
            }
        }
        
        // verificar que se encuentre la ruta
        if (!rutaEncontrada) {
            System.out.println(" No se encontró una ruta con ese ID.");
            return;
        }

        // Verificar si la ruta ya está asociada al usuario
        ArrayList<Ruta> rutasAsociadas = usuario.getRutasUsuario();
        for (int i = 0; i < rutasAsociadas.size(); i++) {
            if (rutasAsociadas.get(i).getIdRuta() == idR) {
                yaAsociada = true;
            }
        }
        
        //verificar que la ruta no este asociada
        if (yaAsociada) {
            System.out.println(" Esta ruta ya está asociada al usuario.");
            return;
        
        //si no está asociada se añade al usuario
        } else {
            usuario.agregarRuta(rutaSeleccionada);
            System.out.println(" Ruta asociada exitosamente al usuario.");
        }
    }

    // Muestra los amigos de un usuario
    public void mostrarAmigosUsuario(){
        Scanner teclado = new Scanner(System.in);
        ArrayList<Integer> amigos;
        Usuario amigo;
    //se pide el id de quien se quiere ver los amigos
        System.out.println("\n--- MOSTRAR AMIGOS DE USUARIO ---");
        System.out.print("Ingrese el ID del usuario del cual quiere ver sus amigos: ");
        int idU = teclado.nextInt();

        Usuario user = obtenerUsuarioPorId(idU);
        amigos = user.getArregloIdAmigos();

        // Se enlistan los amigos del usuario
        for (int i = 0; i < amigos.size(); i++){
            amigo = obtenerUsuarioPorId(amigos.get(i));
            System.out.println("ID: " + amigo.getId() + " Nombre: " + amigo.getNombre());

        }

    }

    // Muestra las estadísticas de un usuario
    public void mostrarEstadisticasUsuario() {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Ingrese el ID del usuario: ");
        int id = teclado.nextInt();
        Usuario usuario = obtenerUsuarioPorId(id);

        // Se enlistan las estadisticas del usuario
        if (usuario != null) {
            usuario.mostrarEstadisticasUsuario();
        } else {
            System.out.println("No se encontró ningún usuario con ese ID.");
        }

    }

    // Añade estadísticas a un usuario
    public void añadirEstadisticasUsuario() { 
        Scanner teclado = new Scanner(System.in);
        System.out.print("Ingrese el ID del usuario del cual va a actualizar las estadisticas: ");
        int id = teclado.nextInt();        
        Usuario usuario = obtenerUsuarioPorId(id);

        if (usuario != null) {
            // Definición de variables
            Estadisticas est;
            float distancia;
            String nombreRuta;
            int tiempo;
            int idruta; 
            float ftp;

            // Entrada de datos por usuario
            System.out.print("Ingrese nombre de la ruta a la cual quiere añadir estadisticas: ");
            nombreRuta = teclado.next();

            System.out.print("Ingrese el nuevo id de ruta a la cual quiere añadir estadisticas: ");
            idruta = teclado.nextInt();

            System.out.print("Ingrese la distancia recorrida: ");
            distancia = teclado.nextFloat();

            System.out.print("Ingrese el nuevo tiempo (en minutos): ");
            tiempo = teclado.nextInt();
           
            System.out.print("Ingrese el nuevo FTP: ");
            ftp= teclado.nextFloat();

            // Se crea la nueva estadistica y se guarda en el arreglo dinamico de estadisticas del usuario
            est = new Estadisticas(idruta,nombreRuta,distancia,tiempo,ftp); //crear nuevo objeto de la variable estadisticas y añadirlo al arreglo de estadisticas de cada usuario
            usuario.getArregloEstadistica().add(est);

            System.out.println("¡Estadísticas actualizadas con éxito!");
        } else {
            System.out.println("No se encontró ningún usuario con ese ID.");
        }
    }   

    // Muestra el leaderboard (mejores tiempos) de una ruta
    public void mostrarLeaderboardPorRuta() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese el ID de la ruta de la cual quiere visualizar los mejores tiempos");
        int idRuta = teclado.nextInt();

        // Contar cuántas estadísticas corresponden a ese ID de ruta
        int total = 0;
        for (int i = 0; i < listaUsuarios.size(); i++) { //obtener cada usuario y su arreglo de estadisticas

            Usuario u = listaUsuarios.get(i);
            ArrayList<Estadisticas> estadisticas = u.getArregloEstadistica();       

            for (int j = 0; j < estadisticas.size(); j++) { //contar cuantas veces esta esa ruta en el usuario 
                Estadisticas est = estadisticas.get(j);

                if (est.getIdRuta() == idRuta) {
                    total = total + 1;
                }
            }
        }
        
        
        if(total==0){
            System.out.println("Ningún ciclista ha registrado esa ruta.");
            return;
        }

        // paso 2: aca preparamos los arreglos con los participantes y con los tiempos
        // de cada uno
        Usuario[] participantes = new Usuario[total];
        int[] tiempos = new int[total];

        int indice = 0;
        for(int i = 0; i <listaUsuarios.size(); i++){     //cada vez que se ejecute este ciclo sacamos el arreglo 
        Usuario u = listaUsuarios.get(i);                  //de estadisticas de cada usuario
        ArrayList<Estadisticas> estadisticas = u.getArregloEstadistica();

        
        for (int j = 0; j < estadisticas.size(); j++) {  //cada vez que se ejecuta este ciclo, se cuenta cuantas rutas (id) 
            Estadisticas est = estadisticas.get(j);       //  hay en las estadisticas que coincidan con la buscada
                                                                            
            if (est.getIdRuta() == idRuta) {
                participantes[indice] = u;
                tiempos[indice] = est.getTiempoMinutos();
                indice=indice+1;
            }
        }
    }

        // Paso 3: ordenamos con algoritmo de  burbuja por tiempo (menor a mayor)
        for(int i = 0 ; i <total-1; i++){

            for (int j = 0; j < total - 1 - i; j++) {

                if (tiempos[j] > tiempos[j + 1]) {
                int temp = tiempos[j];
                tiempos[j] = tiempos[j + 1];                   //swap para intercambiar tiempos y dejarlos ordenados
                tiempos[j + 1] = temp;

                Usuario tempu = participantes[j];
                participantes[j] = participantes[j + 1];        // swap para intercambiar usuarios ordenados 
                participantes[j + 1] = tempu;

            }
        }
    }

    // Paso 4: mostramos el leaderboard (lo imprimimos)
  
     System.out.println("LEADERBOARD para la ruta con ID: " + idRuta);
          //este formato de imprimir nos la dio chat gpt
     for (int i = 0; i < total; i++) {
         System.out.println((i + 1) + ". " + participantes[i].getNombre() + " - Tiempo: " + tiempos[i] + " minutos");
       
        }

    }

    // Devuelve la lista de rutas
    public ArrayList<Ruta> getArrayRutas(){
        return listaRutas;

    }

    // Devuelve la lista de usuarios
    public ArrayList<Usuario> getArrayUsuarios(){

        return listaUsuarios;

    }

    // Muestra todas las rutas registradas
    public void mostrarRutasRegistradas(){
        System.out.println("\nRutas registradas:\n");
        for (int i = 0; i < listaRutas.size(); i++) {
            System.out.println("------------------------------");
            listaRutas.get(i).mostrarInformacionRuta();            
        }

    }

    // Muestra las rutas asociadas a un usuario
    public void mostrarRutasUsuario(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el ID del usuario del cual quieres conocer sus rutas: ");
        int id = sc.nextInt();
        Usuario user = obtenerUsuarioPorId(id);
        ArrayList<Ruta> rutasUsuario = user.getRutasUsuario();

        System.out.println("Rutas del usuario llamado " + user.getNombre());


        for (int i = 0; i < rutasUsuario.size(); i++) {
            System.out.println("------------------------------");
            rutasUsuario.get(i).mostrarInformacionRuta();
        }
    }

    // Método principal: inicia el programa y muestra el menú
    public static void main(String[] args) {
        Cyclotrack cyclotrack = new Cyclotrack();
        Menu menu = new Menu();

        System.out.println("--- BIENVENIDO A CYCLOTRACK ---");

        // Se ejecuta el menu principal
        menu.menuPrincipal(cyclotrack);

    }

}
