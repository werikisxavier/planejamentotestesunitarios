package br.ufes.calculodebonus;

import br.ufes.model.Bonus;
import br.ufes.model.Funcionario;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MetodoCalculoBonusCargo implements IMetodoCalculaBonus {

    @Override
    public void calcular(Funcionario funcionario) {
        String cargo = funcionario.getCargo();
        try {
            if (cargo.toUpperCase().contains("GERENTE")) {
                funcionario.addBonus(new Bonus("Cargo:" + cargo, 100));
            } else if (cargo.toUpperCase().contains("SUPERVISOR")) {
                funcionario.addBonus(new Bonus("Cargo:" + cargo, 80));
            } else if (cargo.toUpperCase().contains("PROGRAMADOR")) {
                funcionario.addBonus(new Bonus("Cargo:" + cargo, 50));
            }
        } catch (Exception ex) {
            Logger.getLogger(MetodoCalculoBonusCargo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
