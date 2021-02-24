package p4;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

@RunWith(value= Parameterized.class)
public class CambioMonedaTest {
    private int cantidad;
    private int amount;
    private String monedaOriginal;
    private String monedaDestino;
    private String expectedResult;

    public CambioMonedaTest(int cantidad, int amount, String monedaOriginal, String monedaDestino, String expectedResult) {
        this.cantidad = cantidad;
      this.amount = amount;
      this.monedaOriginal = monedaOriginal;
      this.monedaDestino = monedaDestino;
        this.expectedResult = expectedResult;
    }



    @Parameterized.Parameters
    public static Iterable<Object[]> getData() {
        List<Object[]> objects= new ArrayList<>();
        objects.add(new Object[]{-11,"cantidad incorrecta"});

        return objects;


    }

    Util utilmock= Mockito.mock(Util.class);

    @Test
    public void verify_moneda(){
        Mockito.when(utilmock.obtenerTipoDeCambio("Dolares","Bolivianos")).thenReturn(this.cantidad);

        CambioMoneda cambioMoneda = new CambioMoneda(utilmock);
        String actualResult= cambioMoneda.saveInNewMoney(this.amount,this.monedaOriginal,this.monedaDestino);
        Assert.assertEquals("ERROR! ",this.expectedResult,actualResult);

    }

}
