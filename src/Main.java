import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner e = new Scanner(System.in);
        boolean acabado=false;

        while (acabado==false) {
            System.out.println("Sobre que tabla quieres hacer acciones: ");
            System.out.println("1.- CLIENTES");
            System.out.println("2.- COCHES");
            System.out.println("3.- ALQUILERES");
            int eleccion;
            try {
                eleccion = e.nextInt();
            } catch (InputMismatchException ex) {
                System.out.println("❌ Debes introducir un número.");
                e.nextLine(); // limpiar buffer
                continue;     // volver al menú principal
            }
            switch (eleccion) {
                case 1:
                    System.out.println("1.- Dar de Alta Cliente: ");
                    System.out.println("2.- Modificar Cliente");
                    System.out.println("3.- Listado Clientes");
                    System.out.println("4.- Buscar Cliente");
                    System.out.println("5.- Salir");
                    int eleccionCliente;
                    try {
                        eleccionCliente = e.nextInt();
                    } catch (InputMismatchException ex) {
                        System.out.println("❌ Debes introducir un número.");
                        e.nextLine(); // limpiar buffer
                        continue;     // volver al menú principal
                    }

                    switch (eleccionCliente) {
                        case 1:
                            darDeAltaCliente();
                            break;

                        case 2:
                            modificarCliente();
                            break;

                        case 3:
                            listadoClientes();
                            break;

                        case 4:
                            buscarClienteDni();
                            break;

                    }
                    break;

                case 2:
                    System.out.println("1.- Dar de Alta Coche: ");
                    System.out.println("2.- Modificar Coche");
                    System.out.println("3.- Listado Coche");
                    System.out.println("4.- Buscar Coche");
                    System.out.println("5.- Salir");
                    int eleccionCoche;
                    try {
                        eleccionCoche = e.nextInt();
                    } catch (InputMismatchException ex) {
                        System.out.println("❌ Debes introducir un número.");
                        e.nextLine(); // limpiar buffer
                        continue;     // volver al menú principal
                    }

                    switch (eleccionCoche) {
                        case 1:
                            darDeAltaCoche();
                            break;

                        case 2:
                            modificarCoche();
                            break;

                        case 3:
                            listadoCoches();
                            break;

                        case 4:
                            buscarCocheMatricula();
                            break;

                    }
                    break;

                case 3:
                    System.out.println("1.- Alquilar Coche");
                    System.out.println("2.- Devolver Coche");
                    System.out.println("3.- Listado de Coches Disponibles");
                    System.out.println("4.- Listado de Coches Alquilados");
                    System.out.println("5.- Salir");
                    int opcion;
                    try {
                        opcion = e.nextInt();
                    } catch (InputMismatchException ex) {
                        System.out.println("❌ Debes introducir un número.");
                        e.nextLine();
                        continue;
                    }

                    switch (opcion) {
                        case 1:
                            alquilarCoche();
                            break;
                        case 2:
                            devolverCoche();
                            break;
                        case 3:
                            listarCochesDisponibles();
                            break;
                        case 4:
                            listarCochesAlquilados();
                            break;
                        case 5:
                            break;
                        default:
                            System.out.println("❌ Opción no válida.");
                    }
                    break;

            }
        }
    }

    public static void darDeAltaCliente() {
        Scanner e = new Scanner(System.in);
        String sql = "Insert into clientes (dni, nombre, apellidos, edad, telefono, direccion, email, permiso_conduccion ) values (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            System.out.println("Introduce el DNI");
            String dniUsuario = e.nextLine();
            stmt.setString(1, dniUsuario);
            System.out.println("Introduce el nombre");
            String nombreUsuario = e.nextLine();
            stmt.setString(2, nombreUsuario);
            System.out.println("Introduce el apellido");
            String apellidoUsuario = e.nextLine();
            stmt.setString(3, apellidoUsuario);
            System.out.println("Introduce el edad");
            int edadUsuario = e.nextInt();
            e.nextLine();
            stmt.setInt(4, edadUsuario);
            System.out.println("Introduce el telefono");
            String telefonoUsuario = e.nextLine();
            stmt.setString(5, telefonoUsuario);
            System.out.println("Introduce el direccion");
            String direccionUsuario = e.nextLine();
            stmt.setString(6, direccionUsuario);
            System.out.println("Introduce el email");
            String emailUsuario = e.nextLine();
            stmt.setString(7, emailUsuario);
            System.out.println("Introduce el permiso conduccion");
            String permisoConduccionUsuario = e.nextLine();
            stmt.setString(8, permisoConduccionUsuario);
            stmt.executeUpdate();
            System.out.println("Cliente dado de alta correctamente");
        } catch (RuntimeException | SQLException b) {
            System.out.println("Error al añadir el cliente");
            b.printStackTrace();
        }
    }
    public static void darDeAltaCoche(){
        Scanner e = new Scanner(System.in);
        String sql = "Insert into coches (matricula, num_bastidor, marca, modelo, color, tipo_coche, plazas, puertas, combustible ) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try(Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){
            System.out.println("Introduce la matricula");
            String matricula = e.nextLine();
            stmt.setString(1, matricula);
            System.out.println("Introduc el numero de bastidor");
            String numBastidor = e.nextLine();
            stmt.setInt(2, Integer.parseInt(numBastidor));
            System.out.println("Introduce la marca");
            String marca = e.nextLine();
            stmt.setString(3, marca);
            System.out.println("Introduce la modelo");
            String modelo = e.nextLine();
            stmt.setString(4, modelo);
            System.out.println("Introduce la color");
            String color = e.nextLine();
            stmt.setString(5, color);
            System.out.println("Introduce la tipo coche");
            String tipoCoche = e.nextLine();
            stmt.setString(6, tipoCoche);
            System.out.println("Introduce la plazas");
            int plazas = e.nextInt();
            stmt.setInt(7, plazas);
            System.out.println("Introduce la puertas");
            int puertas = e.nextInt();
            stmt.setInt(8, puertas);
            e.nextLine();
            System.out.println("Introduce la combustible (gasolina, diesel, electrico)");
            String combustible = e.nextLine();
            stmt.setString(9, combustible);
            stmt.executeUpdate();
            System.out.println("Coche dado de alta correctamente");
        } catch (RuntimeException | SQLException b) {
            System.out.println("erro al añadir el coche");
            b.printStackTrace();
        }
    }
    public static void listadoCoches() {
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


    public static void listadoClientes () {
        String sql = "SELECT * FROM clientes";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("LLISTADO DE CLIENTES");
            System.out.println("----------------------------------------------------");

            while (rs.next()) {

                String dni = rs.getString("dni");
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");
                int edad = rs.getInt("edad");
                String telefono = rs.getString("telefono");
                String direccion = rs.getString("direccion");
                String email = rs.getString("email");
                String permiso_conduccion = rs.getString("permiso_conduccion");

                System.out.println(
                        "DNI: " + dni +
                                " | Nombre: " + nombre +
                                " | Apellidos: " + apellidos +
                                " | Edad: " + edad +
                                " | Telefono: " + telefono +
                                " | Direccion: " + direccion +
                                " | Email: " + email +
                                " | Permiso Conduccion: " + permiso_conduccion
                );
            }

        } catch (Exception b) {
            System.out.println("Error al listar los coches");
            b.printStackTrace();
        }
    }
    public static void modificarCliente() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce el DNI del cliente a modificar: ");
        String dni = sc.nextLine().trim();

        String selectSql = "SELECT dni, nombre, apellidos, edad, telefono, direccion, email, permiso_conduccion " +
                "FROM clientes WHERE dni = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement psSelect = conn.prepareStatement(selectSql)) {
            if (clienteTieneAlquilerActivo(conn, dni)) {
                System.out.println("❌ No se puede modificar: el cliente tiene un coche alquilado actualmente.");
                return;
            }


            psSelect.setString(1, dni);
            try (ResultSet rs = psSelect.executeQuery()) {

                if (!rs.next()) {
                    System.out.println("No existe ningún cliente con DNI: " + dni);
                    return;
                }

                // Datos actuales
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");
                int edad = rs.getInt("edad");
                String telefono = rs.getString("telefono");
                String direccion = rs.getString("direccion");
                String email = rs.getString("email");
                String permiso = rs.getString("permiso_conduccion");

                boolean salir = false;
                while (!salir) {
                    System.out.println("\n=== CLIENTE ENCONTRADO ===");
                    System.out.println("DNI: " + dni);
                    System.out.println("Nombre: " + nombre);
                    System.out.println("Apellidos: " + apellidos);
                    System.out.println("Edad: " + edad);
                    System.out.println("Teléfono: " + telefono);
                    System.out.println("Dirección: " + direccion);
                    System.out.println("Email: " + email);
                    System.out.println("Permiso conducción: " + permiso);

                    System.out.println("\n¿Qué campo quieres modificar?");
                    System.out.println("1. Nombre");
                    System.out.println("2. Apellidos");
                    System.out.println("3. Edad");
                    System.out.println("4. Teléfono");
                    System.out.println("5. Dirección");
                    System.out.println("6. Email");
                    System.out.println("7. Permiso conducción");
                    System.out.println("0. Salir");
                    System.out.print("Opción: ");

                    int opcion = leerEnteroSeguro(sc);

                    String updateSql;
                    switch (opcion) {
                        case 1:
                            System.out.print("Nuevo nombre: ");
                            String nuevoNombre = leerTextoSeguro(sc);
                            updateSql = "UPDATE clientes SET nombre = ? WHERE dni = ?";
                            if (ejecutarUpdate(conn, updateSql, nuevoNombre, dni)) nombre = nuevoNombre;
                            break;

                        case 2:
                            System.out.print("Nuevos apellidos: ");
                            String nuevosApellidos = leerTextoSeguro(sc);
                            updateSql = "UPDATE clientes SET apellidos = ? WHERE dni = ?";
                            if (ejecutarUpdate(conn, updateSql, nuevosApellidos, dni)) apellidos = nuevosApellidos;
                            break;

                        case 3:
                            System.out.print("Nueva edad: ");
                            int nuevaEdad = leerEnteroSeguro(sc);
                            updateSql = "UPDATE clientes SET edad = ? WHERE dni = ?";
                            if (ejecutarUpdate(conn, updateSql, nuevaEdad, dni)) edad = nuevaEdad;
                            break;

                        case 4:
                            System.out.print("Nuevo teléfono (solo números): ");
                            String nuevoTelefono = leerSoloNumeros(sc);
                            updateSql = "UPDATE clientes SET telefono = ? WHERE dni = ?";
                            if (ejecutarUpdate(conn, updateSql, nuevoTelefono, dni)) telefono = nuevoTelefono;
                            break;

                        case 5:
                            System.out.print("Nueva dirección: ");
                            String nuevaDireccion = sc.nextLine().trim();
                            while (nuevaDireccion.isEmpty()) {
                                System.out.print("La dirección no puede estar vacía. Repite: ");
                                nuevaDireccion = sc.nextLine().trim();
                            }
                            updateSql = "UPDATE clientes SET direccion = ? WHERE dni = ?";
                            if (ejecutarUpdate(conn, updateSql, nuevaDireccion, dni)) direccion = nuevaDireccion;
                            break;

                        case 6:
                            System.out.print("Nuevo email: ");
                            String nuevoEmail = sc.nextLine().trim();
                            while (nuevoEmail.isEmpty() || !nuevoEmail.contains("@")) {
                                System.out.print("Email no válido. Repite: ");
                                nuevoEmail = sc.nextLine().trim();
                            }
                            updateSql = "UPDATE clientes SET email = ? WHERE dni = ?";
                            if (ejecutarUpdate(conn, updateSql, nuevoEmail, dni)) email = nuevoEmail;
                            break;

                        case 7:
                            System.out.print("Nuevo permiso de conducción: ");
                            String nuevoPermiso = sc.nextLine().trim();
                            while (nuevoPermiso.isEmpty()) {
                                System.out.print("No puede estar vacío. Repite: ");
                                nuevoPermiso = sc.nextLine().trim();
                            }
                            updateSql = "UPDATE clientes SET permiso_conduccion = ? WHERE dni = ?";
                            if (ejecutarUpdate(conn, updateSql, nuevoPermiso, dni)) permiso = nuevoPermiso;
                            break;

                        case 0:
                            salir = true;
                            break;

                        default:
                            System.out.println("Opción no válida.");
                    }
                }
            }

        } catch (Exception ex) {
            System.out.println("Error al modificar el cliente.");
            ex.printStackTrace();
        }
    }
    public static void modificarCoche() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce la MATRÍCULA del coche a modificar: ");
        String matricula = sc.nextLine().trim();

        String selectSql = "SELECT matricula, num_bastidor, marca, modelo, color, tipo_coche, plazas, puertas, combustible " +
                "FROM coches WHERE matricula = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement psSelect = conn.prepareStatement(selectSql)) {

            if (cocheEstaAlquilado(conn, matricula)) {
                System.out.println("❌ No se puede modificar: el coche está actualmente alquilado.");
                return;
            }

            psSelect.setString(1, matricula);
            try (ResultSet rs = psSelect.executeQuery()) {

                if (!rs.next()) {
                    System.out.println("No existe ningún coche con matrícula: " + matricula);
                    return;
                }

                String numBastidor = rs.getString("num_bastidor");
                String marca = rs.getString("marca");
                String modelo = rs.getString("modelo");
                String color = rs.getString("color");
                String tipoCoche = rs.getString("tipo_coche");
                int plazas = rs.getInt("plazas");
                int puertas = rs.getInt("puertas");
                String combustible = rs.getString("combustible");

                boolean salir = false;
                while (!salir) {
                    System.out.println("\n=== COCHE ENCONTRADO ===");
                    System.out.println("Matrícula: " + matricula);
                    System.out.println("Nº Bastidor: " + numBastidor);
                    System.out.println("Marca: " + marca);
                    System.out.println("Modelo: " + modelo);
                    System.out.println("Color: " + color);
                    System.out.println("Tipo coche: " + tipoCoche);
                    System.out.println("Plazas: " + plazas);
                    System.out.println("Puertas: " + puertas);
                    System.out.println("Combustible: " + combustible);

                    System.out.println("\n¿Qué campo quieres modificar?");
                    System.out.println("1. Nº Bastidor");
                    System.out.println("2. Marca");
                    System.out.println("3. Modelo");
                    System.out.println("4. Color");
                    System.out.println("5. Tipo coche");
                    System.out.println("6. Plazas");
                    System.out.println("7. Puertas");
                    System.out.println("8. Combustible (gasolina/diesel/electrico)");
                    System.out.println("0. Salir");
                    System.out.print("Opción: ");

                    int opcion = leerEnteroSeguro(sc);

                    String updateSql;
                    switch (opcion) {
                        case 1:
                            System.out.print("Nuevo Nº bastidor: ");
                            String nuevoBastidor = sc.nextLine().trim();
                            while (nuevoBastidor.isEmpty()) {
                                System.out.print("No puede estar vacío. Repite: ");
                                nuevoBastidor = sc.nextLine().trim();
                            }
                            updateSql = "UPDATE coches SET num_bastidor = ? WHERE matricula = ?";
                            if (ejecutarUpdate(conn, updateSql, nuevoBastidor, matricula)) numBastidor = nuevoBastidor;
                            break;

                        case 2:
                            System.out.print("Nueva marca: ");
                            String nuevaMarca = leerTextoSeguro(sc);
                            updateSql = "UPDATE coches SET marca = ? WHERE matricula = ?";
                            if (ejecutarUpdate(conn, updateSql, nuevaMarca, matricula)) marca = nuevaMarca;
                            break;

                        case 3:
                            System.out.print("Nuevo modelo: ");
                            String nuevoModelo = leerTextoSeguro(sc);
                            updateSql = "UPDATE coches SET modelo = ? WHERE matricula = ?";
                            if (ejecutarUpdate(conn, updateSql, nuevoModelo, matricula)) modelo = nuevoModelo;
                            break;

                        case 4:
                            System.out.print("Nuevo color: ");
                            String nuevoColor = leerTextoSeguro(sc);
                            updateSql = "UPDATE coches SET color = ? WHERE matricula = ?";
                            if (ejecutarUpdate(conn, updateSql, nuevoColor, matricula)) color = nuevoColor;
                            break;

                        case 5:
                            System.out.print("Nuevo tipo de coche: ");
                            String nuevoTipo = leerTextoSeguro(sc);
                            updateSql = "UPDATE coches SET tipo_coche = ? WHERE matricula = ?";
                            if (ejecutarUpdate(conn, updateSql, nuevoTipo, matricula)) tipoCoche = nuevoTipo;
                            break;

                        case 6:
                            System.out.print("Nuevas plazas: ");
                            int nuevasPlazas = leerEnteroSeguro(sc);
                            updateSql = "UPDATE coches SET plazas = ? WHERE matricula = ?";
                            if (ejecutarUpdate(conn, updateSql, nuevasPlazas, matricula)) plazas = nuevasPlazas;
                            break;

                        case 7:
                            System.out.print("Nuevas puertas: ");
                            int nuevasPuertas = leerEnteroSeguro(sc);
                            updateSql = "UPDATE coches SET puertas = ? WHERE matricula = ?";
                            if (ejecutarUpdate(conn, updateSql, nuevasPuertas, matricula)) puertas = nuevasPuertas;
                            break;

                        case 8:
                            System.out.print("Nuevo combustible (gasolina/diesel/electrico): ");
                            String nuevoComb = sc.nextLine().trim().toLowerCase();
                            while (!(nuevoComb.equals("gasolina") || nuevoComb.equals("diesel") || nuevoComb.equals("electrico"))) {
                                System.out.print("Valor no válido. Repite (gasolina/diesel/electrico): ");
                                nuevoComb = sc.nextLine().trim().toLowerCase();
                            }
                            updateSql = "UPDATE coches SET combustible = ? WHERE matricula = ?";
                            if (ejecutarUpdate(conn, updateSql, nuevoComb, matricula)) combustible = nuevoComb;
                            break;

                        case 0:
                            salir = true;
                            break;

                        default:
                            System.out.println("Opción no válida.");
                    }
                }
            }

        } catch (Exception ex) {
            System.out.println("Error al modificar el coche.");
            ex.printStackTrace();
        }
    }

    private static int leerEnteroSeguro(Scanner sc) {
        while (true) {
            String linea = sc.nextLine().trim();
            try {
                return Integer.parseInt(linea);
            } catch (NumberFormatException ex) {
                System.out.print("Entrada no válida. Introduce un número: ");
            }
        }
    }

    private static String leerTextoSeguro(Scanner sc) {
        while (true) {
            String txt = sc.nextLine().trim();
            if (txt.isEmpty()) {
                System.out.print("No puede estar vacío. Repite: ");
                continue;
            }
            // Solo letras y espacios (acepta tildes/ñ y caracteres catalanes básicos)
            if (!txt.matches("[\\p{L} ]+")) {
                System.out.print("No se permiten números ni caracteres especiales. Repite: ");
                continue;
            }
            return txt;
        }
    }

    private static String leerSoloNumeros(Scanner sc) {
        while (true) {
            String txt = sc.nextLine().trim();
            if (txt.matches("\\d+")) return txt;
            System.out.print("Solo se permiten números. Repite: ");
        }
    }

    private static boolean ejecutarUpdate(Connection conn, String sql, Object valor, String id) {
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, valor);
            ps.setString(2, id);

            int filas = ps.executeUpdate();
            if (filas > 0) {
                System.out.println("Modificación realizada correctamente.");
                return true;
            } else {
                System.out.println("No se realizó ningún cambio.");
                return false;
            }
        } catch (Exception ex) {
            System.out.println("Error al ejecutar la modificación.");
            ex.printStackTrace();
            return false;
        }
    }

    public static void buscarClienteDni () throws SQLException {
        Scanner e = new Scanner(System.in);
        System.out.println("Escribe el DNI del empleado: ");
        String DNI=e.next();

        String sql = "SELECT * FROM clientes WHERE dni = ?";

        try (Connection conn=DBConnection.getConnection();
             PreparedStatement ps=conn.prepareStatement(sql)) {
            ps.setString(1,DNI);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("CLIENTE ENCONTRADO");
                System.out.println("--------------------------------");

                System.out.println(
                        "DNI: " + rs.getString("dni") +
                                " | Nombre: " + rs.getString("nombre") +
                                " | Apellidos: " + rs.getString("apellidos") +
                                " | Edad: " + rs.getInt("edad") +
                                " | Teléfono: " + rs.getString("telefono") +
                                " | Dirección: " + rs.getString("direccion") +
                                " | Email: " + rs.getString("email") +
                                " | Permiso: " + rs.getString("permiso_conduccion")
                );
            } else {
                System.out.println("No existe ningún cliente con ese DNI");
            }
        } catch (Exception a) {
            System.out.println("Error al buscar el cliente");
            a.printStackTrace();
        }
    }

    public static void buscarCocheMatricula () throws SQLException {
        Scanner e = new Scanner(System.in);
        System.out.println("Escribe la matricula del coche: ");
        String matricula=e.next();

        String sql = "SELECT * FROM coches WHERE matricula = ?";

        try (Connection conn=DBConnection.getConnection();
             PreparedStatement ps=conn.prepareStatement(sql)) {
            ps.setString(1,matricula);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("COCHE ENCONTRADO");
                System.out.println("--------------------------------");

                System.out.println(
                        "Matricula: " + rs.getString("matricula") +
                                " | Num Bastidor: " + rs.getString("num_bastidor") +
                                " | Marca: " + rs.getString("marca") +
                                " | Modelo: " + rs.getString("modelo") +
                                " | Color: " + rs.getString("color") +
                                " | Tipo Coche: " + rs.getString("tipo_coche") +
                                " | plazas: " + rs.getInt("plazas") +
                                " | puertas: " + rs.getInt("puertas") +
                                " | combustible: " + rs.getString("combustible")

                );
            } else {
                System.out.println("No existe ningún coche con esta matricula");
            }
        } catch (Exception a) {
            System.out.println("Error al buscar el coche");
            a.printStackTrace();
        }
    }

    public static void alquilarCoche() {
        Scanner sc = new Scanner(System.in);
        sc.nextLine(); // 🔥 limpia el salto de línea pendiente de los nextInt del menú

        System.out.print("DNI del cliente: ");
        String dni = sc.nextLine().trim();

        System.out.print("Matrícula del coche: ");
        String matricula = sc.nextLine().trim();

        LocalDate fechaPrevista = leerFecha(sc, "Fecha devolución prevista");
        System.out.print("Lugar de devolución: ");
        String lugarDevolucion = sc.nextLine().trim();

        double precioDia = leerDouble(sc, "Precio por día (€)");
        double penalizacionDia = leerDouble(sc, "Penalización por día de retraso (€)");
        boolean depositoLlenoPrevisto = leerSiNo(sc, "¿Debe devolverse con depósito lleno?");

        String comprobarCliente = "SELECT 1 FROM clientes WHERE dni = ?";
        String comprobarCoche = "SELECT disponible FROM coches WHERE matricula = ?";

        String insertarAlquiler =
                "INSERT INTO alquileres " +
                        "(dni_cliente, matricula, fecha_inicio, fecha_devolucion_prevista, lugar_devolucion, " +
                        " precio_dia, penalizacion_dia, deposito_lleno_previsto, devuelto) " +
                        "VALUES (?, ?, CURDATE(), ?, ?, ?, ?, ?, false)";

        String ponerNoDisponible = "UPDATE coches SET disponible = false WHERE matricula = ?";

        try (Connection conn = DBConnection.getConnection()) {
            conn.setAutoCommit(false);

            // Cliente existe
            try (PreparedStatement ps = conn.prepareStatement(comprobarCliente)) {
                ps.setString(1, dni);
                try (ResultSet rs = ps.executeQuery()) {
                    if (!rs.next()) {
                        System.out.println("❌ No existe cliente con ese DNI.");
                        conn.rollback();
                        return;
                    }
                }
            }

            // Coche existe y disponible
            boolean disponible;
            try (PreparedStatement ps = conn.prepareStatement(comprobarCoche)) {
                ps.setString(1, matricula);
                try (ResultSet rs = ps.executeQuery()) {
                    if (!rs.next()) {
                        System.out.println("❌ No existe coche con esa matrícula.");
                        conn.rollback();
                        return;
                    }
                    disponible = rs.getBoolean("disponible");
                }
            }

            if (!disponible) {
                System.out.println("❌ Ese coche ya está alquilado.");
                conn.rollback();
                return;
            }

            // Insert alquiler
            try (PreparedStatement ps = conn.prepareStatement(insertarAlquiler)) {
                ps.setString(1, dni);
                ps.setString(2, matricula);
                ps.setDate(3, Date.valueOf(fechaPrevista));
                ps.setString(4, lugarDevolucion);
                ps.setDouble(5, precioDia);
                ps.setDouble(6, penalizacionDia);
                ps.setBoolean(7, depositoLlenoPrevisto);
                ps.executeUpdate();
            }

            // Marcar coche no disponible
            try (PreparedStatement ps = conn.prepareStatement(ponerNoDisponible)) {
                ps.setString(1, matricula);
                ps.executeUpdate();
            }

            conn.commit();
            System.out.println("✅ Coche alquilado correctamente.");
            System.out.println("Devolución prevista: " + fechaPrevista + " | Lugar: " + lugarDevolucion);

        } catch (Exception ex) {
            System.out.println("Error al alquilar coche.");
            ex.printStackTrace();
        }
    }


    public static void devolverCoche() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Matrícula del coche a devolver: ");
        String matricula = sc.nextLine().trim();

        boolean usarHoy = leerSiNo(sc, "¿La fecha de devolución real es HOY?");
        LocalDate fechaReal = usarHoy ? LocalDate.now() : leerFecha(sc, "Fecha devolución real");

        boolean depositoLlenoDevuelto = leerSiNo(sc, "¿Devuelve con depósito lleno?");
        double recargoCombustible = depositoLlenoDevuelto ? 0.0 : leerDouble(sc, "Recargo por NO depósito lleno (€)");

        String buscarActivo =
                "SELECT id, fecha_inicio, fecha_devolucion_prevista, precio_dia, penalizacion_dia, deposito_lleno_previsto " +
                        "FROM alquileres WHERE matricula = ? AND devuelto = false " +
                        "ORDER BY fecha_inicio DESC LIMIT 1";

        String actualizarAlquiler =
                "UPDATE alquileres SET " +
                        " devuelto = true, " +
                        " fecha_fin = ?, " +  // usamos tu campo fecha_fin como fecha real
                        " deposito_lleno_devuelto = ?, " +
                        " dias_alquiler = ?, " +
                        " dias_retraso = ?, " +
                        " recargo_combustible = ?, " +
                        " total_final = ? " +
                        "WHERE id = ?";

        String ponerDisponible = "UPDATE coches SET disponible = true WHERE matricula = ?";

        try (Connection conn = DBConnection.getConnection()) {
            conn.setAutoCommit(false);

            Integer id = null;
            LocalDate fechaInicio = null;
            LocalDate fechaPrevista = null;
            double precioDia = 0, penalizacionDia = 0;
            boolean depositoLlenoPrevisto = true;

            // Buscar alquiler activo
            try (PreparedStatement ps = conn.prepareStatement(buscarActivo)) {
                ps.setString(1, matricula);
                try (ResultSet rs = ps.executeQuery()) {
                    if (!rs.next()) {
                        System.out.println("❌ No hay alquiler activo para esa matrícula.");
                        conn.rollback();
                        return;
                    }
                    id = rs.getInt("id");
                    fechaInicio = rs.getDate("fecha_inicio").toLocalDate();
                    fechaPrevista = rs.getDate("fecha_devolucion_prevista").toLocalDate();
                    precioDia = rs.getDouble("precio_dia");
                    penalizacionDia = rs.getDouble("penalizacion_dia");
                    depositoLlenoPrevisto = rs.getBoolean("deposito_lleno_previsto");
                }
            }

            long diasAlquiler = java.time.temporal.ChronoUnit.DAYS.between(fechaInicio, fechaReal);
            if (diasAlquiler < 1) diasAlquiler = 1;

            long diasRetraso = java.time.temporal.ChronoUnit.DAYS.between(fechaPrevista, fechaReal);
            if (diasRetraso < 0) diasRetraso = 0;

            double recargo = 0.0;
            if (depositoLlenoPrevisto && !depositoLlenoDevuelto) recargo = recargoCombustible;

            double total = diasAlquiler * precioDia + diasRetraso * penalizacionDia + recargo;

            // Guardar devolución
            try (PreparedStatement ps = conn.prepareStatement(actualizarAlquiler)) {
                ps.setDate(1, Date.valueOf(fechaReal));
                ps.setBoolean(2, depositoLlenoDevuelto);
                ps.setInt(3, (int) diasAlquiler);
                ps.setInt(4, (int) diasRetraso);
                ps.setDouble(5, recargo);
                ps.setDouble(6, total);
                ps.setInt(7, id);
                ps.executeUpdate();
            }

            // Marcar coche disponible
            try (PreparedStatement ps = conn.prepareStatement(ponerDisponible)) {
                ps.setString(1, matricula);
                ps.executeUpdate();
            }

            conn.commit();

            System.out.println("✅ Coche devuelto correctamente.");
            System.out.println("Días alquiler: " + diasAlquiler);
            System.out.println("Días retraso: " + diasRetraso);
            System.out.println("Recargo combustible: " + recargo + "€");
            System.out.println("TOTAL FINAL: " + total + "€");

        } catch (Exception ex) {
            System.out.println("Error al devolver coche.");
            ex.printStackTrace();
        }
    }


    public static void listarCochesDisponibles() {
        String sql = "SELECT * FROM coches WHERE disponible = true";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("COCHES DISPONIBLES");
            System.out.println("--------------------------------");

            while (rs.next()) {
                System.out.println(
                        "Matrícula: " + rs.getString("matricula") +
                                " | Marca: " + rs.getString("marca") +
                                " | Modelo: " + rs.getString("modelo") +
                                " | Combustible: " + rs.getString("combustible")
                );
            }

        } catch (Exception ex) {
            System.out.println("Error al listar coches disponibles.");
            ex.printStackTrace();
        }
    }

    private static boolean cocheEstaAlquilado(Connection conn, String matricula) throws SQLException {
        String sql = "SELECT disponible FROM coches WHERE matricula = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, matricula);
            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next()) return false; // si no existe, ya lo controlas antes
                return !rs.getBoolean("disponible"); // si disponible=false => alquilado
            }
        }
    }

    private static boolean clienteTieneAlquilerActivo(Connection conn, String dni) throws SQLException {
        String sql = "SELECT 1 FROM alquileres WHERE dni_cliente = ? AND devuelto = false LIMIT 1";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, dni);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next(); // si hay fila => tiene alquiler activo
            }
        }
    }

    private static LocalDate leerFecha(Scanner sc, String mensaje) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        while (true) {
            System.out.print(mensaje + " (YYYY-MM-DD): ");
            String txt = sc.nextLine().trim();
            try {
                return LocalDate.parse(txt, fmt);
            } catch (DateTimeParseException ex) {
                System.out.println("❌ Fecha inválida. Ejemplo: 2026-01-26");
            }
        }
    }

    private static double leerDouble(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje + ": ");
            String txt = sc.nextLine().trim().replace(',', '.');
            try {
                return Double.parseDouble(txt);
            } catch (NumberFormatException ex) {
                System.out.println("❌ Número inválido.");
            }
        }
    }

    private static boolean leerSiNo(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje + " (s/n): ");
            String txt = sc.nextLine().trim().toLowerCase();
            if (txt.equals("s") || txt.equals("si")) return true;
            if (txt.equals("n") || txt.equals("no")) return false;
            System.out.println("❌ Responde con s o n.");
        }
    }

    public static void listarCochesAlquilados() {
        String sql =
                "SELECT a.matricula, c.dni, c.nombre, c.telefono, " +
                        "       a.fecha_devolucion_prevista, a.lugar_devolucion, a.devuelto " +
                        "FROM alquileres a " +
                        "JOIN clientes c ON c.dni = a.dni_cliente " +
                        "WHERE a.devuelto = false " +
                        "ORDER BY a.fecha_devolucion_prevista ASC";

        try (Connection conn = DBConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            System.out.println("COCHES ACTUALMENTE ALQUILADOS");
            System.out.println("--------------------------------------------------");

            boolean hay = false;
            while (rs.next()) {
                hay = true;
                System.out.println(
                        "Matrícula: " + rs.getString("matricula") +
                                " | DNI: " + rs.getString("dni") +
                                " | Nombre: " + rs.getString("nombre") +
                                " | Tel: " + rs.getString("telefono") +
                                " | Devolver: " + rs.getDate("fecha_devolucion_prevista") +
                                " | Lugar: " + rs.getString("lugar_devolucion") +
                                " | Devuelto: " + rs.getBoolean("devuelto")
                );
            }

            if (!hay) System.out.println("No hay coches alquilados ahora mismo.");

        } catch (Exception ex) {
            System.out.println("Error al listar coches alquilados.");
            ex.printStackTrace();
        }
    }

}