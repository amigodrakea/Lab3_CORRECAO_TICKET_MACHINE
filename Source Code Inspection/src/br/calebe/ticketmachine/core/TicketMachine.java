package core;

import exception.PapelMoedaInvalidaException;
import exception.SaldoInsuficienteException;
import java.util.Iterator;

/**
 *
 * @author Calebe de Paula Bianchini
 */
public class TicketMachine {

    protected int valor;
    protected int saldo;
    protected int[] papelMoeda = {2, 5, 10, 20, 50, 100};

    public TicketMachine(int valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor do bilhete deve ser positivo.");
        }
        this.valor = valor;
        this.saldo = 0;
    }

    public void inserir(int quantia) throws PapelMoedaInvalidaException {
        boolean achou = false;
        for (int i = 0; i < papelMoeda.length && !achou; i++) {
            // Ajuste das cédulas, que antes estava papelMoeda[1] e foi para papelMoeda[i], para verificar os restantes das cédulas
            if (papelMoeda[i] == quantia) {
                achou = true;
            }
        }
        if (!achou) {
            throw new PapelMoedaInvalidaException("Cédula inválida: " + quantia);
        }
        this.saldo += quantia;
    }

    public int getSaldo() {
        return saldo;
    }

     // Método para calcular e devolver o troco
    public Iterator<Integer> getTroco() {
        if (saldo == 0) {
            return null;  // Nenhum troco disponível
        }

        Troco troco = new Troco(saldo);  // Calcula o troco com base no saldo
        saldo = 0;  // Zera o saldo após calcular o troco
        return troco.getCédulas();  // Devolve o troco
    }

    public int getValorBilhete() {
        return valor;
    }

    public String imprimir() throws SaldoInsuficienteException {
        if (saldo < valor) {
            throw new SaldoInsuficienteException();
        }
        String result = "*****************\n";
        result += "*** R$ " + valor + ",00 ****\n";
        result += "*****************\n";
        saldo -= valor;
        return result;
    }
}
