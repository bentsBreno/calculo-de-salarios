import funcionarios.FuncionarioHorista;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FuncionarioHoristaTest {
    protected FuncionarioHorista joao;

    @Before
    public void inicializar() {
        joao = new FuncionarioHorista("Joao", "90611383020",
                30, 0, 30, 3);
    }
    @Test
    public void InstanciaFuncionario_ValidaCalculoRendimento() {
        assertEquals(90 ,
                joao.getRendimentos(),
                0.1) ;
    }
}