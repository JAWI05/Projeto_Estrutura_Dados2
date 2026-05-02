// nó da arvore de prioridade

public class NoArvore {
    public Agendamento dado;
    public NoArvore esquerda;
    public NoArvore direita;

    // Construtor
    public NoArvore(Agendamento dado) {
        this.dado = dado;
        this.esquerda = null;
        this.direita = null;
    }
}