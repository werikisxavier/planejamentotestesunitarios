package br.ufes.model;

import java.util.ArrayList;

public final class Funcionario {

    private String nome;
    private double salarioBase;
    private double salarioTotal;
    private int distanciaMoradia;
    private int faltas;
    private String cargo;
    private final ArrayList<Bonus> bonusRecebidos;

    public Funcionario(String nome, double salarioBase, String cargo) throws Exception {
        this.setNome(nome);
        this.setCargo(cargo);
        this.setSalarioBase(salarioBase);
        this.bonusRecebidos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws Exception {
        if (nome == null || nome == "" || nome.matches("[0-9]*"))
            throw new Exception("\n#1 Informe um nome válido");
        
        this.nome = nome;
    }

    public double getSalarioBase() {
        return this.salarioBase;
    }

    public void setSalarioBase(double salarioBase) throws Exception {
         if (salarioBase < 998.0)
            throw new Exception("\n#3 O salário base deve ser >= R$ 998,00");
        this.salarioBase = salarioBase;
    }

    public int getFaltas() {
        return faltas;
    }

    public void setFaltas(int faltas) throws Exception {
        if (faltas < 0  ){
            throw new Exception("#4 A quantidade de faltas deve ser >= 0");
        }
        
        this.faltas = faltas;
    }

    public int getDistanciaMoradia() {
        return distanciaMoradia;
    }

    public void setDistanciaMoradia(int distanciaMoradia) throws Exception {
        if (distanciaMoradia < 0  ){
            throw new Exception("#5 A distancia deve ser >= 0");
        }
        
        this.distanciaMoradia = distanciaMoradia;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) throws Exception {
        if (cargo == null || cargo.equals(""))
            throw new Exception("\n#2 Informe um cargo válido");
        this.cargo = cargo;
    }

    public double getSalario() {
        return this.calculaSalario();
    }

    private double calculaSalario() {
        this.salarioTotal = this.salarioBase + this.calculaTotalBonus();
        return this.salarioTotal;
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

    @Override
    public String toString() {
        String strBonusRecebidos = "";
        for (Bonus bonusRecebido : bonusRecebidos) {
            strBonusRecebidos += "\n\t" + bonusRecebido;
        }
        String strFuncionario = "Funcionario {"
                + "nome: " + this.nome + ", "
                + "salarioBase: " + this.salarioBase + ", "
                + "totalBonus: " + this.calculaTotalBonus() + ", "
                + "salarioTotal: " + this.getSalario()
                + '}';

        if (bonusRecebidos.size() > 0) {
            strFuncionario += "\nBonus recebidos: " + strBonusRecebidos;
        }

        return strFuncionario;
    }
}
