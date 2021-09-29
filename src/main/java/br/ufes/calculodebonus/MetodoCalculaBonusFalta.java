package br.ufes.calculodebonus;

import br.ufes.exceptions.AppException;
import br.ufes.model.Bonus;
import br.ufes.model.Funcionario;

class MetodoCalculaBonusFalta implements IMetodoCalculaBonus {

    @Override
    public void calcular(Funcionario funcionario) throws AppException {
        int faltas = funcionario.getFaltas();
        String bonus = "Falta";
        double salario = funcionario.getSalarioBase();

        if (faltas == 0) {
            funcionario.addBonus(new Bonus(bonus, salario * 0.05));
        } else if (faltas < 5) {
            funcionario.addBonus(new Bonus(bonus, salario * 0.02));
        } else if (faltas < 10) {
            funcionario.addBonus(new Bonus(bonus, salario * 0.01));
        }
    }

}
