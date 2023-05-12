
/**
 *
 * @author Pedro G Gallardo
 */
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Ejercicio2 {

    public static void main(String[] args) {
        try {
            //crea un ArrayList de aparcamientos y un Scanner puntero al archivo contenedor de los datos
            ArrayList aparcamientos = new ArrayList<Aparcamiento>();
            File archivo = new File("Aparcamientos2.txt");
            Scanner leerFichero = new Scanner(archivo);
            while (leerFichero.hasNextLine()) {
                String fila = leerFichero.nextLine();
                System.out.println(fila);
                String[] contenido = fila.split(",");
                //Aparcamiento(int PARCodigo, String PARNombrePar, String PARtipo, int PARplazasRotacion, int PARplazasResidente, int PARplazasDisuasorias, String PARdistrito)
                aparcamientos.add(new Aparcamiento(Integer.parseInt(contenido[0]), contenido[1], contenido[2], Integer.parseInt(contenido[3]),
                        Integer.parseInt(contenido[4]), Integer.parseInt(contenido[5]), contenido[6]));
            }

            //cierra el Scanner puntero al archivo
            leerFichero.close();
        } catch (Exception e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }
}
