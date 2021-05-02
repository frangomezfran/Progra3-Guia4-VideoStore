import java.util.ArrayList;

public class Cliente {

    private String nombre;
    private String telefono;
    private String direccion;
    //Sacar atributo alquiler del cliente
    private Alquiler alquiler;//Quiza deberia inicializarlo en el constructor

    //---------------------- Constructor ----------------------
    public Cliente(String nombre, String telefono, String direccion) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    //---------------------- Nombre ----------------------
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //---------------------- Telefono ----------------------
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    //---------------------- Direccion ----------------------
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    //---------------------- Alquiler ----------------------
    public Alquiler getAlquiler() {
        return this.alquiler;
    }
    public void setAlquiler (Alquiler alquiler) {
        this.alquiler = alquiler;
    }


    //---------------------- Metodos ----------------------

    public String imprimeCliente(){
        return "Cliente [ Nombre : "+this.nombre+" | Telefono : "+this.telefono+
                " | Direccion : "+this.direccion+" ]" ;
    }
    public Pelicula solicitaPelicula (Pelicula pelicula){
        return pelicula;
    }
    //Devuelve la pelicula con getAlquiler, luego se setea a null

    public Cliente devuelvePelicula (){
       //return this.alquiler.getPelicula();
        return this;
    }

    //Deberia pagar el cliente
}
