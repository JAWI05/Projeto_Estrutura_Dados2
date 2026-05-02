import java.util.ArrayList;
import java.util.List;

// abstract - Não pode ser instanciada, é o modelo das classes motorista e passageiro

public abstract class Pessoa {
    private int id; // ID único
    private String nome;
    private String tipo; // Passageiro ou Motorista
    private List<Agendamento> agendamentosAtribuidos; // Lista

    public Pessoa(int id, String nome, String tipo) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        // ArrayList - lista de agendamentos
        this.agendamentosAtribuidos = new ArrayList<>();
    }

    // Getters
    public int getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public String getTipo() {
        return tipo;
    }
    // cria a lista de agendamentos, muda a cada atualização
    public List<Agendamento> getAgendamentosAtribuidos() {
        return agendamentosAtribuidos;
    }

    // Adicionar agendamentos
    public void adicionarAgendamento(Agendamento agendamento) {
        if (agendamento != null) {
            this.agendamentosAtribuidos.add(agendamento);
        }
    }

    //Remove um agendamento da lista da pessoa.
    public void removerAgendamento(int idAgendamento) {
        this.agendamentosAtribuidos.removeIf(agend -> agend.getId() == idAgendamento);
    }

    // qualquer classe que herdar da classe abstrata deve fornecer uma implementação para este método
    // Método para obter atributos únicos das classes passageiro e motorista (Departamento e Veículo)
    public abstract String getDetalhesEspecificos();

    @Override
    public String toString() {
        return (
                "ID: "+id+"\n " +
                        "| Nome: "+nome+"\n " +
                        "| Tipo: "+tipo+"\n | "+ getDetalhesEspecificos()
        );
    }
}