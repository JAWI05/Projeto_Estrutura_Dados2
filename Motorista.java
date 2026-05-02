// Classe filha da classe base Pessoa

public class Motorista extends Pessoa {
    private String placa; // placa do carro
    private String modelo; // modelo do carro

    // Construtor
    public Motorista(int id, String nome, String placa, String modelo) {
        super(id, nome, "Motorista"); //chama o construtor de Pessoa
        this.placa = placa;
        this.modelo = modelo;
    }

    // Getters
    public String getPlaca() {
        return placa;
    }
    public String getModelo() {
        return modelo;
    }

    // A classe Motorista implementa o Veículo e a placa no método
    @Override
    public String getDetalhesEspecificos() {
        return "Veículo: " + modelo +
                " | Placa: " + placa +"\n";
    }
}