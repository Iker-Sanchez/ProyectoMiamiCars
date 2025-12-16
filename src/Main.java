import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner e = new Scanner(System.in);
        boolean acabado=false;

        while (acabado==false) {
            System.out.println("Sobre que tabla quieres hacer acciones: ");
            System.out.println("1.- CLIENTES");
            System.out.println("2.- COCHES");
            int eleccion = e.nextInt();

            switch (eleccion) {
                case 1:
                    System.out.println("1.- Dar de Alta Cliente: ");
                    System.out.println("2.- Modificar Cliente");
                    System.out.println("3.- Listado Clientes");
                    System.out.println("4.- Buscar Cliente");
                    int eleccionCliente = e.nextInt();

                    switch (eleccionCliente) {
                        case 1:
                            break;

                        case 2:
                            break;

                        case 3:
                            listadoClientes();
                            break;

                        case 4:
                            break;
                    }
                    break;

                case 2:
                    System.out.println("1.- Dar de Alta Coche: ");
                    System.out.println("2.- Modificar Coche");
                    System.out.println("3.- Listado Coche");
                    System.out.println("4.- Buscar Coche");
                    int eleccionCoche = e.nextInt();

                    switch (eleccionCoche) {
                        case 1:
                            break;

                        case 2:
                            break;

                        case 3:
                            break;

                        case 4:
                            break;
                    }
                    break;
            }
        }
    }



    public static void listadoClientes() {
        String sql = "SELECT * FROM coches";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("LLISTADO DE COCHES");
            System.out.println("----------------------------------------------------");

            while (rs.next()) {

                String matricula = rs.getString("matricula");
                String numBastidor = rs.getString("num_bastidor");
                String marca = rs.getString("marca");
                String modelo = rs.getString("modelo");
                String color = rs.getString("color");
                String tipoCoche = rs.getString("tipo_coche");
                int plazas = rs.getInt("plazas");
                int puertas = rs.getInt("puertas");
                String combustible = rs.getString("combustible");

                System.out.println(
                        "Matrícula: " + matricula +
                                " | Bastidor: " + numBastidor +
                                " | Marca: " + marca +
                                " | Modelo: " + modelo +
                                " | Color: " + color +
                                " | Tipo: " + tipoCoche +
                                " | Plazas: " + plazas +
                                " | Puertas: " + puertas +
                                " | Combustible: " + combustible
                );
            }

        } catch (Exception b) {
            System.out.println("Error al listar los coches");
            b.printStackTrace();
        }
    }
}