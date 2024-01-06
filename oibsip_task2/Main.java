import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int guessedNumber = 0;
        int attempts = 7;
        int randomNumber = (int)(Math.random()*100+1);

        //System.out.println(randomNumber);

        while (guessedNumber!=randomNumber && attempts!=0){
            attempts--;
            System.out.println(attempts+" attempts left");
            System.out.println("------------------------------");
            System.out.print("Enter Guessed Number: ");
            guessedNumber = scanner.nextInt();

            if(guessedNumber>randomNumber){
                System.out.println("Random Number is lower than your Number");
            }else {
                System.out.println("Random Number is greater than your Number");
            }
        }

        if(attempts==0){
            System.out.println("------------------");
            System.out.println("Game Over");
            System.out.println("------------------");
            System.out.println("Random number is "+randomNumber);
            System.out.println("Your Score : 0");
        }else{
            System.out.println("------------------");
            System.out.println("You Won");
            System.out.println("------------------");
            System.out.println("Random number is "+randomNumber);
            System.out.println(attempts+" attempts left");
            System.out.println("Your Score is: "+(attempts*10));
        }

    }
}