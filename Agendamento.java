public class Agendamento {
    private int id; // id unico
    private String tipo; // carona, expresso, executivo
    private String origem;
    private String destino;
    private String horario; // Data/hora
    private String status; // marcado, em_execucao, finalizado
    private int prioridade; // 1-5 (1- menos 5 - mais [urgência])

    // Construtor de Agendamento
    public Agendamento(int id, String tipo, String origem, String destino, String horario, int prioridade, String status) {
        this.id = id;
        this.tipo = tipo;
        this.origem = origem;
        this.destino = destino;
        this.horario = horario;
        this.prioridade = prioridade;
        this.status = status;
    }

    // Getters
    public int getId() {
        return id;
    }
    public String getTipo() {
        return tipo;
    }
    public String getOrigem() {
        return origem;
    }
    public String getDestino() {
        return destino;
    }
    public String getHorario() {
        return horario;
    }
    public String getStatus() {
        return status;
    }
    public int getPrioridade() {
        return prioridade;
    }

    // Setter para o status (marcado, em_execucao, finalizado) do agendamento, o único que pode mudar
    public void setStatus(String status) {
        this.status = status;
    }

    // Imprime as informações
    @Override
    public String toString() {
        return(
                "| ID: "+ id + "\n " +
                        "| Tipo: "+ tipo + "\n " +
                        "| Prioridade: "+ prioridade +"\n " +
                        "| Status: " + status +"\n " +
                        "| Horário: "+ horario +"\n " +
                        "| Origem: "+ origem +" -> Destino: "+ destino
        );
    }
}