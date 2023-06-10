package Dell2;

public class Caminhao {
    private String tipo;
    private int capacidade;
    private double custoPorKM;

    public Caminhao(String tipo, int capacidade, double custoPorKM){
        this.tipo = tipo;
        this.capacidade = capacidade;
        this.custoPorKM = custoPorKM;
    }

    public String getTipo(){
        return tipo;
    }

    public int getCapacidade(){
        return capacidade;
    }

    public double getCustoPorKM(){
        return custoPorKM;
    }

    public String toString(){
        return "Tipo: " + tipo + "\nCapacidade: " + capacidade + "\nCusto por KM: " + custoPorKM;
    }
}
