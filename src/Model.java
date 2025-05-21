import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Clase que gestiona los datos de la aplicación (patrón MVC)
 */
public class Model {
    private static final List<Coche> parking = new ArrayList<>();

    /**
     * Crea un nuevo coche y lo añade al parking
     * @param modelo Modelo del coche
     * @param matricula Matrícula única
     * @author Karly Albarrán
     * @return true si se creó correctamente, false si ya existe
     */
    public static boolean crearCoche(String modelo, String matricula) {
        if (existeMatricula(matricula)) {
            return false;
        }
        parking.add(new Coche(modelo, matricula));
        return true;
    }

    /**
     * Busca un coche por matrícula
     * @param matricula Matrícula a buscar
     * @author Karly Albarrán
     * @return Optional con el coche encontrado o vacío
     */
    public static Optional<Coche> getCoche(String matricula) {
        return parking.stream()
                .filter(c -> c.getMatricula().equals(matricula))
                .findFirst();
    }

    /**
     * Verifica si existe un coche con la matrícula dada
     * @param matricula Matrícula a verificar
     * @author Karly Albarrán
     * @return true si existe, false si no
     */
    public static boolean existeMatricula(String matricula) {
        return parking.stream().anyMatch(c -> c.getMatricula().equals(matricula));
    }

    /**
     * Cambia la velocidad de un coche
     * @param matricula Matrícula del coche
     * @param velocidad Nueva velocidad
     * @author Karly Albarrán
     * @return true si se modificó, false si no existe el coche
     */
    public static boolean cambiarVelocidad(String matricula, int velocidad) {
        Optional<Coche> coche = getCoche(matricula);
        if (coche.isPresent()) {
            coche.get().setVelocidad(velocidad);
            return true;
        }
        return false;
    }

    /**
     * Incrementa la velocidad de un coche en 1 unidad
     * @param matricula Matrícula del coche
     * @return Nueva velocidad o -1 si no existe
     */
    public static int acelerarCoche(String matricula) {
        Optional<Coche> coche = getCoche(matricula);
        if (coche.isPresent()) {
            coche.get().acelerar();
            return coche.get().getVelocidad();
        }
        return -1;
    }

    /**
     * Reduce la velocidad de un coche en 1 unidad
     * @param matricula Matrícula del coche
     * @return Nueva velocidad o -1 si no existe
     */
    public static int bajarVelocidadCoche(String matricula) {
        Optional<Coche> coche = getCoche(matricula);
        if (coche.isPresent()) {
            try {
                coche.get().frenar();
                return coche.get().getVelocidad();
            } catch (IllegalStateException e) {
                return 0;
            }
        }
        return -1;
    }

    /**
     * Obtiene la velocidad actual de un coche
     * @param matricula Matrícula del coche
     * @return Velocidad o -1 si no existe
     */
    public static int getVelocidad(String matricula) {
        return getCoche(matricula).map(Coche::getVelocidad).orElse(-1);
    }

    /**
     * Obtiene todos los coches en el parking
     * @return Lista inmutable de coches
     */
    public static List<Coche> getTodosLosCoches() {
        return List.copyOf(parking);
    }
}