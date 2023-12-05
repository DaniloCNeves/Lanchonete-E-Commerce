package service;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Leitor {
    public static String texto(){
        Scanner leia = new Scanner(System.in);
        return leia.nextLine();
    }

    public static int inteiros(){
        int valor = 0;
        boolean acertou = false;

        do {
            try {
                Scanner leia = new Scanner(System.in);
                valor = leia.nextInt();
                acertou = true;
            } catch (InputMismatchException e) {
                System.out.println("Apenas números inteiros");
                System.out.print("Tente Novamente: ");
            } catch (Exception e){
                System.out.println("Erro inesperado!");
                System.out.println(e);
                System.out.print("Tente novamente: ");
            }
        }while(!acertou);

        return valor;
    }

    public static float decimais(){
        float valor = 0;
        boolean acertou = false;

        do {
            try {
                Scanner leia = new Scanner(System.in);
                valor = leia.nextFloat();
                acertou = true;
            } catch (InputMismatchException e) {
                System.out.println("Apenas números inteiros");
                System.out.print("Tente Novamente: ");
            } catch (Exception e){
                System.out.println("Erro inesperado!");
                System.out.println(e);
                System.out.print("Tente novamente: ");
            }
        }while(!acertou);

        return valor;
    }
    public static double doubleDecimais(){
        double valor = 0;
        boolean acertou = false;

        do {
            try {
                Scanner leia = new Scanner(System.in);
                valor = leia.nextDouble();
                acertou = true;
            } catch (InputMismatchException e) {
                System.out.println("Apenas números inteiros");
                System.out.print("Tente Novamente: ");
            } catch (Exception e){
                System.out.println("Erro inesperado!");
                System.out.println(e);
                System.out.print("Tente novamente: ");
            }
        }while(!acertou);

        return valor;
    }
}
