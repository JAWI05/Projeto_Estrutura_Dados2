// Classe filha da classe base pessoa

public class Passageiro extends Pessoa {
    private String departamento;

    // Construtor
    public Passageiro(int id, String nome, String departamento) {
        super(id, nome, "Passageiro"); //chama o construtor de Pessoa
        this.departamento = departamento;
    }

    // Getter
    public String getDepartamento() {
        return departamento;
    }

    // A classe Passageiro implementa o Departamento no método
    @Override
    public String getDetalhesEspecificos() {
        return "Departamento: " + departamento +"\n";
    }
}