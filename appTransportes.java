package Dell2;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class appTransportes {
    public static void main(String args[]){
        Scanner teclado = new Scanner (System.in);

        Caminhao pequeno = new Caminhao("Pequeno", 1000, 4.87);
        Caminhao medio = new Caminhao("Médio", 4000, 11.92);
        Caminhao grande = new Caminhao("Grande", 10000, 27.44);

        String[] cidades = {"0 - ARACAJU", "1 - BELEM", "2 - BELO HORIZONTE", "3 - BRASILIA", "4 - CAMPO GRANDE", "5 - CUIABA", "6 - CURITIBA","7 - FLORIANOPOLIS", "8 - FORTALEZA", 
        "9 - GOIANIA" ,"10 - JOAO PESSOA", "11 - MACEIO", "12 - MANAUS", "13 - NATAL", "14 - PORTO ALEGRE", "15 - PORTO VELHO", "16 - RECIFE", "17 - RIO BRANCO", "18 - RIO DE JANEIRO",
        "19 - SALVADOR", "20 - SAO LUIS", "21 - SAO PAULO", "22 - TERESINA", "23 - VITORIA"}; 

        int[][] distancias = {
            {0,2079,1578,1652,2765,2775,2595,2892,1183,1848,611,294,5215,788,3296,4230,501,4763,1855,356,1578,2187,1142,1408},
            {2079,0,2824,2120,2942,2941,3193,3500,1610,2017,2161,2173,5298,2108,3852,4397,2074,4931,3250,2100,806,2933,947,3108},
            {1578,2824,0,716,1453,1594,1004,1301,2528,906,2171,1854,3951,2348,1712,3050,2061,3584,434,1372,2738,586,2302,524},
            {1650,2140,741,0,1134,1133,1366,1673,2200,209,2245,1930,3490,2422,2027,2589,2135,3123,1148,1446,2157,1015,1789,1239},
            {2764,2942,1453,1134,0,694,991,1298,3407,935,3357,3040,3051,3534,1518,2150,3247,2684,1444,2568,2979,1014,2911,1892},
            {2773,2941,1594,1133,694,0,1679,1986,3406,934,3366,3049,2357,3543,2206,1456,3255,1990,2017,2566,2978,1614,2910,2119},
            {2595,3193,1004,1366,991,1679,0,300,3541,1186,3188,2871,4036,3365,711,3135,3078,3669,852,2385,3230,408,3143,1300},
            {2892,3500,1301,1673,1298,1986,300,0,3838,1493,3485,3168,4443,3662,476,3442,3375,3976,1144,2682,3537,705,3450,1597},
            {1183,1611,2528,2208,3407,3406,3541,3838,0,2482,688,1075,5763,537,4242,4862,800,5396,2805,1389,1070,3127,634,2397},
            {1849,2017,906,209,935,934,1186,1493,2482,0,2442,2125,3291,2618,1847,2390,2332,2924,1338,1643,2054,926,1986,1428},
            {611,2161,2171,2245,3357,3366,3188,3485,688,2442,0,395,5808,185,3889,4822,120,5356,2448,949,1660,2770,1224,2001},
            {294,2173,1854,1928,3040,3049,2871,3168,1075,2105,395,0,5491,572,3572,4505,285,5039,2131,632,1672,2453,1236,1684,},
            {5215,5298,3951,3490,3051,2357,4036,4343,5763,3291,5808,5491,0,5985,4563,901,5698,1445,4374,5009,5335,3971,5267,4476},
            {788,2108,2348,2422,3537,3543,3365,3662,537,2619,185,572,5985,0,4066,4998,297,5533,2625,1126,1607,2947,1171,2178},
            {3296,3854,1712,2027,1518,2206,711,476,4242,1847,3889,3572,4563,4066,0,3662,3779,4196,1553,3090,3891,1109,3804,2001},
            {4229,4397,3050,2589,2150,1456,3135,3442,4865,2390,4822,4505,901,4999,3662,0,4712,544,3473,4023,4434,3070,4366,3575},
            {501,2074,2061,2135,3247,3256,3078,3375,800,2332,120,285,5698,297,3779,4712,0,5243,2338,839,1573,2660,1137,1891},
            {4763,4931,3584,3123,2684,1990,3669,3976,5396,2924,5356,5039,1445,5533,4196,544,5243,0,4007,4457,4968,3604,4900,4109},
            {1855,3250,434,1148,1444,2017,852,1144,2805,1338,2448,2131,4374,2625,1553,3473,2338,4007,0,1649,3015,429,2579,521},
            {356,2100,1372,1446,2568,2567,2385,2682,1389,1643,949,632,5009,1126,3090,4023,839,4457,1649,0,1599,1962,1163,1202},
            {1578,806,2738,2157,2979,2978,3230,3537,1070,2054,1660,1672,5335,1607,3891,4434,1573,4968,3015,1599,0,2970,446,2607},
            {2188,2933,586,1015,1014,1614,408,705,3127,926,2770,2453,3971,2947,1109,3070,2660,3604,429,1962,2970,0,2792,882},
            {1142,947,2302,1789,2911,2910,3143,3450,634,1986,1224,1236,5267,1171,3804,4366,1137,4900,2579,1163,446,2792,0,2171},
            {1408,3108,524,1238,1892,2119,1300,1597,2397,1428,2001,1684,4476,2178,2001,3575,1891,4109,521,1202,2607,882,2171,0},
        };

        List<Viagem> viagens = new ArrayList<>();

        int numMenu = 0;
        while (numMenu != 4){
            System.out.println(" \n----- MENU ----- \n");
                System.out.println("(1) - Consultar Trechos X Modalidades;");
                System.out.println("(2) - Cadastrar Itens do Transporte;");
                System.out.println("(3) - Dados estatísticos;");
                System.out.println("(4) - Finalizar programa;");
                numMenu = teclado.nextInt();


        switch (numMenu){
            case 1:
            System.out.println(" \n----- TRECHOS X MODALIDADE ----- \n");
            
            String cidade1 = "";
            String cidade2 = "";
            int cidadeOrigem = -1;
            
            while (cidadeOrigem < 0 || cidadeOrigem >= cidades.length){
                System.out.println("Escolha a cidade de origem: (0 a 23)\n" + Arrays.toStringCustom(cidades));
                cidadeOrigem = teclado.nextInt();
                
                if (cidadeOrigem >= 0 && cidadeOrigem < cidades.length) {
                    cidade1 = cidades[cidadeOrigem];
                    } else {
                    System.out.println("\nA cidade escolhida é inválida. Por favor, digite um valor entre 0 e " + (cidades.length - 1) + ".");
                    }
            }

            int cidadeDestino = -1;
            while (cidadeDestino < 0 || cidadeDestino >= cidades.length){
                System.out.println("\nEscolha a cidade de destino: (0 a 23) \n" + Arrays.toStringCustom(cidades));
                cidadeDestino = teclado.nextInt();
                 if (cidadeDestino >= 0 && cidadeDestino < cidades.length) {
                    cidade2 = cidades[cidadeDestino];
                     } else {
                     System.out.println("A cidade escolhida é inválida. Por favor, digite um valor entre 0 e " + (cidades.length - 1) + ".");
                     }
            }

            int escolhaCaminhao;
            do {
                System.out.println("Escolha qual o caminhão mais adequado para o seu transporte: \n"
                                   + "\nOpção 1 \n" + pequeno.toString()
                                   + "\n\nOpção 2 \n" + medio.toString()
                                   + "\n\nOpção 3 \n" + grande.toString());
                escolhaCaminhao = teclado.nextInt();
                if (escolhaCaminhao < 1 || escolhaCaminhao > 3) System.out.println("Opção Inválida! Digite novamente.");
            } while (escolhaCaminhao < 1 || escolhaCaminhao > 3);

            int distancia = distancias[cidadeOrigem][cidadeDestino];
            
            double custoTotal;
            switch (escolhaCaminhao){
                case 1:
                custoTotal = distancia * pequeno.getCustoPorKM();
                System.out.println("\nAs cidades escolhidas são: " + cidade1 + " | " + cidade2);
                System.out.printf("A distância total a ser percorrida é de %d KM%n", distancia);
                System.out.printf("O custo total do transporte com o caminhão PEQUENO é de R$ %.2f%n", custoTotal);
                break;

                case 2:
                custoTotal = distancia * medio.getCustoPorKM();
                System.out.println("\nAs cidades escolhidas são: " + cidade1 + " | " + cidade2);
                System.out.printf("A distância total a ser percorrida é de %d KM%n", distancia);
                System.out.printf("O custo total do transporte com o caminhão MÉDIO é de R$ %.2f%n", custoTotal);
                break;

                case 3:
                custoTotal = distancia * grande.getCustoPorKM();
                System.out.println("\nAs cidades escolhidas são: " + cidade1 + " | " + cidade2);
                System.out.printf("A distância total a ser percorrida é de %d KM%n", distancia);
                System.out.printf("O custo total do transporte com o caminhão GRANDE é de R$ %.2f%n", custoTotal);
                break;
            }
            break;

            case 2:
            System.out.println(" \n----- CADASTRO DE TRANSPORTE ----- \n");


            int numCidades;
            do {
                System.out.print("\nDigite o número de cidades que você deseja fazer o transporte: ");
                numCidades = teclado.nextInt();
                if (numCidades < 2) System.out.println("Número inválido! Você tem que escolher, no mínimo, 2 cidades.");
            } while (numCidades < 2);

            String[] cidadesTransporte = new String[numCidades];

            for (int i = 0; i < cidadesTransporte.length; i++){
                System.out.println("\nDigite o número da cidade: \n" + Arrays.toStringCustom(cidades));
                int cidadeEscolhida = teclado.nextInt();
                if (cidadeEscolhida > 0 || cidadeEscolhida < cidades.length) {
                    cidadesTransporte[i] = cidades[cidadeEscolhida];
                } else {
                    System.out.println("Cidade inválida! Digite novamente.");
                    i--;
                }
            }

            int distanciaCidades = 0;
            for (int i = 0; i < cidadesTransporte.length - 1; i++) {
                String cidadeOrigemString = cidadesTransporte[i].split(" - ")[0];
                String cidadeDestinoString = cidadesTransporte[i + 1].split(" - ")[0];
                
                cidadeOrigem = Integer.parseInt(cidadeOrigemString);
                cidadeDestino = Integer.parseInt(cidadeDestinoString);
                
                distanciaCidades += distancias[cidadeOrigem][cidadeDestino];
            }

            System.out.println("\n\n --- As cidades escolhidas são --- \n\n" + Arrays.toStringCustom(cidadesTransporte));

            int quantidadeProdutos;
            do{
                System.out.println("\nDigite a quantidade de produtos que você deseja adicionar: ");
                quantidadeProdutos = teclado.nextInt();
                if (quantidadeProdutos <= 0) System.out.println("Quantidade inválida. Adicione pelo menos 1 produto.");
            } while (quantidadeProdutos <= 0);

            teclado.nextLine();
            ArrayList<Produto> produtos = new ArrayList<>();
            for (int i = 0; i < quantidadeProdutos; i++) {
                String nomeProduto;
                do {
                    System.out.printf("\nDigite o nome do produto %d: \n", i+1);
                    nomeProduto = teclado.nextLine();
                    if (nomeProduto.trim().isEmpty()) System.out.println("Nome inválido. Digite novamente.");
                } while (nomeProduto.trim().isEmpty());

                double pesoProduto;
                do{
                    System.out.printf("Digite o peso do produto %d: \n", i+1);
                    pesoProduto = teclado.nextDouble();
                    if (pesoProduto < 0) System.out.println("O peso não pode ser negativo!");
                } while (pesoProduto < 0);
                
                System.out.println("Digite a quantidade de produtos: ");
                int quantidade = teclado.nextInt();
            
                teclado.nextLine();
            
                Produto produto = new Produto(nomeProduto, pesoProduto, quantidade);
                produtos.add(produto);
            }
            
            double pesoTotal = 0;
            int quantProdutos = 0;
            System.out.println("\n --- Produtos Adicionados --- \n");

            System.out.println("\n --- Relatório --- \n");

            System.out.println("As cidades escolhidas são: " + Arrays.toStringCustom(cidadesTransporte));
            System.out.println("A distância entre as cidades escolhidas é de: " + distanciaCidades + "KM");
            System.out.println("Os produtos adicionados são:");
            for (int j = 0; j < produtos.size(); j++){
                System.out.println("Nome: " + produtos.get(j).getNome() + " | Peso: " + produtos.get(j).getPeso() + " | Quantidade: " + produtos.get(j).getQuantidade());
                pesoTotal += produtos.get(j).getPeso() * produtos.get(j).getQuantidade();
                quantProdutos += produtos.get(j).getQuantidade();
            }
            System.out.printf("Peso Total Acumulado dos produtos: %.2fKG%n", pesoTotal);
            
            int [] quantCaminhoes = melhorCaminhao(pesoTotal);
            System.out.println("Serão necessários");
            if (quantCaminhoes[0] != 0) System.out.println("Caminhão(ões) pequeno(s): " + quantCaminhoes[0]);
            if (quantCaminhoes[1] != 0)  System.out.println("Caminhão(ões) médio(s): " + quantCaminhoes[1]);
            if (quantCaminhoes[2] != 0) System.out.println("Caminhão(ões) grande(s): " + quantCaminhoes[2]);

            custoTotal = ((distanciaCidades * 4.87) * quantCaminhoes[0]) + ((distanciaCidades * 11.92) * quantCaminhoes[1]) + ((distanciaCidades * 27.44) * quantCaminhoes[2]);
            System.out.printf("O custo total para esse transporte será de: R$%.2f\n", custoTotal);

            double custoPorKM = custoTotal / distanciaCidades;

            int numCaminhoes = quantCaminhoes[0] + quantCaminhoes[1] + quantCaminhoes[2];

            double[] custoPorTrecho = new double[numCidades - 1];
            for (int i = 0; i < custoPorTrecho.length; i++) {
                String cidadeOrigemString = cidadesTransporte[i].split(" - ")[0];
                String cidadeDestinoString = cidadesTransporte[i + 1].split(" - ")[0];
                
                cidadeOrigem = Integer.parseInt(cidadeOrigemString);
                cidadeDestino = Integer.parseInt(cidadeDestinoString);
                
                custoPorTrecho[i] = ((distancias[cidadeOrigem][cidadeDestino] * 4.87) * quantCaminhoes[0]) + ((distancias[cidadeOrigem][cidadeDestino] * 11.92) * quantCaminhoes[1]) + ((distancias[cidadeOrigem][cidadeDestino] * 27.44) * quantCaminhoes[2]);
            }

             for (int j = 0; j < custoPorTrecho.length; j++){
                System.out.printf("O custo do " + (j + 1) + " trecho é: R$%.2f\n", custoPorTrecho[j]);
            }
            
            Viagem viagem = new Viagem(cidadesTransporte, distanciaCidades, custoTotal, custoPorKM, custoPorTrecho, quantProdutos, numCaminhoes);
            viagens.add(viagem);
            break;

            case 3:
            System.out.println("\n----- DADOS ESTATÍSTICOS -----\n");
            if (viagens.isEmpty()) {
                System.out.println("Não foram adicionadas viagens até momento.");
            } else {
                for (int i = 0; i < viagens.size(); i++) {
                    System.out.println("\n\n--- RELATÓRIO DA VIAGEM " + (i+1) + " ---" + "\n\n");
                    String[] cidadesEst = viagens.get(i).getCidades();
                    for (int j = 0; j < cidadesEst.length; j++) {
                        System.out.println("As cidades escolhidas são: " + cidadesEst[j]);
                    }
                    System.out.println("A distância entre as cidades escolhidas é de: " + viagens.get(i).getKmTotal() + " KM");
                    System.out.printf("O custo total para esse transporte será de: R$%.2f\n", viagens.get(i).getCustoTotal());
                    System.out.printf("O custo por KM vai ser de: R$%.2f\n", viagens.get(i).getCustoPorKm());
                    custoPorTrecho = viagens.get(i).getCustoPorTrecho();
                    for (int k = 0; k < custoPorTrecho.length; k++) {
                        System.out.printf("O custo do " + (k + 1) + "º trecho é: R$%.2f\n", custoPorTrecho[k]);
                    }
                    System.out.println("A quantidade de itens a serem transportados é de: " + viagens.get(i).getNumItens());
                    System.out.println("A quantidade de caminhões para fazer o transporte será de: " + viagens.get(i).getNumCaminhoes());
                }
            }
            break;

            case 4:
            System.out.println(" \n----- FINALIZANDO PROGRAMA ----- \n");
            System.out.println("Programa Encerrado.");
        }
        }
    }

    public static int[] melhorCaminhao(double pesoTotal) {
        int[] caminhoes = new int[3];
    
        if (pesoTotal <= 1000) {
            caminhoes[0] = 1;
        } else {
            caminhoes[2] = (int) Math.floor(pesoTotal / 10000.0);
            double resto = pesoTotal % 10000.0;
            caminhoes[1] = (int) Math.floor(resto / 4000.0);
            caminhoes[0] = (int) Math.floor((resto % 4000.0) / 1000.0);
        }
        return caminhoes;
    }
}

    class Arrays{
        public static String toStringCustom(String[] array) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < array.length; i++) {
                    sb.append("\n" + array[i]);
                }
                return sb.toString();
        }        
    }


