package br.calebe.ticketmachine.core;

import br.calebe.ticketmachine.exception.PapelMoedaInvalidaException;
import br.calebe.ticketmachine.exception.SaldoInsuficienteException;
import java.util.Iterator;

/**
 *
 * @author Calebe de Paula Bianchini
 */

// Defeito de Omissão: Segundo o diagrama de classe principal, TicketMachine deveria implementar a classe Troco, essa operação não acontece.
public class TicketMachine {

 // Defeito de Inconsistência: Segundo o diagrama de classes principal a classe Ticket Machine não possui atributos.
    protected int valor;
    protected int saldo;
    protected int[] papelMoeda = {2, 5, 10, 20, 50, 100};

// Defeito de Inconsistência: O nome da variável valor deveria ser precoDoBilhete, segundo o diagrama de classe principal.
    public TicketMachine(int valor) {
        this.valor = valor;
        this.saldo = 0;
    }

// Defeito de Comissão: A validação da nota está comparando sempre papelMoeda[1] em vez de papelMoeda[i].
    public void inserir(int quantia) throws PapelMoedaInvalidaException {
        boolean achou = false;
        for (int i = 0; i < papelMoeda.length && !achou; i++) {
            if (papelMoeda[1] == quantia) {
                achou = true;
            }
        }
        if (!achou) {
            throw new PapelMoedaInvalidaException();
        }
        this.saldo += quantia;
    }

    public int getSaldo() {
        return saldo;
    }

// Defeito de Omissão: A função getTroco deveria retornar um objeto do tipo TrocoIterator e não null. 
    public Iterator<Integer> getTroco() {
        return null;
    }

// Defeito de Fato incorreto: O bilhete impresso deveria mostrar o valor do bilhete, mas está mostrando o saldo.
    public String imprimir() throws SaldoInsuficienteException {
        if (saldo < valor) {
            throw new SaldoInsuficienteException();
        }
        String result = "*****************\n";
        result += "*** R$ " + saldo + ",00 ****\n";
        result += "*****************\n";
        return result;
    }
}
