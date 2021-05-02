import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class VideoStore {

    private ArrayList<Cliente> clientes = new ArrayList<>();//Se sumaran a esta lista los clientes nuevos
    private ArrayList<Pelicula> inventario = new ArrayList<>();//Mi inventario es una lista de peliculas
    private ArrayList<Alquiler> alquileres = new ArrayList<>(); //Alquileres vigentes, cuando se devuelven peliculas se elimina el nodo

    //---------------------- Constructor ----------------------



    //---------------------- Clientes ----------------------
    public ArrayList<Cliente> getClientes() {
        return clientes;
    }
    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    //---------------------- Inventario ----------------------
    public ArrayList<Pelicula> getInventario() {
        return inventario;
    }
    public void setInventario(ArrayList<Pelicula> inventario) {
        this.inventario = inventario;
    }

    //---------------------- Alquileres ----------------------
    public ArrayList<Alquiler> getAlquileres() {
        return alquileres;
    }
    public void setAlquileres(ArrayList<Alquiler> alquileres) {
        this.alquileres = alquileres;
    }


    //---------------------- Metodos ----------------------
    public void agregaPeliculasAlInventario (Pelicula pelicula){
        this.inventario.add(pelicula);
    }

    public void agregaClientes (Cliente cliente){

        if(!this.clientes.isEmpty()) {

            if(Collections.frequency(this.clientes,cliente) == 0)
                this.clientes.add(cliente);

        }else{
            this.clientes.add(cliente);
        }

    }

    public void agregaAlquilerYCliente(Alquiler alquiler){

        this.alquileres.add(0,alquiler);//los ultimos alquileres iran primero


        this.agregaClientes(alquiler.getCliente());
    }

    public boolean buscaEnInventario (Pelicula pelicula){

        if (!this.inventario.isEmpty()) //Si el inventario tiene peliculas

            for (Pelicula aux : this.inventario) { // Recorro el inventario

                if ( pelicula.getTitulo().equals(aux.getTitulo()) ) //Si existe la pelicula y hay stock se podra alquilar
                    return true;
            }


        return false;

    }

    public void remuevePeliculaInventario (Alquiler alquiler) { //Este metodo se hace luego de buscaInventario

        this.inventario.remove(alquiler.getPelicula());

    }

    public boolean getVigencia(Alquiler alquiler){

        for (Pelicula aux : this.inventario){

            if(aux == alquiler.getPelicula())
                return false;//Si la pelicula que se alquilo esta en el inventario no hay vigencia

        }

        return true;//Si la pelicula que se alquilo no esta en el inventario hay vigencia
    }

    public String imprimeAlquileresVigentes (){

        String alquileresVigentes="";

        for (Alquiler alquiler : this.alquileres){

            if ( this.getVigencia(alquiler) )
              alquileresVigentes += alquiler.toString();
        }

        return alquileresVigentes;

    }

    public void imprimeDevolucionesHoy(){

        for (Alquiler aux : this.alquileres){

            if (aux.getFechaAlquiler()!=null)
                aux.toString();
        }

    }

    public String imprimeUltimos10AlquileresCadaCliente (){ //Pasar por parametro el cliente

        int i = 0;

        String aImprimir="";

        for (Cliente cliente : this.clientes){

            aImprimir+=cliente.toString(); //Imprimo al cliente

            for (Alquiler alquiler : this.alquileres){

                if (alquiler.getCliente().getTelefono().equals(cliente.getTelefono())  && i < 10){ //Ordenar los alquileres por fecha

                    aImprimir+=alquiler.toString();
                    i++;

                }

            }

            i = 0;

        }

        return aImprimir;


    }

    public void peliculasMasAlquiladas(){

        String peliculasPorPopularidad = "";

        for( Alquiler aux : this.alquileres ){






        }
    }
}
