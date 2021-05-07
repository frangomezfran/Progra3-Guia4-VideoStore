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
    public void agregaPeliculasAlInventario(String genero, String titulo, String fechaLanzamiento, int duracionMinutos, String audiencia, String siglasPaisOrigen, String descripcion, int stock) {

        Pelicula auxPelicula = new Pelicula(genero, titulo, fechaLanzamiento, duracionMinutos, audiencia, siglasPaisOrigen, descripcion, stock);

        this.inventario.add(auxPelicula);


    }

    public void agregaClientesNuevos(Cliente cliente) {

        if (Collections.frequency(this.clientes, cliente) == 0)
            this.clientes.add(cliente);

    }

    public String nuevoAlquiler(Cliente cliente, Pelicula pelicula, int diasAlquiler, LocalDate fechaAlquiler){
        //Este metodo se hará luego de saber que la pelicula esta en el inventario

        Alquiler auxAlquiler = new Alquiler(cliente, pelicula, diasAlquiler, fechaAlquiler);

        this.alquileres.add(0,auxAlquiler); //Los nuevos alquileres se pondran primeros

        this.agregaClientesNuevos(cliente);

        this.inventario.get( this.inventario.indexOf(pelicula) ).descuentaStock();

        return auxAlquiler.generaBoleta();

    }

    public Pelicula retornaPeliculaDelInventario (String tituloPelicula){

        if (!this.inventario.isEmpty()) //Si el inventario tiene peliculas

            for (Pelicula aux : this.inventario) { // Recorro el inventario

                if ( aux.getTitulo().equals(tituloPelicula) && aux.getStock() > 0 ) //Si existe la pelicula y hay stock se podra alquilar
                    return aux;
            }

        return null;

    }

    public void devolviendoPelicula(Cliente cliente){

       for(Alquiler auxAlquiler : this.alquileres){

           if(auxAlquiler.getCliente().getTelefono().equals(cliente.getTelefono())){
               auxAlquiler.setVigencia(false);
               this.inventario.get( this.inventario.indexOf(auxAlquiler.getPelicula()) ).aumentaStock();
           }
       }

    }

    public String imprimeAlquileresVigentes (){

        String alquileresVigentes="";

        for (Alquiler auxAlquiler : this.alquileres){

            if ( auxAlquiler.getVigencia() )
              alquileresVigentes += auxAlquiler.toString();
        }

        return alquileresVigentes;

    }

    public String imprimeDevolucionesHoy(){

        String devolucionesHoy="";

        for (Alquiler auxAlquiler : this.alquileres){

            if (auxAlquiler.getFechaDevolucion().equals(LocalDate.now()))
                devolucionesHoy+=auxAlquiler.toString();
        }

        return devolucionesHoy;
    }

    public String imprimeUltimos10AlquileresCadaCliente (){ //Pasar por parametro el cliente

        int i = 0;

        String aImprimir="";

        for (Cliente cliente : this.clientes){

            aImprimir+=cliente.toString(); //Imprimo al cliente

            for (Alquiler alquiler : this.alquileres){

                if (alquiler.getCliente().getTelefono().equals(cliente.getTelefono())  && i < 10){ //Ordenar los alquileres por fecha

                    aImprimir+=" "+alquiler.toString()+"\n";
                    i++;

                }

            }

            i = 0;

        }

        return aImprimir;


    }

    public int getPopularidad(Pelicula pelicula){

        int popularidad = 0;

        for(Alquiler auxAlquiler : this.alquileres){

            if(auxAlquiler.getPelicula().getTitulo().equals(pelicula.getTitulo())){
                popularidad++;
            }
        }

        return popularidad;
    }

    public int getIndexNumeroMayor(ArrayList<Integer> popularidad){

        int indexMayor=0;
        int elementoMayor = popularidad.get(0);

        for(Integer aux : popularidad){

            if(aux > elementoMayor){
                elementoMayor = aux;
                indexMayor= popularidad.indexOf(aux);
            }

        }

        return indexMayor;
    }

    public void ordenaInventarioPorPopularidad(){

        int popularidad1=0;

        //Creo una lista paralela a la lista de alquileres con su respectiva popularidad
        ArrayList<Integer> popularidad = new ArrayList<Integer>();



        for ( Pelicula auxPelicula : this.inventario ){

                for (Alquiler aux : this.alquileres){

                    popularidad.add(getPopularidad(aux.getPelicula()));
                }

        }




        }




    }

    public void peliculasMasAlquiladas(){

        String peliculasPorPopularidad = "";

        for( Alquiler aux : this.alquileres ){






        }
    }
}
