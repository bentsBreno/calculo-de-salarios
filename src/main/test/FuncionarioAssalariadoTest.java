import funcionarios.FuncionarioAssalariado;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FuncionarioAssalariadoTest {

    protected FuncionarioAssalariado paulo;

    @Before
    public void inicializar() {
        paulo = new FuncionarioAssalariado("Paulo", "67890", 3000);
    }
    @Test
    public void InstanciaFuncionario_ValidaCalculoRendimento() {
        assertEquals(3000 ,paulo.getRendimentos(), 0.1) ;
    }
}