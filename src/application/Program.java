package application;

import entities.Champion;

import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Champion champion1, champion2;

        System.out.println("Digite os dados do primeiro campeão: ");
        System.out.print("Nome: ");
        String name = sc.nextLine();
        System.out.print("Vida inicial: ");
        int life = sc.nextInt();
        System.out.print("Ataque: ");
        int attack = sc.nextInt();
        System.out.print("Armadura: ");
        int armor = sc.nextInt();

        champion1 = new Champion(name, life, attack, armor);

        System.out.println();
        System.out.println("Digite os dados do segundo campeão: ");
        System.out.print("Nome: ");
        sc.nextLine();
        name = sc.nextLine();
        System.out.print("Vida inicial: ");
        life = sc.nextInt();
        System.out.print("Ataque: ");
        attack = sc.nextInt();
        System.out.print("Armadura: ");
        armor = sc.nextInt();

        champion2 = new Champion(name, life, attack, armor);
        System.out.println();

        System.out.print("Quantos turnos você deseja executar? ");
        int turnos = sc.nextInt();


        System.out.println();
        for (int i=1; i<=turnos; i++) {
            champion1.takeDamage(champion2);
            champion2.takeDamage(champion1);
            System.out.printf("Resultado do turno %d:", i);

            if (champion1.getLife() < 0) {
                champion1.setLife(0);
                System.out.print(champion1.status() + " (morreu)");
                System.out.print(champion2.status());
                break;
            }
            else if (champion2.getLife() < 0) {
                champion2.setLife(0);
                System.out.print(champion1.status());
                System.out.print(champion2.status() + " (morreu)");
                break;
            }
            else {
                System.out.print(champion1.status());
                System.out.print(champion2.status());
            }
            System.out.println();
            System.out.println();

        }
        System.out.println();
        System.out.printf("%nFIM DO COMBATE%n");


        sc.close();
    }
}
