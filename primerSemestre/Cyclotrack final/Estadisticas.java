public class Estadisticas {

    // Atributos de la clase Estadisticas
    private int idRuta;           // Identificador de la ruta asociada a la estadística
    private String nombreRuta;    // Nombre de la ruta asociada
    private float kilometros;     // Kilómetros recorridos en la ruta
    private int tiempoMinutos;    // Tiempo empleado en minutos
    private float ftp;            // Valor de FTP (Functional Threshold Power) registrado

    // Constructor por defecto de la clase Estadisticas
    // Inicializa los atributos con valores por defecto
    public Estadisticas() {
        idRuta = 0;
        nombreRuta = "";
        kilometros = 0.0F;
        tiempoMinutos = 0;
        ftp = 0.0F;
    }

    // Constructor con parámetros para inicializar todos los atributos
    public Estadisticas(int idRuta, String nombreRuta, float kilometros, int tiempoMinutos, float ftp) {
        this.idRuta = idRuta;
        this.nombreRuta = nombreRuta;
        this.kilometros = kilometros;
        this.tiempoMinutos = tiempoMinutos;
        this.ftp = ftp;
    }

    // Métodos Getters para obtener los valores de los atributos

    public int getIdRuta() { // Devuelve el ID de la ruta
        return idRuta;
    }

    public String getNombreRuta() { // Devuelve el nombre de la ruta
        return nombreRuta;
    }

    public double getKilometros() { // Devuelve los kilómetros recorridos
        return kilometros;
    }

    public int getTiempoMinutos() { // Devuelve el tiempo en minutos
        return tiempoMinutos;
    }

    public double getFtp() { // Devuelve el valor de FTP
        return ftp;
    }

    // Métodos Setters para modificar los valores de los atributos

    public void setNombreRuta(String nombreRuta) { // Modifica el nombre de la ruta
        this.nombreRuta = nombreRuta;
    }

    public void setKilometros(float kilometros) { // Modifica los kilómetros recorridos
        this.kilometros = kilometros;
    }

    public void setTiempoMinutos(int tiempoMinutos) { // Modifica el tiempo en minutos
        this.tiempoMinutos = tiempoMinutos;
    }

    public void setFtp(float ftp) { // Modifica el valor de FTP
        this.ftp = ftp;
    }

    public void setIdRuta(int idRuta) { // Modifica el ID de la ruta
        this.idRuta = idRuta;
    }

}