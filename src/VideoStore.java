import java.time.LocalDate;
import java.util.ArrayList;

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

            boolean clienteRegistrado = false;

            for (Cliente aux : this.clientes) {

                if (aux.getTelefono().equals(cliente.getTelefono())) // Un dni estaria mejor
                {
                    clienteRegistrado = true;
                    break;
                }

            }

            if(!clienteRegistrado) // Si el cliente no esta dentro de la lista se agregará
                this.clientes.add(cliente);

        }else{
            this.clientes.add(cliente);
        }

        addListaAlquileres(cliente.getAlquiler());
    }

    public void addListaAlquileres(Alquiler alquiler){
        this.alquileres.add(alquiler);
    }

    public void cambiaVigenciaListaDeAlquileres(Alquiler alquiler){

        int indexDeAlquiler = this.alquileres.indexOf(alquiler);//Cambiamos la lista de alquileres
        this.alquileres.get(indexDeAlquiler).setVigente(false);
    }

    public boolean buscaEnInventario (Pelicula pelicula){

        if (!this.inventario.isEmpty()) //Si el inventario tiene peliculas

            for (Pelicula aux : this.inventario) { // Recorro el inventario

                if ( pelicula.getTitulo().equals(aux.getTitulo()) ) //Si existe la pelicula y hay stock se podra alquilar
                    return true;
            }


        return false;

    }

    public String darPeliculayDaBoleta (Cliente cliente) { //Este metodo se hace luego de buscaInventario

        this.inventario.remove(cliente.getAlquiler().getPelicula());

        //Genero boleta y la retorno
        return this.clientes.get( this.clientes.size()-1 ).getAlquiler().generaBoleta();

    }

    public void recibePelicula (Cliente cliente) {

        this.inventario.add(cliente.getAlquiler().getPelicula()); //Podria ponerle el index para q mi inventario este prolijo

        int indexDelCliente = this.clientes.indexOf(cliente) ;
        this.clientes.get(indexDelCliente).getAlquiler().terminaAlquiler();//Cliente de la lista a editar su alquiler

        cambiaVigenciaListaDeAlquileres(cliente.getAlquiler());


    }

    public String imprimeAlquileresVigentes (){
        String alquileresVigentes="";

        for (Alquiler aux : this.alquileres){

            if (aux.isVigente())
              alquileresVigentes += aux.imprimeAlquiler();
        }

        return alquileresVigentes;

    }

    public String imprimeDevolucionesHoy(){

        String devolucionesHoy="";

        for (Alquiler aux : this.alquileres){

            if (LocalDate.now().equals(aux.getFechaDevolucion()))
                devolucionesHoy += aux.imprimeAlquiler();
        }

        return devolucionesHoy;
    }

    public void imprimeUltimos10AlquileresCadaCliente (){ //Pasar por parametro el cliente

        int i = 0;

        for (Cliente cliente : this.clientes){

            cliente.imprimeCliente(); //Imprimo al cliente

            for (Alquiler alquiler : this.alquileres){

                if (alquiler.getCliente().getTelefono().equals(cliente.getTelefono())  && i < 10){ //Ordenar los alquileres por fecha

                    alquiler.imprimeAlquiler();
                    i++;

                }

            }

            i = 0;

        }


    }

    public void peliculasMasAlquiladas(){

        String peliculasPorPopularidad = "";

        for( Alquiler aux : this.alquileres ){






        }
    }
}
