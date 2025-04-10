import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Informe o 1º parâmetro >> ");
        int parametroUm = sc.nextInt();

        System.out.print("Informe o 2º parâmetro >> ");
        int parametroDois = sc.nextInt();

        try {
            contarNumeros(parametroUm, parametroDois);
        }
        catch (ParametrosInvalidosException e) {
            System.out.println(e.getMessage());
        }
    }

    static void contarNumeros(int parametroUm, int parametroDois) throws ParametrosInvalidosException {
        if (parametroUm > parametroDois) {
            throw new ParametrosInvalidosException("O segundo parâmetro deve ser maior que o primeiro");
        }

        int contagem = parametroDois - parametroUm;

        for (int i = 0; i < contagem; i++) {
            System.out.println("Imprimindo o número " + (i+1));
        }
    }
}