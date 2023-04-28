import funcionarios.FuncionarioComissionadoBaseSalario;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FuncionarioComissionadoBaseSalarioTest {
    protected FuncionarioComissionadoBaseSalario sara;

    @Before
    public void inicializar() {
        sara = new FuncionarioComissionadoBaseSalario("Sara",
                "90611383020",
                40,
                10000,
                3000.00);
    }
    @Test
    public void InstanciaFuncionario_ValidaCalculoRendimento() {
        assertEquals(7000 ,sara.getRendimentos(), 0.1) ;
    }
}
