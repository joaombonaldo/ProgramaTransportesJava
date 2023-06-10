package Dell2;

import java.util.Arrays;

public class Viagem {
    private String[] cidades;
    private double kmTotal;
    private double custoTotal;
    private double custoPorKm;
    private double[] custoPorTrecho;
    private int numItens;
    private int numCaminhoes;

    public Viagem(String[] cidadesTransporte, double kmTotal, double custoTotal, double custoPorKm, double[] custoPorTrecho, int numItens, int numCaminhoes){
        this.cidades = cidadesTransporte;
        this.kmTotal = kmTotal;
        setCustoTotal(custoTotal);
        setCustoPorKm(custoPorKm);
        setCustoPorTrecho(custoPorTrecho);
        this.numItens = numItens;
        setNumCaminhoes(numCaminhoes);
    }

    public String[] getCidades(){
        return cidades;
    }

    public double getKmTotal(){
        return kmTotal;
    }

    public double getCustoTotal(){
        return custoTotal;
    }

    public double getCustoPorKm(){
        return custoPorKm;
    }

    public double[] getCustoPorTrecho(){
        return custoPorTrecho;
    }

    public int getNumItens(){
        return numItens;
    }

    public int getNumCaminhoes(){
        return numCaminhoes;
    }

    public void setCustoTotal(double novoCusto){
        if (novoCusto >= 0) {
            custoTotal = novoCusto;
        }
    }

    public void setCustoPorKm(double novoCustoPorKm){
        if (novoCustoPorKm >= 0) {
            custoPorKm = novoCustoPorKm;
        }
    }

    public void setCustoPorTrecho(double[] novoCustoPorTrecho){
        if (novoCustoPorTrecho != null) {
            custoPorTrecho = novoCustoPorTrecho;
        }
    }

    public void setNumItens(int novoNumItens){
        if (novoNumItens >= 0) {
            numItens = novoNumItens;
        }
    }

    public void setNumCaminhoes(int novoNumCaminhoes){
        if (novoNumCaminhoes >= 0) {
            numCaminhoes = novoNumCaminhoes;
        }
    }
}
