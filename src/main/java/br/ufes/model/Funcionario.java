package br.ufes.model;

import br.ufes.exceptions.AppException;
import java.util.ArrayList;

public final class Funcionario {

    private String nome;
    private double salarioBase;
    private int distanciaMoradia;
    private int faltas;
    private String cargo;
    private final ArrayList<Bonus> bonusRecebidos;

    public Funcionario(String nome, double salarioBase, String cargo) throws AppException {
        this.setNome(nome);
        this.setCargo(cargo);
        this.setSalarioBase(salarioBase);
        this.bonusRecebidos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws AppException {
        if (nome == null || nome.isEmpty() || nome.matches("[0-9]*"))
            throw new AppException("\n#1 Informe um nome válido");
        
        this.nome = nome;
    }

    public double getSalarioBase() {
        return this.salarioBase;
    }

    public void setSalarioBase(double salarioBase) throws AppException {
         if (salarioBase < 998.0)
            throw new AppException("\n#3 O salário base deve ser >= R$ 998,00");
        this.salarioBase = salarioBase;
    }

    public int getFaltas() {
        return faltas;
    }

    public void setFaltas(int faltas) throws AppException {
        if (faltas < 0  ){
            throw new AppException("#4 A quantidade de faltas deve ser >= 0");
        }
        
        this.faltas = faltas;
    }

    public int getDistanciaMoradia() {
        return distanciaMoradia;
    }

    public void setDistanciaMoradia(int distanciaMoradia) throws AppException {
        if (distanciaMoradia < 0  ){
            throw new AppException("#5 A distancia deve ser >= 0");
        }
        
        this.distanciaMoradia = distanciaMoradia;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) throws AppException {
        if (cargo == null || cargo.equals(""))
            throw new AppException("\n#2 Informe um cargo válido");
        this.cargo = cargo;
    }

    public double getSalario() {
        return this.calculaSalario();
    }

    private double calculaSalario() {
        return this.salarioBase + this.calculaTotalBonus();
    }

    public void addBonus(Bonus bonus) {
        if(this.bonusRecebidos.contains(bonus)) {
            this.bonusRecebidos.remove(bonus);
        }
        
        this.bonusRecebidos.add(bonus);
    }

    public double calculaTotalBonus() {
        double totalBonus = 0;
        for (Bonus bonus : bonusRecebidos) {
            totalBonus += bonus.getValor();
        }

        return totalBonus;
    }
 
   
}
