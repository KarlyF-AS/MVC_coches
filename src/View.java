import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Clase que maneja la interfaz de usuario (patrón MVC)
 */
public class View {
    private static final Scanner sc = new Scanner(System.in);

    /**
     * Muestra el menú principal y gestiona las opciones
     */
    public static void menu() {
        int opcion;
        do {
            mostrarMenu();
            opcion = leerOpcion();
            procesarOpcion(opcion);
        } while (opcion != 6);
        sc.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n Menú");
        System.out.println("1. Crear coche");
        System.out.println("2. Cambiar velocidad");
        System.out.println("3. Acelerar coche");
        System.out.println("4. Bajar velocidad");
        System.out.println("5. Mostrar todos los coches");
        System.out.println("6. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static int leerOpcion() {
        try {
            return sc.nextInt();
        } catch (InputMismatchException e) {
            sc.nextLine(); // Limpiar buffer
            return -1;
        }
    }

    private static void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1 -> crearCoche();
            case 2 -> cambiarVelocidad();
            case 3 -> acelerarCoche();
            case 4 -> bajarVelocidad();
            case 5 -> mostrarTodosLosCoches();
            case 6 -> System.out.println("Saliendo del sistema...");
            default -> System.out.println("Opción no válida. Intente nuevamente.");
        }
    }

    private static void crearCoche() {
        System.out.println("\n--- CREAR NUEVO COCHE ---");
        System.out.print("Ingrese matrícula: ");
        String matricula = sc.next();
        System.out.print("Ingrese modelo: ");
        String modelo = sc.next();

        if (Model.crearCoche(modelo, matricula)) {
            System.out.println("Coche creado exitosamente!");
        } else {
            System.out.println("Error: La matrícula ya existe o los datos son inválidos");
        }
    }

    private static void cambiarVelocidad() {
        System.out.println("\n--- CAMBIAR VELOCIDAD ---");
        System.out.print("Ingrese matrícula: ");
        String matricula = sc.next();
        System.out.print("Ingrese nueva velocidad: ");

        try {
            int velocidad = sc.nextInt();
            if (Model.cambiarVelocidad(matricula, velocidad)) {
                System.out.println("Velocidad actualizada correctamente");
            } else {
                System.out.println("Error: Coche no encontrado o velocidad inválida");
            }
        } catch (InputMismatchException e) {
            sc.nextLine();
            System.out.println("Error: La velocidad debe ser un número entero");
        }
    }

    private static void acelerarCoche() {
        System.out.println("\n--- ACELERAR COCHE ---");
        System.out.print("Ingrese matrícula: ");
        String matricula = sc.next();

        int nuevaVelocidad = Model.acelerarCoche(matricula);
        if (nuevaVelocidad != -1) {
            System.out.printf("Coche acelerado. Nueva velocidad: %d km/h%n", nuevaVelocidad);
        } else {
            System.out.println("Error: Coche no encontrado");
        }
    }

    private static void bajarVelocidad() {
        System.out.println("\n--- BAJAR VELOCIDAD ---");
        System.out.print("Ingrese matrícula: ");
        String matricula = sc.next();

        int nuevaVelocidad = Model.bajarVelocidadCoche(matricula);
        if (nuevaVelocidad != -1) {
            System.out.printf("Velocidad reducida. Nueva velocidad: %d km/h%n", nuevaVelocidad);
        } else {
            System.out.println("Error: Coche no encontrado");
        }
    }

    private static void mostrarTodosLosCoches() {
        System.out.println("\n--- LISTADO DE COCHES ---");
        List<Coche> coches = Model.getTodosLosCoches();

        if (coches.isEmpty()) {
            System.out.println("No hay coches registrados");
        } else {
            coches.forEach(System.out::println);
        }
    }

    /**
     * Muestra la velocidad de un coche específico
     * @param matricula Matrícula del coche
     * @param velocidad Velocidad actual
     */
    public static void mostrarVelocidad(String matricula, int velocidad) {
        if (velocidad == -1) {
            System.out.println("Coche no encontrado");
        } else {
            System.out.printf("Velocidad actual del coche es: de km", matricula, velocidad);
        }
    }
}