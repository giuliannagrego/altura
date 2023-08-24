package app;

import entities.Pessoas;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

//        Fazer um programa para ler nome, idade e altura de N pessoas, conforme exemplo.
//        Depois, mostrar na tela a altura média das pessoas.
//        Mostrar também a porcentagem de pessoas com menos de 16 anos, e seus respectivos nomes.

        String name;
        int num, age, numMenores;
        double height, alturaMedia, alturaTotal, percentualMenores;


        System.out.print("Quantas pessoas serão registradas? ");
        num = sc.nextInt();

        Pessoas[] person = new Pessoas[num];

        for (int i = 0; i < person.length; i++ ) {
            sc.nextLine();
            System.out.println("Dados da " + (i + 1) + "a pessoa: ");

            System.out.print("Nome: ");
            name = sc.nextLine();

            System.out.print("Idade: ");
            age = sc.nextInt();

            System.out.print("Altura: ");
            height = sc.nextDouble();

            person[i] = new Pessoas(name, age, height);
            System.out.println();
        }

        numMenores = 0;
        alturaTotal = 0;

        for (Pessoas pessoas : person) {
            if (pessoas.getAge() < 16) {
                numMenores++;
            }

            alturaTotal += pessoas.getHeight();
        }

        alturaMedia = alturaTotal / num;
        percentualMenores = ((double) numMenores /num) * 100;

        System.out.printf("\nAltura media = %.2f\n", alturaMedia);
        System.out.printf("Pessoas com menos de 16 anos: %.1f%%\n", percentualMenores);

        for (Pessoas pessoas : person) {
            if (pessoas.getAge() < 16) {
                System.out.printf("%s\n", pessoas.getName());
            }
        }

        sc.close();
    }
}
