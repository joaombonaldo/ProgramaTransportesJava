package Dell2;

public class Produto {
    private String nome;
    private double peso;
    private int quantidade;

    public Produto(String nome, double peso, int quantidade){
        this.nome = nome;
        this.peso = peso;
        this.quantidade = quantidade;
    }

    public String getNome(){
        return nome;
    }

    public double getPeso(){
        return peso;
    }

    public int getQuantidade(){
        return quantidade;
    }

    public String toString(){
        return "Nome: " + nome + " | Peso: " + peso + " | Quantidade: " + quantidade;
    }
}
