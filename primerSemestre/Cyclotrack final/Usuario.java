import java.util.ArrayList;

public class Usuario {

    // Atributos de la clase Usuario
    private int id;                                 // Identificador único del usuario
    private String nombre;                          // Nombre del usuario
    private String fecha_nacimiento;                // Fecha de nacimiento del usuario (formato "yyyy-MM-dd")
    private String email;                           // Correo electrónico del usuario
    private String ciudad;                          // Ciudad de residencia del usuario
    private String tipo_ciclismo;                   // Tipo de ciclismo que practica el usuario
    private String modelo_bicicleta;                // Modelo de bicicleta del usuario
    private ArrayList<Integer> arregloIdAmigos;     // Lista de IDs de amigos del usuario
    private ArrayList<Ruta> rutas_usuario;          // Lista de rutas registradas por el usuario
    private ArrayList<Estadisticas> arregloEstadisticas; // Lista de estadísticas del usuario

    // Constructor por defecto de la clase Usuario
    public Usuario() {
        id = 0;
        nombre = "";
        fecha_nacimiento = "";
        email = "";
        ciudad = "";
        tipo_ciclismo = "";
        modelo_bicicleta = "";
        arregloIdAmigos = new ArrayList<Integer>();
        rutas_usuario = new ArrayList<Ruta>();
        arregloEstadisticas = new ArrayList<Estadisticas>();
    }

    // Constructor con parámetros para inicializar todos los atributos del usuario
    public Usuario(int id, String nombre, String fecha_nacimiento, String email, String ciudad, String tipo_ciclismo,
            String modelo_bicicleta, ArrayList<Integer> arregloIdAmigos, ArrayList<Ruta> rutas_usuario, ArrayList<Estadisticas> arregloEstadisticas) {
                

        this.id = id;
        this.nombre = nombre;
        this.fecha_nacimiento = fecha_nacimiento;
        this.email = email;
        this.ciudad = ciudad;
        this.tipo_ciclismo = tipo_ciclismo;
        this.modelo_bicicleta = modelo_bicicleta;
        this.arregloIdAmigos = arregloIdAmigos;
        this.rutas_usuario = rutas_usuario;
        this.arregloEstadisticas = arregloEstadisticas;
    }

    // Método para mostrar la información del usuario por consola
    public void mostrarInformacionUsuario() {
        System.out.println("Información del Usuario:");
        System.out.println("ID: " + id);
        System.out.println("Nombre: " + nombre);
        System.out.println("Fecha de Nacimiento: " + fecha_nacimiento);
        System.out.println("Email: " + email);
        System.out.println("Ciudad: " + ciudad);
        System.out.println("Tipo de Ciclismo: " + tipo_ciclismo);
        System.out.println("Modelo de Bicicleta: " + modelo_bicicleta);
        System.out.println("Rutas Registradas: " + rutas_usuario.size());
        mostrarEstadisticasUsuario();
    }

    // Método para mostrar las estadísticas del usuario por consola
    public void mostrarEstadisticasUsuario(){
        System.out.println("Estadisticas del usuario llamado " + nombre);

        if (arregloEstadisticas.isEmpty()) {
            System.out.println("No hay estadisticas registradas para este usuario.");
        } else {
            for (int i = 0; i < arregloEstadisticas.size(); i++) {
                Estadisticas estadistica = arregloEstadisticas.get(i);
                System.out.println("------------------------");
                System.out.println("Ruta: " + estadistica.getNombreRuta());
                System.out.println("Kilómetros: " + estadistica.getKilometros());
                System.out.println("Tiempo: " + estadistica.getTiempoMinutos());
                System.out.println("FTP: " + estadistica.getFtp());
            }
        }
    }

    // Método para mostrar las rutas registradas por el usuario
    public void mostrarRutasUsuario() {
        if (rutas_usuario.isEmpty()) {
            System.out.println("No hay rutas registradas.");
        } else {
            System.out.println("Rutas Registradas:");
            for (int i = 0; i < rutas_usuario.size(); i++) {
                rutas_usuario.get(i).mostrarInformacionRuta();
            }
        }
    }

    // Método para agregar una ruta a la lista de rutas del usuario
    public void agregarRuta(Ruta ruta) {
        rutas_usuario.add(ruta);
    }

    // Método para calcular la edad del usuario a partir de la fecha de nacimiento
    public int calcularEdad() {
        // Asumimos que la fecha viene en formato "yyyy-MM-dd"
        int añoNacimiento = 0;
        int mesNacimiento = 0;
        int diaNacimiento = 0;
        
        //chat gpt nos ayudo con este bloque del codigo 
        String[] partes = fecha_nacimiento.split("-");
        if (partes.length == 3) {
            añoNacimiento = Integer.parseInt(partes[0]);
            mesNacimiento = Integer.parseInt(partes[1]);
            diaNacimiento = Integer.parseInt(partes[2]);
        }

        int añoActual = 2025;
        int mesActual = 5; // mayo
        int diaActual = 30;

        int edad = añoActual - añoNacimiento;

        // Ajustar si aún no ha cumplido años este año  
        //chat gpt nos ayudo con esta validación
        if (mesActual < mesNacimiento || (mesActual == mesNacimiento && diaActual < diaNacimiento)) {
            edad--;
        }
        return edad;
    }

    // Métodos Getters para obtener los valores de los atributos

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getFechaNacimiento() {
        return fecha_nacimiento;
    }

    public String getEmail() {
        return email;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getTipoCiclismo() {
        return tipo_ciclismo;
    }

    public String getModeloBicicleta() {
        return modelo_bicicleta;
    }

    public ArrayList<Integer> getArregloIdAmigos() {
        return arregloIdAmigos;
    }

    public ArrayList<Ruta> getRutasUsuario() {
        return rutas_usuario;
    }

    public ArrayList<Estadisticas> getArregloEstadistica() {
        return arregloEstadisticas;
    }

    // Métodos Setters para modificar los valores de los atributos

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFechaNacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setTipoCiclismo(String tipo_ciclismo) {
        this.tipo_ciclismo = tipo_ciclismo;
    }

    public void setModeloBicicleta(String modelo_bicicleta) {
        this.modelo_bicicleta = modelo_bicicleta;
    }

    public void setArregloIdAmigos(ArrayList<Integer> arregloIdAmigos) {
        this.arregloIdAmigos = arregloIdAmigos;
    }

    public void setRutasUsuario(ArrayList<Ruta> rutas_usuario) {
        this.rutas_usuario = rutas_usuario;
    }

    public void setEstadistica(ArrayList<Estadisticas> arregloEstadisticas) {
        this.arregloEstadisticas = arregloEstadisticas;
    }

}