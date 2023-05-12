
/**
 *
 * @author Pedro G Gallardo
 */
import java.sql.*;
import java.util.Scanner;

public class NewMain {

    public static Scanner in = new Scanner(System.in);

    public static void comprueba(int resultado) throws Exception {
        if (resultado == 1) {
            System.out.println("Hecho");
        } else {
            throw new Exception("Error en el proceso");
        }
    }

    public static void comprueba(boolean resultado) throws Exception {
        if (!resultado) {
            System.out.println("Hecho");
        } else {
            throw new Exception("Error en el proceso");
        }
    }

    public static void corrigesSaltosLinea() {
        if (in.hasNextLine()) {
            in.nextLine();
        }
    }

    public static int menu() throws Exception {
        System.out.println("\n\n-------------------Menu-------------------\n");
        System.out.println("Opcion 1:Mostrar todos los contactos\nOpcion 2:Añadir contacto\nOpcion 3:Editar contacto\nOpcion 4:Eliminar contacto\nOpcion 5:Salir");
        if (!in.hasNextInt()) {
            throw new Exception("Error en la toma de datos, se esperaba una opcion numerica");
        }
        return in.nextInt();
    }

    public static void muestraContactos(Statement stmt) throws Exception {
        //muestra todo el contenido de la tabla creada previamente
        ResultSet rs = stmt.executeQuery("SELECT * FROM contactos");
        //bucle para mostrar el contenido
        while (rs.next()) {
            int id = rs.getInt("id");
            String nombre = rs.getString("nombre");
            int telefono = rs.getInt("telefono");
            System.out.println("ID: " + id + " Nombre: " + nombre + " Telefono: " + telefono);
        }
    }

    public static void añadeContacto(Statement stmt) throws Exception {
        boolean ex = true;
        //toma de datos del contacto a añadir
        System.out.println("Se van a introducir datos en la tabla contactos de la Base de Datos AGENDA\nA continuacion se pide introducir el ID");
        int id = in.nextInt();
        corrigesSaltosLinea();
        System.out.println("Introduzca el nombre");
        String nombre = in.nextLine();
        System.out.println("Introduzca el numero de telefono");
        int telefono = in.nextInt();
        corrigesSaltosLinea();
        //insertar elementos en la tabla
        ex = stmt.execute("insert into contactos(id, nombre, telefono) value (" + id + ", '" + nombre + "', " + telefono + ");");
        System.out.println("insert into contactos(id, nombre, telefono) value (" + id + ", '" + nombre + "', " + telefono + ");");
        comprueba(ex);
    }

    public static void editarContacto(Statement stmt) throws Exception {
        boolean ex = true;
        int nuevoTelefono;
        String nuevoNombre = "";
        muestraContactos(stmt);
        System.out.println("Introduzca el ID del contacto que desea modificar");
        int id = in.nextInt();
        corrigesSaltosLinea();

        //recoge los nuevos datos a modificar
        System.out.println("Nuevo nombre que desea cambiar");
        nuevoNombre = in.nextLine();
        System.out.println("Nuevo telefono que desea cambiar");
        nuevoTelefono = in.nextInt();
        corrigesSaltosLinea();

        //modifica si es necesario los valores
        if (!nuevoNombre.equals("")) {
            ex = stmt.execute("update contactos SET nombre='" + nuevoNombre + "' WHERE id=" + id + ";");
            System.out.println("update contactos SET nombre=" + nuevoNombre + " WHERE id=" + id + ";");
            comprueba(ex);
        }
        ex = stmt.execute("update contactos SET telefono=" + nuevoTelefono + " WHERE id=" + id + ";");
        System.out.println("update contactos SET telefono=" + nuevoTelefono + " WHERE id=" + id + ";");
        comprueba(ex);
    }

    public static void eliminarContacto(Statement stmt) throws Exception {
        boolean ex = true;
        muestraContactos(stmt);
        System.out.println("Introduzca el ID del contacto que desea eliminar");
        int id = in.nextInt();
        corrigesSaltosLinea();

        //insertar elementos en la tabla
        ex = stmt.execute("delete from contactos WHERE id=" + id + ";");
        System.out.println("delete from contactos WHERE id=" + id + ";");
        comprueba(ex);
    }

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            String url = "jdbc:mysql://10.230.108.220:3306/mysql?serverTimezone=UTC";
            Connection conn = DriverManager.getConnection(url, "root", "");
            Statement stmt = conn.createStatement();

            int nr, opcion;
            boolean ex = true;

            //elimina si existiera la base de datos probando
//            nr = stmt.executeUpdate("DROP DATABASE PROBANDO;");
//            System.out.println("DROP DATABASE PROBANDO;");
//            comprueba(nr);
            //crea de nuevo la base de datos probando
//            nr = stmt.executeUpdate("CREATE DATABASE AGENDA;");
//            System.out.println("CREATE DATABASE AGENDA;");
//            comprueba(nr);
            //entra en la base de datos recien creada
            ex = stmt.execute("USE AGENDA;");
            System.out.println("USE AGENDA;");
            comprueba(ex);

            //crea una tabla
//            ex = stmt.execute("create table contactos(id integer(4) PRIMARY KEY,nombre varchar(30) NOT NULL,telefono integer(9));");
//            System.out.println("create table contactos(id integer(8) PRIMARY KEY,nombre varchar(30) NOT NULL,telefono integer(9));");
//            comprueba(ex);
            //insertar elementos en la tabla
//            ex = stmt.execute("insert into contactos(id, nombre, telefono) value (0001, 'Juan',678098098), (0002, 'Francisco',678098098), (0003, 'Alfonso',678098098), (0004, 'Pepe',678098098);");
//            System.out.println("insert into contactos(id, nombre, telefono) value (0001, 'Juan',678098098), (0002, 'Francisco',678098098), (0003, 'Alfonso',678098098), (0004, 'Pepe',678098098);");
//            comprueba(ex);
            //muestra todo el contenido de la tabla creada previamente
            muestraContactos(stmt);

            System.out.println("\n\nSe acaba de crear esta base de datos con la siguiente informacion, a continuacion se abre el menu con el que podra interactuar");

            do {
                opcion = menu();
                corrigesSaltosLinea();
                switch (opcion) {
                    case 1:
                        System.out.println("\n\nSe ha seleccionado Mostrar contactos");
                        muestraContactos(stmt);
                        break;
                    case 2:
                        System.out.println("\n\nSe ha seleccionado Añadir contacto");
                        añadeContacto(stmt);
                        break;
                    case 3:
                        System.out.println("\n\nSe ha seleccionado Editar contacto");
                        editarContacto(stmt);
                        break;
                    case 4:
                        System.out.println("\n\nSe ha seleccionado Eliminar contacto");
                        eliminarContacto(stmt);
                        break;
                    case 5:
                        System.out.println("\n\nSe ha seleccionado Salir\nGracias por su tiempo");
                        break;
                    default:
                        throw new Exception("Error, la opcion seleccionada no existe.->El programa va a proceder a cerrarse");
                }
            } while (opcion != 5);

            //cierra la conexion y el statement
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }

}
