import funcionarios.FuncionarioAssalariado;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FuncionarioAssalariadoTest {

    protected FuncionarioAssalariado paulo;
    protected FuncionarioAssalariado cpfErrado;

    @Before
    public void inicializar() {
        paulo = new FuncionarioAssalariado("Paulo", "90611383020", 3000.00);
    }
    @Test
    public void InstanciaFuncionario_ValidaCalculoRendimento() {
        assertEquals(3000 ,paulo.getRendimentos(), 0.1) ;
    }

    @Test
    public void InstanciaFuncionario_CpfErrado_Exception() {
        assertEquals(3000 ,paulo.getRendimentos(), 0.1) ;

        try {
            cpfErrado = new FuncionarioAssalariado("Breno", "906", 3000.00);
            Assert.fail();
        } catch (IllegalArgumentException ex){
            Assert.assertEquals(ex.getMessage(), "Cpf inválido.");
        }
    }
}