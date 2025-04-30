import java.util.Scanner;

/**
 * Clase encargada de la interacción con el usuario
 */
public class View {
    /**
     * Menu incial
     */
    public static void menu() {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Selecciona una opción:");
            System.out.println("1. Crear coche");
            System.out.println("2. Cambiar velocidad");
            System.out.println("3. Mostrar velocidad");
            System.out.println("4. Salir");
            System.out.print("Opción: ");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Opción 1 seleccionada: Crear coche");
                    break;
                case 2:
                    System.out.println("Opción 2 seleccionada: Cambiar velocidad");
                    break;
                case 3:
                    System.out.println("Opción 3 seleccionada: Mostrar velocidad");
                    break;
                case 4:
                    System.out.println("Saliendo del menú...");
                    break;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        } while (opcion != 4);

        sc.close();
    }

    /**
     * Muestra la velocidad de un coche
     * @param matricula del coche
     * @param v velocidad
     * @return true si se ha mostrado correctamente
     */
    public boolean muestraVelocidad(String matricula, Integer v){
        System.out.println(matricula + ": " + v + "km/hr");
        return true;
    }
}
