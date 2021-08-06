package br.ufes.projetos01;

import br.ufes.calculodebonus.ProcessadoraBonus;
import br.ufes.model.Funcionario;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

/**
 *
 * @author werikis Link:
 * https://docs.google.com/spreadsheets/d/10R77ZgvXol4xJhQvw8Se-iONq_wzOnmuYTU6hBl7BDM/edit?usp=sharing
 */
public class FuncionarioBonusTest {

    public FuncionarioBonusTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {
    }

    @Rule
    public ExpectedException excecaoEsperada = ExpectedException.none();

    @Test
    public void CT001() throws Exception {
        //Arrange
        Funcionario funcionario = new Funcionario("Fulano", 2500.00, "Gerente");
        double salarioEsperado = 2500.00;

        //Assert
        assertEquals(salarioEsperado, funcionario.getSalario(), 0.001);
    }

    @Test
    public void CT002() throws Exception {
        //Arrange
        excecaoEsperada.expect(Exception.class);
        excecaoEsperada.expectMessage("#1 Informe um nome válido");

        //Act 
        Funcionario funcionario = new Funcionario("", 2500.00, "Gerente");

    }

    @Test
    public void CT003() throws Exception {
        //Arrange
        excecaoEsperada.expect(Exception.class);
        excecaoEsperada.expectMessage("#1 Informe um nome válido");

        //Act 
        Funcionario funcionario = new Funcionario("1111", 2500.00, "Gerente");
    }

    @Test
    public void CT004() throws Exception {
        //Arrange 
        excecaoEsperada.expect(Exception.class);
        excecaoEsperada.expectMessage("#1 Informe um nome válido");

        //Act 
        Funcionario funcionario = new Funcionario(null, 2500.00, "Gerente");

    }

    @Test
    public void CT005() throws Exception {
        //Arrange
        excecaoEsperada.expect(Exception.class);
        excecaoEsperada.expectMessage("#3 O salário base deve ser >= R$ 998,00");

        //Act 
        Funcionario funcionario = new Funcionario("Fulano", 900.00, "Gerente");
    }

    @Test
    public void CT006() throws Exception {
        //Arrange
        Funcionario funcionario = new Funcionario("Fulano", 998.00, "Gerente");
        double salarioEsperado = 998.00;

        //Assert
        assertEquals(salarioEsperado, funcionario.getSalario(), 0.001);
    }

    @Test
    public void CT007() throws Exception {
        //Arrange
        excecaoEsperada.expect(Exception.class);
        excecaoEsperada.expectMessage("#2 Informe um cargo válido");

        //Act 
        Funcionario funcionario = new Funcionario("Fulano", 2500.00, "Boi");
    }

    @Test
    public void CT008() throws Exception {
        //Arrange
        excecaoEsperada.expect(Exception.class);
        excecaoEsperada.expectMessage("#2 Informe um cargo válido");

        //Act 
        Funcionario funcionario = new Funcionario("Fulano", 2500.00, "");
    }

    @Test
    public void CT009() throws Exception {
        //Arrange
        excecaoEsperada.expect(Exception.class);
        excecaoEsperada.expectMessage("#2 Informe um cargo válido");

        //Act 
        Funcionario funcionario = new Funcionario("Fulano", 2500.00, null);
    }

    @Test
    public void CT010() throws Exception {
        //Arrange
        Funcionario funcionario = new Funcionario("Fulano", 2500.00, "Gerente");
        funcionario.setFaltas(1);
        double salarioEsperado = 2500.00;

        //Assert
        assertEquals(salarioEsperado, funcionario.getSalario(), 0.001);
    }

    @Test
    public void CT011() throws Exception {
        //Arrange
        excecaoEsperada.expect(Exception.class);
        excecaoEsperada.expectMessage("#4 A quantidade de faltas deve ser >= 0");
        Funcionario funcionario = new Funcionario("Fulano", 2500.00, "Gerente");
        funcionario.setFaltas(-1);
        double salarioEsperado = 2500.00;

        //Assert
        assertEquals(salarioEsperado, funcionario.getSalario(), 0.001);
    }

    @Test
    public void CT012() throws Exception {
        //Arrange
        Funcionario funcionario = new Funcionario("Fulano", 2500.00, "Gerente");
        funcionario.setDistanciaMoradia(1);
        double salarioEsperado = 2500.00;

        //Assert
        assertEquals(salarioEsperado, funcionario.getSalario(), 0.001);
    }

    @Test
    public void CT013() throws Exception {
        //Arrange
        excecaoEsperada.expect(Exception.class);
        excecaoEsperada.expectMessage("#5 A distancia deve ser >= 0");
        Funcionario funcionario = new Funcionario("Fulano", 2500.00, "Gerente");
        funcionario.setDistanciaMoradia(-1);
        double salarioEsperado = 2500.00;

        //Assert
        assertEquals(salarioEsperado, funcionario.getSalario(), 0.001);
    }

