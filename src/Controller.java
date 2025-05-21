/**
 * Clase que coordina el modelo y la vista (patrón MVC)
 */
public class Controller {
    /**
     * Inicia la aplicación cargando datos de prueba y mostrando el menú
     */
    public static void iniciarAplicacion() {
        cargarDatosDePrueba();
        View.menu();
    }

    private static void cargarDatosDePrueba() {
        Model.crearCoche("Ferrari", "ABC 1234");
        Model.crearCoche("BMW", "XYZ 5678");
        Model.crearCoche("Audi", "DEF 9012");

        // Establecer velocidades iniciales
        Model.cambiarVelocidad("ABC 1234", 120);
        Model.cambiarVelocidad("XYZ 5678", 80);
    }

    /**
     * Método para mostrar la velocidad de un coche
     * @param matricula Matrícula del coche
     */
    public static void mostrarVelocidadCoche(String matricula) {
        int velocidad = Model.getVelocidad(matricula);
        View.mostrarVelocidad(matricula, velocidad);
    }
}