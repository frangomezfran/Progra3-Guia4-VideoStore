public class Pelicula {

    private String genero; //Podria hacer que los valores sean unicos pero nose como Accion,Aventura,Comedia,Drama,Horror,Documental
    private String titulo;
    private String fechaLanzamiento;
    private int duracionMinutos;
    private String audiencia; // Edad
    private String siglasPaisOrigen;
    private String descripcion;
    //private int popularidad;

    //---------------------- Constructor ----------------------
    public Pelicula(String genero, String titulo, String fechaLanzamiento, int duracionMinutos, String audiencia, String siglasPaisOrigen, String descripcion) {
        this.genero = genero;
        this.titulo = titulo;
        this.fechaLanzamiento = fechaLanzamiento;
        this.duracionMinutos = duracionMinutos;
        this.audiencia = audiencia;
        this.siglasPaisOrigen = siglasPaisOrigen;
        this.descripcion = descripcion;
        this.popularidad = 0 ;
    }

    //---------------------- Genero ----------------------
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }

    //---------------------- Titulo ----------------------
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    //---------------------- FechaLanzamiento ----------------------
    public String getFechaLanzamiento() {
        return fechaLanzamiento;
    }
    public void setFechaLanzamiento(String fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    //---------------------- DuracionMinutos ----------------------
    public int getDuracionMinutos() {
        return duracionMinutos;
    }
    public void setDuracionMinutos(int duracionMinutos) {
        this.duracionMinutos = duracionMinutos;
    }

    //---------------------- Audiencia ----------------------
    public String getAudiencia() {
        return audiencia;
    }
    public void setAudiencia(String audiencia) {
        this.audiencia = audiencia;
    }

    //---------------------- SiglasPaisOrigen ----------------------
    public String getSiglasPaisOrigen() {
        return siglasPaisOrigen;
    }
    public void setSiglasPaisOrigen(String siglasPaisOrigen) {
        this.siglasPaisOrigen = siglasPaisOrigen;
    }

    //---------------------- Descripcion ----------------------
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    //---------------------- Popularidad ----------------------
    public int getPopularidad() {
        return popularidad;
    }
    public void setPopularidad(int popularidad) {
        this.popularidad = popularidad;
    }

    //---------------------- Metodos ----------------------
    public void aumentaPopularidad(){
        this.popularidad++;
    }


}
