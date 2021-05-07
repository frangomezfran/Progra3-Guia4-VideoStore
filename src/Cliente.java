import java.util.ArrayList;

public class Cliente {

    private String nombre;
    private String telefono;
    private String direccion;

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


    //---------------------- Metodos ----------------------

    @Override
    public String toString(){
        return "Cliente [ Nombre : "+this.nombre+" | Telefono : "+this.telefono+
                " | Direccion : "+this.direccion+" ]\n" ;
    }

    //Estos metodos los hago para que el main tenga mas coherencia
    public String solicitaPelicula (String tituloPelicula){ return tituloPelicula; }

}
