package p2;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;
@RunWith(value = Parameterized.class)
public class p2Test {
    private int notaFinal;
    private String expectedResult;

    public p2Test(int notaFinal, String expectedResult) {
        this.notaFinal = notaFinal;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Iterable<Object[]> getData() {
        List<Object[]> objects = new ArrayList<>();

        objects.add(new Object[]{101,"VALOR INCORRECTO"});
        objects.add(new Object[]{0,"REGULAR"});
        objects.add(new Object[]{1,"REGULAR"});
        objects.add(new Object[]{35,"REGULAR"});
        objects.add(new Object[]{69,"REGULAR"});
        objects.add(new Object[]{71,"BUENO"});
        objects.add(new Object[]{80,"BUENO"});
        objects.add(new Object[]{81,"MUY BUENO"});
        objects.add(new Object[]{85,"MUY BUENO"});
        objects.add(new Object[]{90,"MUY BUENO"});
        objects.add(new Object[]{91,"EXCELENTE"});
        objects.add(new Object[]{97,"EXCELENTE"});
        objects.add(new Object[]{100,"EXCELENTE"});
        objects.add(new Object[]{300,"VALOR INCORRECTO"});




        return objects;


    }

    @Test
    public void verify_notas(){
        Ej2Notas ej2 = new Ej2Notas();
        String actualResult = ej2.notasCualitativas(this.notaFinal);
        Assert.assertEquals("ERROR!", this.expectedResult,actualResult);
    }

}
