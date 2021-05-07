import java.time.LocalDate;
import java.util.Date;

public class Alquiler {

    private Cliente cliente;
    private LocalDate fechaAlquiler = null;
    private Pelicula pelicula;
    private int diasAlquiler = 0;
    private boolean vigencia; //Con este atributo podre generar un historial en la lista de alquileres del VideoStore

    //---------------------- Constructor ----------------------

    public Alquiler(Cliente cliente, Pelicula pelicula, int diasAlquiler, LocalDate fechaAlquiler) { //Si se instancia el Alquiler se alquila la pelicula

        this.cliente = cliente;
        this.pelicula = pelicula;
        this.diasAlquiler = diasAlquiler;
        this.fechaAlquiler = fechaAlquiler;
        this.vigencia = true;
    }

    //---------------------- Cliente ----------------------
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    //---------------------- Fecha Alquiler ----------------------
    public LocalDate getFechaAlquiler() {
        return fechaAlquiler;
    }
    public void setFechaAlquiler(LocalDate fechaAlquiler) {
        this.fechaAlquiler = fechaAlquiler;
    }

    //---------------------- Pelicula ----------------------
    public Pelicula getPelicula() {
        return pelicula;
    }
    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    //---------------------- Dias Alquiler ----------------------
    public int getDiasAlquiler() {
        return diasAlquiler;
    }
    public void setDiasAlquiler(int diasAlquiler) {
        this.diasAlquiler = diasAlquiler;
    }
    //---------------------- Vigencia ----------------------
    public boolean getVigencia() {
        return vigencia;
    }
    public void setVigencia(boolean vigencia) {
        this.vigencia = vigencia;
    }

    //---------------------- Metodos ----------------------

    public LocalDate getFechaDevolucion(){
        return (this.fechaAlquiler.plusDays(this.diasAlquiler));
    }

    public String generaBoleta (){
        return "Boleta [ "+this.cliente.getNombre()+" alquilo "+this.pelicula.getTitulo()+" el dia "+this.fechaAlquiler+" y la devuelve "+this.getFechaDevolucion()+" ]";
    }

    @Override
    public String toString() {
        return "    Alquiler [ FechaAlquiler = " + fechaAlquiler +
                " | FechaDevolucion = "+this.getFechaDevolucion()+
                " | Nombre Cliente = "+cliente.getNombre()+
                " | Pelicula = " + pelicula.getTitulo() + " ]";
    }

    // COMO SABER CUANDO EL CLIENTE DEVOLVIO LA PELICULA ??!
}
