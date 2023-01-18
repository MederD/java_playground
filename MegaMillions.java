/*
 * To play Mega Millions, pick up a playslip and select five main numbers between 1 and 70 and one Mega Ball number from 1 to 25. 
 * You match all the numbers - Jackpot!
 * You match all five main numbers - $1,000,000
 * Any four main/white numbers and the mega ball: $10,000
 * Any four main/white numbers: $500
 * Any three main/white numbers and the mega ball: $200
 * Any three main/white numbers: $10
 * Any two main/white numbers and the mega ball: $10
 * Any main/white number and the mega ball: $4
 * The mega ball only: $2
 */

import java.util.Arrays;
import java.util.Scanner;

public class MegaMillions {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome to Mega Millions simulator game\n");
        System.out.println("You need to enter 5 main numbers between 1 and 70");
      
        int[] userChoise = new int [6];
        for (int i = 1; i <= 5; i++) {
            System.out.println("Please enter number: " + i);
            int num = scan.nextInt();
            boolean check = (1 <= num && num <= 70);
            if (!check) {
                System.out.println("Please enter number between 1 and 70");
                num = scan.nextInt();
            }
            userChoise[i-1] = num;
        }

        System.out.println("You need to enter 1 mega number between 1 and 25");
            userChoise[5] = scan.nextInt();
            boolean checkMega = (1 <= userChoise[5] && userChoise[5] <= 25);
            if (!checkMega) {
                System.out.println("Please enter number between 1 and 25");
                userChoise[5] = scan.nextInt();
            }
        

        int[] ticket = new int[6];
        for (int i = 0; i < ticket.length; i++) {
            ticket[i] = mainNumber();
        }
        ticket[5] = megaNumber();

        System.out.println("\nYou choise: " + Arrays.toString(userChoise).replace("[", "").replace("]", ""));
        System.out.print("Ticket numbers: ");
        printTicketNumbers(ticket);
        printResults(userChoise, ticket);

        scan.close();
    }

    public static void printTicketNumbers(int[] ticket) {
        for (int i = 0; i < ticket.length; i++) {
            System.out.print(ticket[i] + " ");
        }
        System.out.println("\n");
    }

    public static int mainNumber() {
        int randomMain = (int)(Math.random() * 70) + 1;
        return randomMain;
    }

    public static int megaNumber() {
        int randomMega = (int)(Math.random() * 25) + 1;
        return randomMega;
    }

    public static void printResults(int[] userChoise, int[] ticket) {
        int[] justMainChoise = Arrays.copyOfRange(userChoise, 0, 5);
        int[] justMainTicket = Arrays.copyOfRange(ticket, 0, 5);

        int match = 0;
        for (int i = 0; i < justMainChoise.length; i++) {
            for (int j = 0; j < justMainTicket.length; j++) {
                if (justMainChoise[i] == justMainTicket[j]) {
                    match ++;
                }
            }
        }

        if (Arrays.equals(userChoise, ticket)) {
            System.out.println("Jackpot!");
        } else if (Arrays.equals(justMainChoise, justMainTicket)) {
            System.out.println("You won $1,000,000");
        } else if (match == 4 && (userChoise[5] == ticket[5])) {
            System.out.println("You won $10,000");
        } else if (match == 4) {
            System.out.println("You won $500");
        } else if (match == 3 && (userChoise[5] == ticket[5])) {
            System.out.println("You won $200");
        } else if (match ==3) {
            System.out.println("You won $10");
        } else if (match == 2 && (userChoise[5] == ticket[5])) {
            System.out.println("You won $10");
        } else if (match == 1 && (userChoise[5] == ticket[5])) {
            System.out.println("You won $4");
        } else if (userChoise[5] == ticket[5]) {
            System.out.println("You won $2");
        } else {
            System.out.println("You lost");
        }
    }
}

