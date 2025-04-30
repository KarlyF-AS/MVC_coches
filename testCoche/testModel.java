import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testModel {

    @Test
    @DisplayName("Crear coche")
    public void crearCoche(){
        Model mo = new Model();
        Coche co = mo.crearCoche("Volkswagen", "1234ABK");
        assert co.matricula.equals("1234ABK");
        assert co.modelo.equals("Volkswagen");

        Model mo2 = new Model();
        Coche co2 = mo2.crearCoche("KN", "1234ABJ");
    }
    @Test
    @DisplayName("matricula")
    public void getCoche(){
        Model mo = new Model();
        Coche co = mo.crearCoche("Volkswagen", "1234ABK");
        Coche co2 = mo.getCoche("1234ABK");
        assert co2.matricula.equals("1234ABK");
    }
    @Test
    @DisplayName("null")
    public void getCocheNull(){
        Model mo = new Model();
        Coche co2 = mo.getCoche("1234ABJ");
        assert co2 == null;
    }
    @Test
    @DisplayName("Cambiar velocidad")
    public void cambiarVelocidad(){
        Model mo = new Model();
        Coche co = mo.crearCoche("Volkswagen", "1234ABK");
        assertEquals(5000, mo.cambiarVelocidad("1234ABK", 100000));
    }
    @Test
    @DisplayName("Subir velocidad")
    public void SubirVelocidad() {
        Model mo = new Model();
        Coche co = mo.crearCoche("Volkswagen", "1234ABK");
        int nuevaVelocidad = mo.subirVelocidad("1234ABK");
        assertEquals(1, nuevaVelocidad);
    }

    @Test
    @DisplayName("Bajar velocidad")
    public void BajarVelocidad() {
        Model mo = new Model();
        Coche co = mo.crearCoche("Volkswagen", "1234ABK");
        mo.subirVelocidad("1234ABK"); // Subimos la velocidad a 1
        int nuevaVelocidad = mo.bajarVelocidad("1234ABK");
        assertEquals(0, nuevaVelocidad);
    }
    @Test
    @DisplayName("Coche inexistente")
    public void cocheInexistente() {
        Model mo = new Model();
        Coche co = mo.crearCoche("Volkswagen", "1234ABJ");
        int nuevaVelocidad = mo.bajarVelocidad("1234ABK");
        assertEquals(-1, nuevaVelocidad);
    }
}