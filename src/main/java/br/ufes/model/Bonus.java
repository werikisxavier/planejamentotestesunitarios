package br.ufes.model;

import java.util.Objects;

public class Bonus {

    private final String tipo;
    private final double valor;

    public Bonus(String tipo, double valor) {
        this.tipo = tipo;
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "Bonus: Tipo:" + this.tipo + ", valor:" + valor;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Bonus other = (Bonus) obj;
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        return true;
    }

    
}
