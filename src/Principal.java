import java.util.InputMismatchException;
import java.util.Scanner;


public class Principal {

    private static int Qtd() {
       try{ Scanner sc = new Scanner(System.in);
        System.out.println("Informe com um número inteiro, qual a quantidade \nde temperaturas que você deseja converter:");
        return sc.nextInt();
       } catch (Exception e) {
           System.out.println("Você não digitou um número positivo ou inteiro.");
           return Qtd();
       }

    }

    public static void main(String[] args) {

        ToCelsius transformToCelsius = new ToCelsius();
        ToFahrenheit transformToFahrenheit = new ToFahrenheit();
        ToKelvin transformToKelvin = new ToKelvin();

        initialize();

        UnityTemp UnityActual = UnityIn("In");

        UnityTemp UnityFuture = UnityOut("Out");


        int qtdTemp = Qtd();
        if (qtdTemp <=0){
            System.out.println("Você não digitou um número positivo ou inteiro.");
            qtdTemp = Qtd();
        }

        double[] vetorActual;
        vetorActual = new double[qtdTemp];

        VetorAtual(qtdTemp,vetorActual);

        double mediaActual = 0;
        double mediaFuture = 0;
        double[] vetorFuture;
        vetorFuture = new double[qtdTemp];


            for (double mediaA : vetorActual) {
                mediaActual += mediaA;
            }
            mediaActual /= qtdTemp;

            System.out.println("A média das temperaturas digitasdas em " + UnityActual + " é de " + mediaActual + ";");

            switch (UnityActual) {
                case CELSIUS:
                    vetorFuture = transformToCelsius.transform(UnityFuture, vetorActual);
                    for (double mediaF : vetorFuture) {
                        mediaFuture += mediaF;
                    }
                    mediaFuture /= qtdTemp;
                    break;

                case KELVIN:
                    vetorFuture = transformToKelvin.transform(UnityFuture, vetorActual);
                    for (double mediaF : vetorFuture) {
                        mediaFuture += mediaF;
                    }
                    mediaFuture /= qtdTemp;
                    break;

                case FAHRENHEIT:
                    vetorFuture = transformToFahrenheit.transform(UnityFuture, vetorActual);
                    for (double mediaF : vetorFuture) {
                        mediaFuture += mediaF;
                    }
                    mediaFuture /= qtdTemp;
                    break;


                default:
                    mediaFuture = 0;
                    break;
            }

            System.out.println("\nA média das temperaturas em " + UnityFuture + " é de " + mediaFuture + ";\nAs temperaturas convertidas são na ordem informada:");
            for (double cadatemp : vetorFuture) {
                System.out.println(cadatemp);
            }


    }


    private static void initialize() {
        System.out.println(" ____________________________________________________\n|               OKUBARO´S TEMP CONVERT               |\n|____________________________________________________|\n                  *WELCOME*\n\nAs unidades de temperatura são: \nCELSIUS; \nFAHRENHEIT; \nKELVIN;\n");
    }

    private static UnityTemp UnityIn(String unityin) {
        Scanner scin = new Scanner(System.in);
        System.out.println("Escreva em qual dessas unidades está sua temperatura:\n#DICA: copie a unidade da lista acima, e cole aqui pois, \ncaso a digitação seja diferente da lista,\nnão será possível conversão.");
        String typein = scin.nextLine();
        try {
            return UnityTemp.valueOf(typein);
        } catch (IllegalArgumentException e) {
            System.out.println("A unidade foi digitada incorretamente, vamos reiniciar.");
            return UnityIn(unityin);
            }
        }

    private static UnityTemp UnityOut(String unityout) {
        Scanner scout = new Scanner(System.in);
        System.out.println("Escreva em qual unidade você deseja converter:");
        String typeout = scout.nextLine();
        try {
            return UnityTemp.valueOf(typeout);
        } catch (IllegalArgumentException e) {
            System.out.println("A unidade foi digitada incorretamente, \nsugerimos copiar identica escrita da lista de unidade.");
            return UnityOut(unityout);
        }
    }

    private static double[] VetorAtual (int qtd, double[] vetorActual){
            try {
        Scanner sc = new Scanner(System.in);
        System.out.println("Agora nosso programa permite converter todas \ntemperaturas de uma vez, portanto digite as " + qtd + " temperaturas,\nUMA de cada vez, seguidas de ENTER:");
        for (int T = 0; T < qtd; T++) {
            System.out.println("Digite a tempera " + T);
            vetorActual[T] = sc.nextDouble();
        }
    } catch (ArrayIndexOutOfBoundsException e) {
        System.out.println("Você não digitou uma temperatura válida, vamos reiniciar a digitação.\n#DICAS:O número com decimal deve ser digitado com vírgula;\nO sistema não processa nenhum outro caracter. ");
        return VetorAtual(qtd,vetorActual);
    } catch (InputMismatchException e){
                System.out.println("Você não digitou uma temperatura válida, vamos reiniciar a digitação.\n#DICAS:O número com decimal deve ser digitado com vírgula;\nO sistema não processa nenhum outro caracter. ");
                return VetorAtual(qtd,vetorActual);
            }
            return vetorActual;
    }


    }















