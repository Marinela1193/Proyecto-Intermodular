import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PF02Tests {
    //anotarlo como metodo de test
    @Test
    public void testCalcularNotaAprobado() {
        CalcularNota calcularNota = new CalcularNota();

        //comprobaciones que si no son correctas hacen fallar el test
        Assertions.assertEquals(1, calcularNota.calcularNota(6));
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3,4})
    public void testCalcularNotaSuspenso(int nota) {
        CalcularNota calcularNota = new CalcularNota();

        //comprobaciones que si no son correctas hacen fallar el test
        Assertions.assertEquals(-1, calcularNota.calcularNota(nota));
    }

    @Test
    public void testCalcularNotaError() {
        CalcularNota calcularNota = new CalcularNota();

        try{
            int nota = CalcularNota.calcularNota(-5);
        }catch (IllegalArgumentException e) {
            //nos aseguramos que el valor que devuelve es el mismo que se ha indicado en el main
            Assertions.assertEquals("Valor no válido", e.getMessage());
            return;
        }
        Assertions.fail();
        //comprobaciones que si no son correctas hacen fallar el test
        //Assertions.assertEquals(0, calcularNota.calcularNota(-5));
    }
}
