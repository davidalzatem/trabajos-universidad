public class Ruta {

    // Atributos de la clase Ruta
    private int idRuta;                // Identificador único de la ruta
    private String nombreRuta;         // Nombre de la ruta
    private String origenRuta;         // Origen de la ruta
    private String destinoRuta;        // Destino de la ruta
    private int distanciaRuta;         // Distancia de la ruta en kilómetros
    private String tipoTerreno;        // Tipo de terreno de la ruta
    private String nivelDificultad;    // Nivel de dificultad de la ruta
    private int elevacionRuta;         // Elevación de la ruta

    // Constructor por defecto de la clase Ruta
    public Ruta() {
        this.idRuta = 0;
        this.nombreRuta = "";
        this.origenRuta = "";
        this.destinoRuta = "";
        this.distanciaRuta = 0;
        this.tipoTerreno = "";
        this.nivelDificultad = "";
        this.elevacionRuta = 0;
    }

    // Constructor con parámetros para inicializar todos los atributos de la ruta
    public Ruta(int idRuta, String nombreRuta, String origenRuta, String destinoRuta, int distanciaRuta, String tipoTerreno, String nivelDificultad, int elevacionRuta) {
        this.idRuta = idRuta;
        this.nombreRuta = nombreRuta;
        this.origenRuta = origenRuta;
        this.destinoRuta = destinoRuta;
        this.distanciaRuta = distanciaRuta;
        this.tipoTerreno = tipoTerreno;
        this.nivelDificultad = nivelDificultad;
        this.elevacionRuta = elevacionRuta;
    }

    // Método para mostrar la información de la ruta por consola
    public void mostrarInformacionRuta() {
        System.out.println("Información de la Ruta:");
        System.out.println("ID: " + idRuta);
        System.out.println("Nombre de la Ruta: " + nombreRuta);
        System.out.println("Origen de la Ruta: " + origenRuta);
        System.out.println("Destino de la Ruta: " + destinoRuta);
        System.out.println("Distancia de la Ruta: " + distanciaRuta + " km");
        System.out.println("Tipo de Terreno: " + tipoTerreno);
        System.out.println("Nivel de Dificultad: " + nivelDificultad);
        System.out.println("Elevación de la Ruta: " + elevacionRuta);
    }

    // Métodos Getters para obtener los valores de los atributos

    public int getIdRuta() {
        return idRuta;
    }

    public String getNombreRuta() {
        return nombreRuta;
    }

    public String getOrigenRuta() {
        return origenRuta;
    }

    public String getDestinoRuta() {
        return destinoRuta;
    }

    public int getDistanciaRuta() {
        return distanciaRuta;
    }

    public String getTipoTerreno() {
        return tipoTerreno;
    }

    public String getNivelDificultad() {
        return nivelDificultad;
    }

    public int getElevacionRuta() {
        return elevacionRuta;
    }

    // Métodos Setters para modificar los valores de los atributos

    public void setIdRuta(int idRuta) {
        this.idRuta = idRuta;
    }

    public void setNombreRuta(String nombreRuta) {
        this.nombreRuta = nombreRuta;
    }

    public void setOrigenRuta(String origenRuta) {
        this.origenRuta = origenRuta;
    }

    public void setDestinoRuta(String destinoRuta) {
        this.destinoRuta = destinoRuta;
    }

    public void setDistanciaRuta(int distanciaRuta) {
        this.distanciaRuta = distanciaRuta;
    }

    public void setTipoTerreno(String tipoTerreno) {
        this.tipoTerreno = tipoTerreno;
    }

    public void setNivelDificultad(String nivelDificultad) {
        this.nivelDificultad = nivelDificultad;
    }

    public void setElevacionRuta(int elevacionRuta) {
        this.elevacionRuta = elevacionRuta;
    }

}