import java.util.concurrent.Callable;

public class Main {
    public static void main(String[] args) {
        //20:40 - 21:10 | 22:00 - 6:00 No lo termine en 2 Horas, esta incompleto todavia | 14:00 -

        //Creamos el Video Store de Roberto
        VideoStore robertoStore = new VideoStore();

        //Creamos peliculas para agregar al inventario
        Pelicula aquaman = new Pelicula("Accion","Aquaman","21-12-2018",143,"PG","EEUU","Sinopsis-de-Aquaman");
        Pelicula nemo = new Pelicula("Aventura","Nemo","11-3-2004",190,"G","EEUU","Sinopsis-de-Nemo");
        Pelicula movie43 = new Pelicula("Comedia","Movie 43","21-12-2010",123,"NC-17","EEUU","Sinopsis-de-Movie43");
        Pelicula bromas = new Pelicula("Drama","El Bromas","21-12-2019",141,"NC-17","EEUU","Sinopsis-de-ElBromas");
        Pelicula psicosis = new Pelicula("Horror","Psicosis","5-10-1980",200,"R","EEUU","Sinopsis-de-Psicosis");
        Pelicula ourPlanet = new Pelicula("Documental","Our Planet","9-12-2018",231,"G","EEUU","Sinopsis-de-OurPlanet");

        //Cargamos peliculas al inventario de robertoStore
        for(int i=0;i<10;i++) { //10 peliculas por cada titulo en la lista de inventario
            robertoStore.agregaPeliculasAlInventario(aquaman);
            robertoStore.agregaPeliculasAlInventario(nemo);
            robertoStore.agregaPeliculasAlInventario(movie43);
            robertoStore.agregaPeliculasAlInventario(bromas);
            robertoStore.agregaPeliculasAlInventario(psicosis);
            robertoStore.agregaPeliculasAlInventario(ourPlanet);
        }

        //Creo Cliente
        Cliente francoCliente = new Cliente("Franco Gomez","2236010566","Casa de Fran");

        // Franco solicita al robertoStore si esta la pelicula nemo y si hay stock
        //Si esta la pelicula le pedimos los datos al cliente y la alquilamos

        if ( robertoStore.buscaEnInventario( francoCliente.solicitaPelicula ( nemo ) ) ) {

            // Instancio un alquiler con la pelicula que pide el cliente
            Alquiler alquilerFran = new Alquiler( francoCliente,francoCliente.solicitaPelicula ( nemo ) , 7);

            //Agrego el alquiler al local y el cliente al mismo tiempo
            robertoStore.agregaAlquilerYCliente(alquilerFran);

            //Le da la pelicula al cliente
            robertoStore.remuevePeliculaInventario(alquilerFran);

            System.out.println("Alquiler hecho, Creando boleta... = "+alquilerFran.generaBoleta());

            System.out.println("\nAlquileres Vigentes: \n"+robertoStore.imprimeAlquileresVigentes());
            System.out.println("\nUltimos 10 alquileres de Clientes:\n"+robertoStore.imprimeUltimos10AlquileresCadaCliente());

            //Devuelve la pelicula
            robertoStore.agregaPeliculasAlInventario(francoCliente.devuelvePelicula(alquilerFran));

            System.out.println("\nAlquileres Vigentes: \n"+robertoStore.imprimeAlquileresVigentes());
            System.out.println("\nUltimos 10 alquileres de Clientes:\n"+robertoStore.imprimeUltimos10AlquileresCadaCliente());




        }











    }
}
