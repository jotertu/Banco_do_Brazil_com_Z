package conta.controller;

import java.util.ArrayList;

import conta.model.Conta;
import conta.repository.ContaRepository;

public class ContaController implements ContaRepository {

    private ArrayList<Conta> listaContas = new ArrayList<>();
    private int numero = 0;

    @Override
    public void procurarPorNumero(int numero) {
        var conta = buscarContaPorNumero(numero);

        if (conta != null) {
            conta.visualizar();
        } else {
            System.out.println("\nA Conta número: " + numero + " não foi encontrada");
        }
    }

    @Override
    public void listarTodas() {
        for (var conta : listaContas) {
            conta.visualizar();
        }
    }

    @Override
    public void cadastrar(Conta conta) {
        listaContas.add(conta);
        System.out.println("\nA Conta número: " + conta.getNumero() + " foi criada com sucesso!");
    }

    @Override
    public void atualizar(Conta conta) {
        var buscaConta = buscarContaPorNumero(conta.getNumero());

        if (buscaConta != null) {
            listaContas.set(listaContas.indexOf(buscaConta), conta);
            System.out.println("\nA Conta número: " + conta.getNumero() + " foi atualizada com sucesso!");
        } else {
            System.out.println("\nA Conta número: " + conta.getNumero() + " não foi encontrada!");
        }
    }

    @Override
    public void deletar(int numero) {
        var conta = buscarContaPorNumero(numero);

        if (conta != null) {
            if (listaContas.remove(conta)) {
                System.out.println("A Conta número: " + numero + " foi deletada com sucesso!");
            }
        } else {
            System.out.println("A Conta número: " + numero + " não foi encontrada!");
        }
    }

    @Override
    public void sacar(int numero, float valor) {
        var conta = buscarContaPorNumero(numero);

        if (conta != null) {
            if (conta.sacar(valor)) {
                System.out.println("\nO Saque na Conta número " + numero + " foi efetuado com sucesso!");
            } else {
                System.out.println("\nSaldo insuficiente ou Conta número: " + numero + " não foi encontrada!");
            }
        }
    }

    @Override
    public void depositar(int numero, float valor) {
        var conta = buscarContaPorNumero(numero);

        if (conta != null) {
            conta.depositar(valor);
            System.out.println("\nO Depósito na Conta número " + numero + " foi efetuado com sucesso!");
        } else {
            System.out.println("\nA Conta número: " + numero + " não foi encontrada ou a Conta destino não é uma Conta Corrente!");
        }
    }

    @Override
    public void tranferir(int numeroOrigem, int numeroDestino, float valor) {
        var contaOrigem = buscarContaPorNumero(numeroOrigem);
        var contaDestino = buscarContaPorNumero(numeroDestino);

        if (contaOrigem != null && contaDestino != null) {
            if (contaOrigem.getSaldo() >= valor) {
                contaOrigem.sacar(valor);
                contaDestino.depositar(valor);
                System.out.println("A transferência foi efetuada com sucesso");
            } else {
                System.out.println("Saldo insuficiente na Conta de Origem: " + numeroOrigem);
            }
        } else {
            System.out.println("A Conta de Origem e/ou Destino não foram encontradas");
        }
    }

    public int gerarNumero() {
        return ++numero;
    }

    public Conta buscarContaPorNumero(int numero) {
        for (var conta : listaContas) {
            if (conta.getNumero() == numero) {
                return conta;
            }
        }
        return null;
    }

    public int retornaTipo(int numero) {
        for (var conta : listaContas) {
            if (conta.getNumero() == numero) {
                return conta.getTipo();
            }
        }
        return 0;
    }
}
