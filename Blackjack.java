import java.util.Scanner;

public class Blackjack1 {

    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("\nWelcome to Java Casino!");
        System.out.println("Do you have a knack for Black Jack?");
        System.out.println("We shall see..");
        System.out.println("..Ready? Press anything to begin!");
     
        scan.nextLine();
 
        int randomNum1 = drawRandomCard();
        int randomNum2 = drawRandomCard();
        String randomCard1 = cardString(randomNum1);
        String randomCard2 = cardString(randomNum2);
        
        System.out.println("\n You get a \n" + randomCard1 + "\n and a \n" + randomCard2);

        int handValue = Math.min(randomNum1,10) + Math.min(randomNum2, 10);
        System.out.println("your total is: " + handValue);

        int dealerNum1 = drawRandomCard();
        String dealerCard1 = cardString(dealerNum1);
        String faceDown =   "   _____\n"+
                            "  |     |\n"+ 
                            "  |  J  |\n"+
                            "  | JJJ |\n"+
                            "  |  J  |\n"+
                            "  |_____|\n";

        System.out.println("The dealer shows \n" + dealerCard1 + "\nand has a card facing down \n" + faceDown);
        System.out.println("\nThe dealer's total is hidden");

        String draw = hitOrStay();
        while (draw.equals("hit")) {
            int newCardNo = drawRandomCard();
            String newCard = cardString(newCardNo);
            handValue += Math.min(newCardNo, 10);
            System.out.println("\nYou get a \n" + newCard);
            System.out.println("your new total is " + handValue);

            if (handValue > 21) {
                System.out.println("Bust! Player loses");
                System.exit(0);
            }

            if (draw.equals("stay")) {
                break;
            }

        }
        int dealerNum2 = drawRandomCard();
        String dealerCard2 = cardString(dealerNum2);
        System.out.println("\nDealer's turn");
        System.out.println("\n The dealer's cards are \n" + dealerCard1 + "\n and a \n" + dealerCard2);

        int dealerValue = Math.min(dealerNum1, 10) + Math.min(dealerNum2, 10);
        while (dealerValue <= 17) {
            int dealerDrawNo = drawRandomCard();
            String dealerDrawCard = cardString(dealerDrawNo);
            System.out.println("Dealer gets a \n" + dealerDrawCard);
            dealerValue += Math.min(dealerDrawNo, 10);
            System.out.println("Dealer's total is " + dealerValue);

            if (dealerValue > 21) {
                System.out.println("Bust! Dealer loses");
                System.exit(0);
            }
        }

        if (handValue > dealerValue) {
            System.out.println("Player wins!");
        } else {
            System.out.println("Dealer wins!");
        }

        scan.close();

    }

    public static int drawRandomCard() {
        int num = (int)(Math.random()*13)+1;
        return num;
    }

    public static String cardString(int cardNumber) {
        switch (cardNumber) {
            case 1: return  "   _____\n"+
                            "  |A _  |\n"+ 
                            "  | ( ) |\n"+
                            "  |(_'_)|\n"+
                            "  |  |  |\n"+
                            "  |____V|\n";
                
            case 2: return  "   _____\n"+              
                            "  |2    |\n"+ 
                            "  |  o  |\n"+
                            "  |     |\n"+
                            "  |  o  |\n"+
                            "  |____Z|\n";

            case 3: return  "   _____\n" +
                            "  |3    |\n"+
                            "  | o o |\n"+
                            "  |     |\n"+
                            "  |  o  |\n"+
                            "  |____E|\n";

            case 4: return  "   _____\n" +
                            "  |4    |\n"+
                            "  | o o |\n"+
                            "  |     |\n"+
                            "  | o o |\n"+
                            "  |____h|\n";

            case 5: return  "   _____ \n" +
                            "  |5    |\n" +
                            "  | o o |\n" +
                            "  |  o  |\n" +
                            "  | o o |\n" +
                            "  |____S|\n";

            case 6: return  "   _____ \n" +
                            "  |6    |\n" +
                            "  | o o |\n" +
                            "  | o o |\n" +
                            "  | o o |\n" +
                            "  |____6|\n";

            case 7: return  "   _____ \n" +
                            "  |7    |\n" +
                            "  | o o |\n" +
                            "  |o o o|\n" +
                            "  | o o |\n" +
                            "  |____7|\n";

            case 8: return  "   _____ \n" +
                            "  |8    |\n" +
                            "  |o o o|\n" +
                            "  | o o |\n" +
                            "  |o o o|\n" +
                            "  |____8|\n";

            case 9: return  "   _____ \n" +
                            "  |9    |\n" +
                            "  |o o o|\n" +
                            "  |o o o|\n" +
                            "  |o o o|\n" +
                            "  |____9|\n";

            case 10: return "   _____ \n" +
                            "  |10  o|\n" +
                            "  |o o o|\n" +
                            "  |o o o|\n" +
                            "  |o o o|\n" +
                            "  |___10|\n";

            case 11: return "   _____\n" +
                            "  |J  ww|\n"+ 
                            "  | o {)|\n"+ 
                            "  |o o% |\n"+ 
                            "  | | % |\n"+ 
                            "  |__%%[|\n";

            case 12: return "   _____\n" +
                            "  |Q  ww|\n"+ 
                            "  | o {(|\n"+ 
                            "  |o o%%|\n"+ 
                            "  | |%%%|\n"+ 
                            "  |_%%%O|\n";

            case 13: return "   _____\n" +
                            "  |Q  ww|\n"+ 
                            "  | o {(|\n"+ 
                            "  |o o%%|\n"+ 
                            "  | |%%%|\n"+ 
                            "  |_%%%O|\n";
            default: return "";

        }
    }
    
    public static String hitOrStay() {
        System.out.println("hit or stay?");
        String answer = scan.nextLine();
        while (true) {
            if (answer.equalsIgnoreCase("hit")||answer.equalsIgnoreCase("stay")) {
                break;
            }
            answer = scan.nextLine();
        }
        return answer;
    }
    }

