import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


public class AppTest {
    //añadimos los valores de la nota que van a hacer que el tes devuelva 1
    //que es = a un aprobado.
    @ParameterizedTest
    @ValueSource(ints = {5,6,7,8,9,10})
    public void testCalcularAprobado(int nota) {
        App main = new App();
        int resultado = main.calcularNota(nota);
        Assertions.assertEquals(1, resultado);
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3,4})
    public void testCalcularSuspenso(int nota) {
        App main = new App();
        int resultado = main.calcularNota(nota);
        Assertions.assertEquals(-1, resultado);
    }

    @ParameterizedTest
    @ValueSource(ints = {11,12,-1,-5,20,60,100})
    public void testCalcularError(int nota) {
        App main = new App();
        try {
            int resultado = main.calcularNota(nota);
        }
        //hemos declarado ERROR_NOTA como constante en el main para asegurarnos
        //que puede acceder y no hay errores de escritura que dan lugar a errores
        //de código
        catch (IllegalArgumentException e) {
            Assertions.assertEquals(App.ERROR_NOTA, e.getMessage());
            return;
        }
        Assertions.fail();
    }
}