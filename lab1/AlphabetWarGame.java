import java.util.Scanner;

public class AlphabetWarGame {
    private static final String LEFT_SIDE_LETTERS = "wpbs";
    private static final String RIGHT_SIDE_LETTERS = "mqdz";
    int[] S = new int[4];

    AlphabetWarGame() {
        
        int m = 4;
        for (int i = 0; i < 4; i++) {
            this.S[i] = m;
            m--;
        }
    }

    AlphabetWarGame(int[] A) {
        for (int i = 0; i < 4; i++) {
            this.S[i] = A[i];
        }
        System.out.println("The values are updated!!");
    }


    public String alphabetWar(String word) {
        int leftSideStrength = calculateStrength(word, LEFT_SIDE_LETTERS, S);
        int rightSideStrength = calculateStrength(word, RIGHT_SIDE_LETTERS, S);

        if (leftSideStrength > rightSideStrength) {
            return "Left side wins!";
        } else if (leftSideStrength < rightSideStrength) {
            return "Right side wins!";
        } else {
            return "Let's fight again!";
        }
    }

   

    public String alphabetWar(String leftWord, String rightWord) {
        int leftSideStrength = calculateStrength(leftWord, LEFT_SIDE_LETTERS, S);
        int rightSideStrength = calculateStrength(rightWord, RIGHT_SIDE_LETTERS, S);

        if (leftSideStrength > rightSideStrength) {
            return "Left side wins!";
        } else if (leftSideStrength < rightSideStrength) {
            return "Right side wins!";
        } else {
            return "Let's fight again!";
        }
    }


    private int calculateStrength(String word, String validLetters, int[] strengths) {
        int strength = 0;
        for (char letter : word.toCharArray()) {
            if (Character.isLetter(letter) && validLetters.indexOf(Character.toLowerCase(letter)) != -1) {
                strength += strengths[validLetters.indexOf(Character.toLowerCase(letter))];
            }
        }
        return strength;
    }



    public static void main(String args[]) {
        AlphabetWarGame obj1 = new AlphabetWarGame();
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        int[] v = new int[4];
        do {
            System.out.println("1. Enter the words");
            System.out.println("2. Change strength");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();


            switch (choice) {
                case 1:
                    System.out.println("Please enter the word:left world=(wpbs),right world=(mqdz)");
                    String inputWord = scanner.next();
                    System.out.println(obj1.alphabetWar(inputWord));
                    break;
                case 2:
                    System.out.println("Please enter the 4 strengths to change");
                    for (int i = 0; i < 4; i++)
                        v[i] = scanner.nextInt();
                    obj1 = new AlphabetWarGame(v);
                    break;
                case 3:
                    System.out.println("Exiting the Game!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }

        } while (choice != 3);
    }
}