import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class testModel {
    @BeforeEach
    public void limpiarParking() {
        // Limpiar el parking antes de cada test
        Model.getTodosLosCoches().clear();
    }

    @Test
    @DisplayName("Crear coche exitosamente")
    public void crearCocheExitoso() {
        assertTrue(Model.crearCoche("Toyota", "1234ABC"));
        assertEquals(1, Model.getTodosLosCoches().size());
    }

    @Test
    @DisplayName("No crear coche con matrícula duplicada")
    public void crearCocheDuplicado() {
        Model.crearCoche("Toyota", "1234ABC");
        assertFalse(Model.crearCoche("Honda", "1234ABC"));
        assertEquals(1, Model.getTodosLosCoches().size());
    }

    @Test
    @DisplayName("Cambiar velocidad exitosamente")
    public void cambiarVelocidadExitoso() {
        Model.crearCoche("Toyota", "1234ABC");
        assertTrue(Model.cambiarVelocidad("1234ABC", 100));
        assertEquals(100, Model.getVelocidad("1234ABC"));
    }

    @Test
    @DisplayName("Acelerar coche exitosamente")
    public void acelerarCocheExitoso() {
        Model.crearCoche("Toyota", "1234ABC");
        Model.cambiarVelocidad("1234ABC", 50);
        assertEquals(51, Model.acelerarCoche("1234ABC"));
    }

    @Test
    @DisplayName("Frenar coche exitosamente")
    public void frenarCocheExitoso() {
        Model.crearCoche("Toyota", "1234ABC");
        Model.cambiarVelocidad("1234ABC", 50);
        assertEquals(49, Model.bajasVelocidad("1234ABC"));
    }

    @Test
    @DisplayName("Frenar coche con velocidad 0")
    public void frenarCocheVelocidadCero() {
        Model.crearCoche("Toyota", "1234ABC");
        Model.cambiarVelocidad("1234ABC", 0);
        assertEquals(0, Model.bajasVelocidad("1234ABC"));
    }

    @Test
    @DisplayName("Obtener coche no existente")
    public void obtenerCocheNoExistente() {
        assertFalse(Model.getCoche("NO_EXISTE").isPresent());
    }
}