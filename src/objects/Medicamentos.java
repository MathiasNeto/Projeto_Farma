package objects;

public class Medicamentos {
    private String nome;
    private double preco;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPreco() {
        return String.valueOf(preco);
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