    @Test
    public void CT014() throws Exception {
        //Arrange
        Funcionario funcionario = new Funcionario("Fulano", 2500.00, "Supervisor");
        funcionario.setFaltas(10);
        ProcessadoraBonus pb = new ProcessadoraBonus();
        double salarioEsperado = 2580.00;

        //Act        
        pb.processar(funcionario);

        //Assert
        assertEquals(salarioEsperado, funcionario.getSalario(), 0.001);
    }

    @Test
    public void CT015() throws Exception {
        //Arrange
        Funcionario funcionario = new Funcionario("Fulano", 2500.00, "Programador");
        funcionario.setFaltas(10);
        ProcessadoraBonus pb = new ProcessadoraBonus();
        double salarioEsperado = 2550.00;

        //Act        
        pb.processar(funcionario);

        //Assert
        assertEquals(salarioEsperado, funcionario.getSalario(), 0.001);
    }

    @Test
    public void CT016() throws Exception {
        //Arrange
        Funcionario funcionario = new Funcionario("Fulano", 2500.00, "Gerente");
        funcionario.setFaltas(0);
        ProcessadoraBonus pb = new ProcessadoraBonus();
        double salarioEsperado = 2725.00;

        //Act        
        pb.processar(funcionario);

        //Assert
        assertEquals(salarioEsperado, funcionario.getSalario(), 0.001);
    }

    @Test
    public void CT017() throws Exception {
        //Arrange
        Funcionario funcionario = new Funcionario("Fulano", 2500.00, "Gerente");
        funcionario.setFaltas(4);
        ProcessadoraBonus pb = new ProcessadoraBonus();
        double salarioEsperado = 2650.00;

        //Act        
        pb.processar(funcionario);

        //Assert
        assertEquals(salarioEsperado, funcionario.getSalario(), 0.001);
    }

    @Test
    public void CT018() throws Exception {
        //Arrange
        Funcionario funcionario = new Funcionario("Fulano", 2500.00, "Gerente");
        funcionario.setFaltas(6);
        ProcessadoraBonus pb = new ProcessadoraBonus();
        double salarioEsperado = 2625.00;

        //Act        
        pb.processar(funcionario);

        //Assert
        assertEquals(salarioEsperado, funcionario.getSalario(), 0.001);
    }

    @Test
    public void CT019() throws Exception {
        //Arrange
        Funcionario funcionario = new Funcionario("Fulano", 2500.00, "Gerente");
        funcionario.setFaltas(12);
        ProcessadoraBonus pb = new ProcessadoraBonus();
        double salarioEsperado = 2600.00;

        //Act        
        pb.processar(funcionario);

        //Assert
        assertEquals(salarioEsperado, funcionario.getSalario(), 0.001);
    }

    @Test
    public void CT020() throws Exception {
        //Arrange
        Funcionario funcionario = new Funcionario("Fulano", 2500.00, "Gerente");
        funcionario.setFaltas(12);
        funcionario.setDistanciaMoradia(30);
        ProcessadoraBonus pb = new ProcessadoraBonus();
        double salarioEsperado = 2600.00;

        //Act        
        pb.processar(funcionario);

        //Assert
        assertEquals(salarioEsperado, funcionario.getSalario(), 0.001);
    }

    @Test
    public void CT021() throws Exception {
        //Arrange
        Funcionario funcionario = new Funcionario("Fulano", 2500.00, "Gerente");
        funcionario.setFaltas(12);
        funcionario.setDistanciaMoradia(60);
        ProcessadoraBonus pb = new ProcessadoraBonus();
        double salarioEsperado = 2750.00;

        //Act        
        pb.processar(funcionario);

        //Assert
        assertEquals(salarioEsperado, funcionario.getSalario(), 0.001);
    }

    @Test
    public void CT022() throws Exception {
        //Arrange
        Funcionario funcionario = new Funcionario("Fulano", 2500.00, "Gerente");
        funcionario.setFaltas(12);
        funcionario.setDistanciaMoradia(120);
        ProcessadoraBonus pb = new ProcessadoraBonus();
        double salarioEsperado = 2900.00;

        //Act        
        pb.processar(funcionario);

        //Assert
        assertEquals(salarioEsperado, funcionario.getSalario(), 0.001);
    }

    @Test
    public void CT023() throws Exception {
        //Arrange
        Funcionario funcionario = new Funcionario("Fulano", 2500.00, "Gerente");
        funcionario.setFaltas(12);
        funcionario.setDistanciaMoradia(180);
        ProcessadoraBonus pb = new ProcessadoraBonus();
        double salarioEsperado = 3100.00;

        //Act        
        pb.processar(funcionario);

        //Assert
        assertEquals(salarioEsperado, funcionario.getSalario(), 0.001);
    }

}
