// Lista Duplamente encadeada

public class ListaAgendamentos {
    private No primeiro;
    private No ultimo;
    private No atual;
    private int tamanho;

    public ListaAgendamentos() {
        this.primeiro = null;
        this.ultimo = null;
        this.atual = null;
        this.tamanho = 0;
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }


    // Insere um agendamento no final da lista

    public void inserirNoFim(Agendamento agendamento) {
        No novoNo = new No(agendamento);
        if (estaVazia()) {
            primeiro = novoNo;
            ultimo = novoNo;
            atual = novoNo;
        } else {
            ultimo.proximo = novoNo;
            novoNo.anterior = ultimo;
            ultimo = novoNo;
        }
        tamanho++;
    }


    //Remove um agendamento da lista pelo seu ID.

    public Agendamento removerPorId(int id) {
        if (estaVazia()) {
            return null;
        }

        No noAtual = primeiro;
        while (noAtual != null && noAtual.dado.getId() != id) {
            noAtual = noAtual.proximo;
        }

        if (noAtual == null) {
            return null; // Não encontrou
        }

        // Ajusta o ponteiro de navegação 'atual' se o nó removido for o atual

        if (noAtual == atual) {
            if (tamanho == 1) {
                atual = null;
            } else {
                // Tenta ir para o próximo ou, se for o último, para o anterior
                atual = noAtual.proximo != null ? noAtual.proximo : noAtual.anterior;
                if (atual == null && primeiro != null) {
                    atual = primeiro; // Garante que 'atual' aponte para um nó existente se a lista não estiver vazia
                }
            }
        }

        // Remove o nó (ajuste dos ponteiros anterior e próximo)

        if (noAtual == primeiro) {
            primeiro = noAtual.proximo;
            if (primeiro != null) {
                primeiro.anterior = null;
            } else {
                ultimo = null; // Lista ficou vazia
            }
        } else if (noAtual == ultimo) {
            ultimo = noAtual.anterior;
            if (ultimo != null) {
                ultimo.proximo = null;
            }
        } else {
            noAtual.anterior.proximo = noAtual.proximo;
            noAtual.proximo.anterior = noAtual.anterior;
        }

        tamanho--;
        return noAtual.dado;
    }


    // Navega para o próximo agendamento

    public Agendamento proximo() {
        if (estaVazia()) {
            return null;
        }
        // Se 'atual' ainda não foi inicializado ou foi resetado, começa do 'primeiro'.
        if (atual == null && primeiro != null) {
            atual = primeiro;
        } else if (atual != null && atual.proximo != null) {
            atual = atual.proximo;
        } else {
            // Se já está no último, permanece no último (ou null se vazia)
            return atual != null ? atual.dado : null;
        }
        return atual.dado;
    }

    // Navega para o agendamento anterior (Funcionalidade 7.2 - Navegação Reversa).

    public Agendamento anterior() {
        if (estaVazia()) {
            return null;
        }
        // Se 'atual' ainda não foi inicializado, começa do 'ultimo' para retroceder
        if (atual == null && ultimo != null) {
            atual = ultimo;
        } else if (atual != null && atual.anterior != null) {
            atual = atual.anterior;
        } else {
            // Se já está no primeiro, permanece no primeiro (ou null se vazia)
            return atual != null ? atual.dado : null;
        }
        return atual.dado;
    }

    //Retorna o agendamento atual

    public Agendamento getAtual() {
        if (atual != null){
            return atual.dado;
        }
        else {
            return null;
        }
    }


    // Retorna o primeiro agendamento da lista.

    public Agendamento getPrimeiro() {
        // Define o 'atual' para o primeiro, permitindo que a navegação comece.
        this.atual = primeiro;
        return primeiro != null ? primeiro.dado : null;
    }

    // Lista todos os agendamentos

    public void listar(String status) {
        if (estaVazia()) {
            System.out.println("-> A lista de agendamentos está vazia.");
            return;
        }

        System.out.println("--- Lista de Agendamentos (Ordem Temporal) ---");
        No noAtual = primeiro;
        int count = 0;

        while (noAtual != null) {
            if (status == null || noAtual.dado.getStatus().equalsIgnoreCase(status)) {
                System.out.println(noAtual.dado);
                count++;
            }
            noAtual = noAtual.proximo;
        }

        if (status != null && count == 0) {
            System.out.println(" Nenhum agendamento encontrado com o status: " + status);
        } else if (status != null) {
            System.out.println(" Total de agendamentos com status '" + status + "': " + count);
        } else {
            System.out.println(" Total de agendamentos na lista: " + tamanho);
        }
    }
}
