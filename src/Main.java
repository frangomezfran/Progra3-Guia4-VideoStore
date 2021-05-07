import java.time.LocalDate;
import java.util.concurrent.Callable;

public class Main {
    public static void main(String[] args) {
        //20:40 - 21:10 | 22:00 - 6:00 No lo termine en 2 Horas, esta incompleto todavia | 14:00 -

        VideoStore robertoStore = new VideoStore();

        //Agrego las peliculas al Video Store de Roberto
        robertoStore.agregaPeliculasAlInventario("Accion","Aquaman","21-12-2018",143,Audiencia.G,"EEUU","Sinopsis-de-Aquaman",10);
        robertoStore.agregaPeliculasAlInventario("Aventura","Nemo","11-3-2004",190,Audiencia.G,"EEUU","Sinopsis-de-Nemo",10);
        robertoStore.agregaPeliculasAlInventario("Comedia","Movie 43","21-12-2010",123,Audiencia.NCDiecisiete,"EEUU","Sinopsis-de-Movie43",10);
        robertoStore.agregaPeliculasAlInventario("Drama","El Bromas","21-12-2019",141,Audiencia.NCDiecisiete,"EEUU","Sinopsis-de-ElBromas",10);
        robertoStore.agregaPeliculasAlInventario("Horror","Psicosis","5-10-1980",200,Audiencia.R,"EEUU","Sinopsis-de-Psicosis",10);
        robertoStore.agregaPeliculasAlInventario("Documental","Our Planet","9-12-2018",231,Audiencia.G,"EEUU","Sinopsis-de-OurPlanet",10);

        //Creo Cliente
        Cliente francoCliente = new Cliente("Franco Gomez","2236010566","Casa de Fran");

        // Franco solicita al robertoStore si esta la pelicula nemo y si hay stock
        //Si esta la pelicula le pedimos los datos al cliente y la alquilamos

        Pelicula peliculaSolicitada = robertoStore.retornaPeliculaDelInventario( francoCliente.solicitaPelicula ("nemo" ) );

        if ( peliculaSolicitada != null ) {

            //Agrego el cliente y el alquiler al local
            System.out.println("Creando boleta... = "+robertoStore.nuevoAlquiler(francoCliente,peliculaSolicitada,7, LocalDate.now()));



            //Devuelve la pelicula
            robertoStore.devolviendoPelicula(francoCliente);

        }













    }
}
