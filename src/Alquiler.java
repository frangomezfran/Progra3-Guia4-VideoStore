import java.time.LocalDate;
import java.util.Date;

public class Alquiler {

    private final int DIASDEVOLUCION = 7; //Esto no iria,
    private Cliente cliente;
    private LocalDate fechaAlquiler;//A base de esto, hacer un metodo que me de la fecha de devolucion
    private LocalDate fechaDevolucion;// Esta de mas este atributo
    private Pelicula pelicula;
    private String boleta; //Esto no es un atributo, lo veo con un toString
    private boolean vigente = false; //Vigente no iria y esto lo veo con el metodo de fecha de devolucion
    private double aPagar;

    //---------------------- Constructor ----------------------
    public Alquiler(Cliente cliente, Pelicula pelicula) { //Si se instancia el Alquiler se alquila la pelicula

        this.cliente = cliente;
        this.pelicula = pelicula;
        pelicula.aumentaPopularidad();
        this.vigente = true;
        this.fechaAlquiler = LocalDate.now();
        this.fechaDevolucion = fechaAlquiler.plusDays( DIASDEVOLUCION ); //Se devolvera en una semana
        this.boleta="";
        cliente.setAlquiler(this);
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

    //---------------------- FechaDevolucion ----------------------
    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }
    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    //---------------------- Pelicula ----------------------
    public Pelicula getPelicula() {
        return pelicula;
    }
    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    //---------------------- Vigente ----------------------
    public boolean isVigente() {
        return vigente;
    }
    public void setVigente(boolean vigente) {
        this.vigente = vigente;
    }

    //---------------------- Metodos ----------------------

    public String generaBoleta (){ //Esta boleta se genera dentro de videoStore

        this.boleta = ""+this.cliente.getNombre()+" alquilo "+this.pelicula.getTitulo()+" el dia "+this.fechaAlquiler+", debe devolverla el dia "+this.fechaDevolucion;

        return this.boleta;
    }

    public void terminaAlquiler (){
        //Verifica la fecha de hoy con la de fechaAlquiler
        if(LocalDate.now().isAfter(this.fechaDevolucion)){//Si la fecha de hoy es mayor a la de devolucion
            this.aPagar += (100 * LocalDate.now().compareTo(this.fechaDevolucion) ); //100 pesos mas por dia q paso, INCOMPLETO
        }
        this.fechaDevolucion=null;
        this.fechaAlquiler=null;
        this.pelicula=null;
        this.boleta="";
        this.cliente=null;
        this.vigente=false;//Antes de hacer esto tiene quedarse en la clase VideoStore una lista de todos los alquileres

    }
    public String imprimeAlquiler(){
        String alquileryCliente = "Alquiler :\n" + cliente.imprimeCliente() +"\nAlquiler [ Vigente : "+this.vigente;

        if (this.vigente){
            alquileryCliente += " | Fecha Alquiler : "+this.fechaAlquiler+" | Fecha Devolucion : "+this.fechaDevolucion+
                    " | Pelicula : "+this.pelicula.getTitulo()+" ]";
        }else{

            alquileryCliente += " ]";
        }

        return alquileryCliente;


    }

    public LocalDate generaFechaDevolucion(int cantDiasAlquiler){

        return (this.fechaAlquiler.plusDays(cantDiasAlquiler));
    }
}
