/**
 * Clase que representa un coche con matrícula, modelo y velocidad
 */
public class Coche {
    private final String matricula;
    private final String modelo;
    private int velocidad;

    /**
     * Constructor de la clase Coche
     * @param modelo Modelo del coche
     * @param matricula Matrícula única del coche
     */
    public Coche(String modelo, String matricula) {
        if (modelo == null || modelo.trim().isEmpty() || matricula == null || matricula.trim().isEmpty()) {
            throw new IllegalArgumentException("Modelo y matrícula no pueden estar vacíos");
        }
        this.modelo = modelo;
        this.matricula = matricula;
        this.velocidad = 0;
    }

    // Getters
    public String getMatricula() { return matricula; }
    public String getModelo() { return modelo; }
    public int getVelocidad() { return velocidad; }

    // Setters con validación
    public void setVelocidad(int velocidad) {
        if (velocidad < 0) {
            throw new IllegalArgumentException("La velocidad no puede ser negativa");
        }
        this.velocidad = velocidad;
    }

    /**
     * Incrementa la velocidad en 1 unidad
     */
    public void acelerar() {
        this.velocidad++;
    }

    /**
     * Reduce la velocidad en 1 unidad
     * @throws IllegalStateException si la velocidad ya es 0
     */
    public void frenar() {
        if (this.velocidad == 0) {
            throw new IllegalStateException("La velocidad ya es 0");
        }
        this.velocidad--;
    }

    @Override
    public String toString() {
        return String.format("%s (%s) - %d km/h", modelo, matricula, velocidad);
    }
}