package core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Troco {

    private List<Integer> cédulas;

    // Construtor que calcula o troco com base no saldo e nas cédulas disponíveis
    public Troco(int saldo) {
        cédulas = new ArrayList<>();
        int[] papelMoeda = {100, 50, 20, 10, 5, 2};  // Cédulas disponíveis para o troco

        // Calcula o troco dividindo o saldo pelas cédulas, do maior valor para o menor
        for (int i = 0; i < papelMoeda.length; i++) {
            while (saldo >= papelMoeda[i]) {
                saldo -= papelMoeda[i];  // Subtrai o valor da cédula do saldo
                cédulas.add(papelMoeda[i]);  // Adiciona a cédula à lista de troco
            }
        }
    }

    // Retorna o troco como um iterator de cédulas
    public Iterator<Integer> getCédulas() {
        return cédulas.iterator();
    }
}