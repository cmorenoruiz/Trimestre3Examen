
/**
 *
 * @author Pedro G Gallardo
 */
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ejercicio2 {

    public static void main(String[] args) {
        //crea un ArrayList de aparcamientos y un Scanner puntero al archivo contenedor de los datos
        ArrayList<Aparcamiento> aparcamientos = new ArrayList<Aparcamiento>();
        try {
//          File archivo = new File("Aparcamientos2.txt");
//          Scanner leerFichero = new Scanner(archivo);
            File archivo = new File("Aparcamientos.csv");
            BufferedReader leerFichero = new BufferedReader(new FileReader(archivo));
            String fila;
            //Tiro la fila de títulos
            fila = leerFichero.readLine();
            while ((fila = leerFichero.readLine()) != null) {
                //System.out.println(fila);
                String[] contenido = fila.split(",");
                //Aparcamiento(int PARCodigo, String PARNombrePar, String PARtipo, int PARplazasRotacion, int PARplazasResidente, int PARplazasDisuasorias, String PARdistrito)
                aparcamientos.add(new Aparcamiento(contenido[0], contenido[1], contenido[2], contenido[3], contenido[4], contenido[5], contenido[6]));
            }

            //cierra el Scanner puntero al archivo
            leerFichero.close();
        } catch (Exception e) {
            System.out.println("Error");
            e.printStackTrace();
        }

        //Una vez hemos creado un arraylist de objetos aparcamiento vamos a crear un HashMap con los nombres d los distritos y sus valores correspondientes
        try {
            HashMap<String, Integer> plazas = new HashMap<>();
            for (Aparcamiento aparca : aparcamientos) {
                if (plazas.containsKey(aparca.getPARdistrito())) {
                    plazas.put(aparca.getPARdistrito(), plazas.get(aparca.getPARdistrito()) + aparca.devuelvePlazas());
                } else {
                    plazas.put(aparca.getPARdistrito(), aparca.devuelvePlazas());
                }
            }
            System.out.println("Lista sin ordenar:");
            System.out.println(plazas);

            //metodo de ordenacion del HashMap
            List<Map.Entry<String, Integer>> lista = new ArrayList<Map.Entry<String, Integer>>(plazas.entrySet());

            //este metodo lo que hace es, dentro del collections.sort, he abierto un comparador apuntando a la lista Map.Entry con los contenidos del HashMap
            //recibiendo como argumento entrada1 y entrada2 apuntando cada uno al Map.Entry y luego utilizando un compareTo para ordenarlo por los valores
            //en vez de por las claves, ya que nos interesa sobre todo conocer cual es la palabra que mas se repite
            Collections.sort(lista, new Comparator<Map.Entry<String, Integer>>() {
                public int compare(Map.Entry<String, Integer> entrada1, Map.Entry<String, Integer> entrada2) {
                    return entrada2.getValue().compareTo(entrada1.getValue());
                }
            }
            );
            System.out.println("Lista ordenada:");
            System.out.println(lista);

        } catch (Exception e) {
            System.out.println("Error");
            e.printStackTrace();
        }

        //Ahora repetimos lo mismo que en el bloque tryCatch pero con los tipos de aparcamientos
        try {
            HashMap<String, Integer> plazas = new HashMap<>();
            for (Aparcamiento aparca : aparcamientos) {
                if (plazas.containsKey(aparca.getPARtipo())) {
                    plazas.put(aparca.getPARtipo(), plazas.get(aparca.getPARtipo()) + aparca.devuelvePlazas());
                } else {
                    plazas.put(aparca.getPARtipo(), aparca.devuelvePlazas());
                }
            }
            System.out.println("Lista sin ordenar:");
            System.out.println(plazas);

            //metodo de ordenacion del HashMap
            List<Map.Entry<String, Integer>> lista = new ArrayList<Map.Entry<String, Integer>>(plazas.entrySet());

            //este metodo lo que hace es, dentro del collections.sort, he abierto un comparador apuntando a la lista Map.Entry con los contenidos del HashMap
            //recibiendo como argumento entrada1 y entrada2 apuntando cada uno al Map.Entry y luego utilizando un compareTo para ordenarlo por los valores
            //en vez de por las claves, ya que nos interesa sobre todo conocer cual es la palabra que mas se repite
            Collections.sort(lista, new Comparator<Map.Entry<String, Integer>>() {
                public int compare(Map.Entry<String, Integer> entrada1, Map.Entry<String, Integer> entrada2) {
                    return entrada2.getValue().compareTo(entrada1.getValue());
                }
            }
            );
            System.out.println("Lista ordenada:");
            System.out.println(lista);

        } catch (Exception e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }
}
