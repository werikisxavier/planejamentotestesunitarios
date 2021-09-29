package br.ufes.calculodebonus;

import br.ufes.exceptions.AppException;
import br.ufes.model.Funcionario;

interface IMetodoCalculaBonus {

    public void calcular(Funcionario funcionario) throws AppException;
}
