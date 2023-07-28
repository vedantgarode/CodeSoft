import java.util.*;

class Game {
    public static void main(String args[]) {
        Random r = new Random();
        Scanner sc = new Scanner(System.in);
        int randomNumber = r.nextInt(100) + 1;
        //system.out.println(randomNumber);

        int noOfGuesses = 0;
        System.out.println("Enter your guess between 1-100:");
        boolean flag = true;
        while (flag) {
            if(noOfGuesses % 5 == 0 && noOfGuesses != 0){
                System.out.println("Round Ended !! \nPlay Again ??(yes/no)");
                String s = sc.nextLine();
                s = sc.nextLine();
                if(s.equals("no")){
                    System.out.println("Game Ended !!");
                    flag = false;
                    break;
                }
                else{
                    System.out.println("Enter your guess between 1-100:");
                }
            }
            noOfGuesses++;
            int guessedNumber = sc.nextInt();
            if (guessedNumber == randomNumber) {
                System.out.println("victory! your guess is correct");
                System.out.println("It took you " + noOfGuesses + " guesses to win");
                break;
            } else if (randomNumber > guessedNumber) {
                System.out.println("Your number is lower. Guess again.");
            } else {
                System.out.println("Your number is higher. Guess again.");
            }

        }
    }
}