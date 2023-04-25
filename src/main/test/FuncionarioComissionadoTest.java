import funcionarios.FuncionarioComissionado;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FuncionarioComissionadoTest {
    protected FuncionarioComissionado renata;

    @Before
    public void inicializar() {
        renata = new FuncionarioComissionado("Renata", "19276", 55, 40000, 0.00);
    }
    @Test
    public void InstanciaFuncionario_ValidaCalculoRendimento() {
        assertEquals(22000 ,renata.getRendimentos(), 0.1) ;
    }

}
