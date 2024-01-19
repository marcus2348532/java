import java.util.Scanner;
import java.util.concurrent.*;

public class CoinCombination {
    public static int Total(int[] coins, int sum) {
        int[] num = new int[sum + 1];
        num[0] = 1;

        int half = coins.length / 2;
        
   
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < half; i++) {
                for (int j = coins[i]; j <= sum; j++) {
                    num[j] += num[j - coins[i]];
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = half; i < coins.length; i++) {
                for (int j = coins[i]; j <= sum; j++) {
                    num[j] += num[j - coins[i]];
                }
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return num[sum];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of coins: ");
        int n = scanner.nextInt();
        int[] coins = new int[n];
        System.out.println("Enter the values of the coins:");
        for (int i = 0; i < n; i++) {
            coins[i] = scanner.nextInt();
        }

        System.out.print("Enter the target sum: ");
        int sum = scanner.nextInt();

        int totalWays = Total(coins, sum);
        System.out.println("Total ways to make the sum using different coin combinations: " + totalWays);

        scanner.close();
    }
}
