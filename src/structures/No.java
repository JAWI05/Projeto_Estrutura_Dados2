// nó da lista de agendamentos

public class No {
    public Agendamento dado;
    public No proximo;
    public No anterior;

    // Construtor
    public No(Agendamento dado) {
        this.dado = dado;
        this.proximo = null;
        this.anterior = null;
    }
}
