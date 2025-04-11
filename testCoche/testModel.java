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
}