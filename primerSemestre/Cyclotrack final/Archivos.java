import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Archivos {

    // Metodos para guardar información en archivos del tipo csv

    // Método para guardar los usuarios desde el archivo Usuarios.csv
    public void guardarUsuarios(ArrayList<Usuario> usuarios) {

        // Definición de variables
        FileWriter fw = null;
        BufferedWriter br;
        PrintWriter pw = null;
        String informacionLinea; 
        String idAmigos;
        String idRutas;
        ArrayList<Ruta> rutasUsuario;  

        try {

            fw = new FileWriter("Usuarios.csv");
            br = new BufferedWriter(fw);
            pw = new PrintWriter(br);
            
            // Se hace un ciclo para guardar usuario por usuario
            for (int i = 0; i < usuarios.size(); i++){

                idAmigos = "";
                idRutas = "";
                Usuario usuario = usuarios.get(i);
                rutasUsuario = usuarios.get(i).getRutasUsuario();

                // Añadir información del id de amigos
                for (int j = 0; j < usuario.getArregloIdAmigos().size(); j++){

                    idAmigos += usuario.getArregloIdAmigos().get(j);

                    if (j < usuario.getArregloIdAmigos().size() - 1) {
                        idAmigos += "/";
                        
                    } 

                }

                // Añadir información del id de las rutas
                for (int j = 0; j < usuario.getRutasUsuario().size(); j++){
                   
                    idRutas += rutasUsuario.get(j).getIdRuta();

                    if (j < usuario.getRutasUsuario().size() - 1) {
                        idRutas += "/";
                        
                    }

                }

                // Añadir al archivo                
                informacionLinea = usuario.getId() + "," + usuario.getNombre() + "," + usuario.getFechaNacimiento() + "," + usuario.getEmail() + "," + usuario.getCiudad() + "," + usuario.getTipoCiclismo() + "," + usuario.getModeloBicicleta() + "," + idAmigos + "," + idRutas;
                pw.println(informacionLinea);
                
            }

            pw.flush();
            fw.close();

        } catch (Exception e) {

            System.err.println("Error escribiendo: " + e.getMessage());
            
        }

    }

    // Método para guardar las rutas desde el archivo Rutas.csv
    public void guardarRutas(ArrayList<Ruta> rutas){
        // Definición de variables
        FileWriter fw = null;
        BufferedWriter br;
        PrintWriter pw = null;
        String informacionLinea; 

        try {

            fw = new FileWriter("Rutas.csv");
            br = new BufferedWriter(fw);
            pw = new PrintWriter(br);
            
            // Se hace un ciclo para guardar ruta por ruta
            for (int i = 0; i < rutas.size(); i++){

                Ruta Ruta_linea = rutas.get(i);

                // Añadir al archivo                
                informacionLinea = Ruta_linea.getIdRuta() + "," + Ruta_linea.getNombreRuta() + "," + Ruta_linea.getOrigenRuta() + "," + Ruta_linea.getDestinoRuta() + "," + Ruta_linea.getDistanciaRuta() + "," + Ruta_linea.getTipoTerreno() + "," + Ruta_linea.getNivelDificultad() + "," + Ruta_linea.getElevacionRuta();
                pw.println(informacionLinea);
                
            }

            pw.flush();
            fw.close();

        } catch (Exception e) {

            System.err.println("Error escribiendo: " + e.getMessage());
            
        }

    }

    // Método para guardar las estadisticas desde el archivo Estadisticas.csv
    public void guardarEstadisticas(ArrayList<Usuario> usuarios){
        // Definición de variables
        FileWriter fw = null;
        BufferedWriter br;
        PrintWriter pw = null;
        String informacionLinea;
        Usuario usuario;
        ArrayList<Estadisticas> estadisticasUsuario;
        Estadisticas estadistica;

        try {

            fw = new FileWriter("Estadisticas.csv");
            br = new BufferedWriter(fw);
            pw = new PrintWriter(br);

            // Se hace un ciclo para guardar todas las rutas de cada uno de los usuarios
            for (int i = 0; i < usuarios.size(); i++){

                usuario = usuarios.get(i);
                estadisticasUsuario = usuario.getArregloEstadistica();

                // Este ciclo guarda cada una de las estadisticas del usuario
                for (int j = 0; j < estadisticasUsuario.size(); j++){
                    estadistica = estadisticasUsuario.get(j);

                    // Añadir al archivo
                    informacionLinea = usuario.getId() + "," + estadistica.getIdRuta() + "," + estadistica.getNombreRuta() + "," + estadistica.getKilometros() + "," + estadistica.getTiempoMinutos() + "," + estadistica.getFtp();
                    pw.println(informacionLinea);

                }
                
            }

            pw.flush();
            fw.close();

        } catch (Exception e) {

            System.err.println("Error escribiendo: " + e.getMessage());
            
        }

    }

    // Metodos para cargar archivos del tipo csv

    // Método para cargar las rutas desde el archivo Rutas.csv
    public ArrayList<Ruta> cargarRutas(){
        // Definición de variables
        ArrayList<Ruta> Rutas = new ArrayList<>();
        FileReader fr = null;
        Scanner archivo = null;
        int idRuta;
        String nombreRuta;
        String origenRuta;
        String destinoRuta;
        int distanciaRuta;
        String tipoTerreno;
        String nivelDificultad;
        int elevacionRuta;

        try {

            fr = new FileReader("Rutas.csv");
            archivo = new Scanner(fr);
            
            // Este ciclo va a recorrer cada una de las lineas del archivo .csv
            while (archivo.hasNextLine()) {

                String linea = archivo.nextLine();
                String[] datos_linea = linea.split(",");
                
                // Se guardan en variables los atributos necesarios para crear una clase ruta
                idRuta = Integer.parseInt(datos_linea[0]);
                nombreRuta = datos_linea[1];
                origenRuta = datos_linea[2];
                destinoRuta = datos_linea[3];
                distanciaRuta = Integer.parseInt(datos_linea[4]);
                tipoTerreno = datos_linea[5];
                nivelDificultad = datos_linea[6];
                elevacionRuta = Integer.parseInt(datos_linea[7]);

                // Se crea la clase ruta y se añade al ArrayList de rutas
                Ruta nueva_ruta = new Ruta(idRuta, nombreRuta, origenRuta, destinoRuta, distanciaRuta, tipoTerreno, nivelDificultad, elevacionRuta);

                Rutas.add(nueva_ruta);

            }

        } catch (FileNotFoundException e) {

            System.err.println("Error leyendo el archivo");

        } 

        return Rutas;
    }

    // Método para cargar los usuarios desde el archivo Usuarios.csv
    public ArrayList<Usuario> cargarUsuarios(ArrayList<Ruta> rutas){

        // Definición de variables
        ArrayList<Usuario> Usuarios = new ArrayList<>();
        FileReader fr = null;
        Scanner archivo = null;
        int id;
        String nombre;
        String fecha_nacimiento;
        String email;
        String ciudad;
        String tipo_ciclismo;
        String modelo_bicicleta;
        String[] idAmigos;
        ArrayList<Integer> arregloIdAmigos;
        String[] idRutas;
        int idRuta;
        ArrayList<Ruta> rutas_usuario;
        ArrayList<Estadisticas> arregloEstadisticas;

        try {

            fr = new FileReader("Usuarios.csv");
            archivo = new Scanner(fr);
            
            // Este ciclo va a recorrer cada una de las líneas del archivo .csv
            while (archivo.hasNextLine()) {

                String linea = archivo.nextLine();
                String[] datos_linea = linea.split(",");

                // Se guardan en variables los atributos necesarios para crear una clase Usuario
                id = Integer.parseInt(datos_linea[0]);
                nombre = datos_linea[1];
                fecha_nacimiento = datos_linea[2];
                email = datos_linea[3];
                ciudad = datos_linea[4];
                tipo_ciclismo = datos_linea[5];
                modelo_bicicleta = datos_linea[6];
                arregloIdAmigos = new ArrayList<>();
                rutas_usuario = new ArrayList<>();
                arregloEstadisticas = new ArrayList<>();

                // Crear arreglo de amigos a partir de los ids separados por "/"
                idAmigos = datos_linea[7].split("/");
                for (int i = 0; i < idAmigos.length; i++){
                    arregloIdAmigos.add(Integer.parseInt(idAmigos[i]));
                }

                // Cargar rutas del usuario a partir de los ids separados por "/"
                idRutas = datos_linea[8].split("/");
                for (int i = 0; i < idRutas.length; i++){
                    idRuta = Integer.parseInt(idRutas[i]);
                    for (int j = 0; j < rutas.size(); j++){
                        if (idRuta == rutas.get(j).getIdRuta()){
                            rutas_usuario.add(rutas.get(j));
                            j = rutas.size();
                        }
                    }
                }

                // Se crea la clase Usuario y se añade al ArrayList de usuarios
                Usuario nuevo_usuario = new Usuario(id, nombre, fecha_nacimiento, email, ciudad, tipo_ciclismo, modelo_bicicleta, arregloIdAmigos, rutas_usuario, arregloEstadisticas);
                Usuarios.add(nuevo_usuario);

            }

        } catch (FileNotFoundException e) {

            System.err.println("Error leyendo el archivo");

        }

        return Usuarios;

    }

    // Método para cargar las estadísticas desde el archivo Estadisticas.csv y asignarlas a los usuarios
    public ArrayList<Usuario> cargarEstadisticas(ArrayList<Usuario> cargarUsuarios){
        FileReader fr = null;
        Scanner archivo = null;        
        ArrayList<Usuario> usuarios = cargarUsuarios;
        ArrayList<Estadisticas> Estadisticas;
        int idUsuario;
        int idRuta;
        String nombreRuta;
        float kilometros;
        int tiempoMinutos;
        float ftp;        
        Usuario usuario;
        Estadisticas estadistica;
        String linea;
        String[] datos_linea;

        try {

            fr = new FileReader("Estadisticas.csv");
            archivo = new Scanner(fr);
            
            // Este ciclo va a recorrer cada una de las líneas del archivo .csv
            while (archivo.hasNextLine()) {

                linea = archivo.nextLine();
                datos_linea = linea.split(",");

                // Se guardan en variables los atributos necesarios para crear una clase Estadisticas
                idUsuario = Integer.parseInt(datos_linea[0]);
                idRuta = Integer.parseInt(datos_linea[1]);
                nombreRuta = datos_linea[2];
                kilometros = Float.parseFloat(datos_linea[3]);
                tiempoMinutos = Integer.parseInt(datos_linea[4]);
                ftp = Float.parseFloat(datos_linea[5]);

                // Buscar el usuario correspondiente y añadirle la estadística
                for (int i = 0; i < usuarios.size(); i++) {
                    
                    if (usuarios.get(i).getId() == idUsuario) {

                        estadistica = new Estadisticas(idRuta, nombreRuta, kilometros, tiempoMinutos, ftp);

                        usuario = usuarios.get(i);
                        Estadisticas = usuario.getArregloEstadistica();
                        Estadisticas.add(estadistica);
                        usuario.setEstadistica(Estadisticas);
                        
                        // Actualizar el usuario en la lista
                        usuarios.set(i, usuario);
                        i = usuarios.size();

                    }
                }

            }

        } catch (FileNotFoundException e) {

            System.err.println("Error leyendo el archivo");

        }
        
        return usuarios;

    }

}