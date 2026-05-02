public class ArvorePrioridade {
    private NoArvore raiz; // nó raiz
    private int tamanho; // tamanho da arvore

    // Construtor
    public ArvorePrioridade() {
        this.raiz = null;
        this.tamanho = 0;
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }


    // Insere um novo agendamento na árvore.
    public void inserir(Agendamento agendamento) {
        if (agendamento == null) return;
        this.raiz = inserirRecursivo(this.raiz, agendamento);
        this.tamanho++;
    }

    private NoArvore inserirRecursivo(NoArvore noAtual, Agendamento agendamento) {
        if (noAtual == null) {
            return new NoArvore(agendamento);
        }

        // Compara as prioridades
        int comparacaoPrioridade = agendamento.getPrioridade() - noAtual.dado.getPrioridade();

        if (comparacaoPrioridade > 0) {
            // novo > Prioridade do nó atual
            // Novo mais urgente, vai para a direita
            noAtual.direita = inserirRecursivo(noAtual.direita, agendamento);
        } else if (comparacaoPrioridade < 0) {
            // novo < atual
            // Novo menos urgente, vai para a esquerda
            noAtual.esquerda = inserirRecursivo(noAtual.esquerda, agendamento);
        } else {
            // Empate de Prioridade
            // Desempate pelo ID
            if (agendamento.getId() < noAtual.dado.getId()) {
                noAtual.esquerda = inserirRecursivo(noAtual.esquerda, agendamento);
            } else {
                noAtual.direita = inserirRecursivo(noAtual.direita, agendamento);
            }
        }

        return noAtual;
    }


    // Remove um agendamento da árvore pelo seu ID.

    public Agendamento removerPorId(int id) {
        Agendamento[] agendamentoRemovido = {null};
        this.raiz = removerRecursivo(this.raiz, id, agendamentoRemovido);
        if (agendamentoRemovido[0] != null) {
            this.tamanho--;
        }
        return agendamentoRemovido[0];
    }

    private NoArvore removerRecursivo(NoArvore noAtual, int id, Agendamento[] agendamentoRemovido) {
        if (noAtual == null) {
            return null;
        }

        // Se encontrou o ID, executa a remoção da BST
        if (noAtual.dado.getId() == id) {
            agendamentoRemovido[0] = noAtual.dado;

            // Nó sem filhos ou com apenas um filho
            if (noAtual.esquerda == null) {
                return noAtual.direita;
            }
            if (noAtual.direita == null) {
                return noAtual.esquerda;
            }

            // Nó com dois filhos
            // Encontra o sucessor in-order (o menor valor na subárvore direita)
            Agendamento sucessor = encontrarMenorValor(noAtual.direita).dado;
            // Copia o valor do sucessor para o nó atual
            noAtual.dado = sucessor;
            // Remove o sucessor da subárvore direita (agora o nó original)
            noAtual.direita = removerRecursivo(noAtual.direita, sucessor.getId(), new Agendamento[1]);
            return noAtual;
        }

        // Busca em ambos os lados
        // BST é ordenada por Prioridade e não só por ID
        noAtual.esquerda = removerRecursivo(noAtual.esquerda, id, agendamentoRemovido);
        if (agendamentoRemovido[0] != null) {
            return noAtual; // Se já encontrou, retorna para parar a recursão
        }

        noAtual.direita = removerRecursivo(noAtual.direita, id, agendamentoRemovido);

        return noAtual;
    }


    //  encontrar o nó com o menor valor

    private NoArvore encontrarMenorValor(NoArvore raiz) {
        return raiz.esquerda == null ? raiz : encontrarMenorValor(raiz.esquerda);
    }


    // Lista os agendamentos em ordem

    public void listarPorPrioridade() {
        if (estaVazia()) {
            System.out.println("-> A árvore de prioridades está vazia.");
            return;
        }
        System.out.println("--- Agendamentos por Prioridade (5 - Urgente -> 1 - Baixa) ---");
        listarInOrder(this.raiz);
        System.out.println("-------------------------------------------------");
    }

    // listar do mais urgente ao menos urgente.
    private void listarInOrder(NoArvore noAtual) {
        if (noAtual != null) {
            // subárvore DIREITA (Prioridades mais altas)
            listarInOrder(noAtual.direita);

            // Visita a RAIZ (Prioridade atual)
            System.out.println(String.format("[Prio %d] ", noAtual.dado.getPrioridade()) + noAtual.dado);

            // Visita a subárvore ESQUERDA (Prioridades mais baixas)
            listarInOrder(noAtual.esquerda);
        }
    }


    // Encontra um Agendamento pelo ID.

    public Agendamento buscarAgendamentoPorId(int id) {
        return buscarAgendamentoRecursivo(this.raiz, id);
    }

    private Agendamento buscarAgendamentoRecursivo(NoArvore noAtual, int id) {
        if (noAtual == null) {
            return null;
        }

        if (noAtual.dado.getId() == id) {
            return noAtual.dado;
        }

        // Busca em ambos os lados para garantir a localização
        Agendamento encontrado = buscarAgendamentoRecursivo(noAtual.esquerda, id);
        if (encontrado != null) {
            return encontrado;
        }

        return buscarAgendamentoRecursivo(noAtual.direita, id);
    }
}