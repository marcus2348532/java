import java.util.Arrays;
import java.util.Scanner;

public class ShareTrader {
    static int maxProfit;
    static int[] transactions;
    static int n;

    ShareTrader() {
        maxProfit = 0;
    }

    static void findMaxProfit() {
        int[] buy = new int[n / 2];
        int[] sell = new int[n / 2];
        int buyIndex = 0;
        int sellIndex = 0;

        for (int i = 0; i < n; i += 2) {
            buy[buyIndex++] = transactions[i];
        }

        for (int i = 1; i < n; i += 2) {
            sell[sellIndex++] = transactions[i];
        }

        Arrays.sort(buy);
        Arrays.sort(sell);

        System.out.println("Buy:");
        for (int i = 0; i < buy.length; i++)
            System.out.println(buy[i]);

        System.out.println("Sell:");
        for (int i = 0; i < sell.length; i++)
            System.out.println(sell[i]);

        int s1 = Math.abs(buy[0] - sell[0]);
        int s2 = Math.abs(buy[1] - sell[sell.length - 1]);
        int sum = s1 + s2;

        System.out.println("Trade earns " + sum + " as a sum of " + s1 + " ," + s2);
        System.out.println("Buy at " + buy[0] + ", sell at" + sell[0]);
        System.out.println("Buy at " + buy[1] + ", sell at" + sell[sell.length - 1]);
    }

    void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of the transaction:");
        n = scanner.nextInt();
        transactions = new int[n];
        System.out.println("Enter the transaction elements in Buy-Sell format");
        for (int i = 0; i < n; i++)
            transactions[i] = scanner.nextInt();
        scanner.close();
    }

    public static void main(String args[]) {
        ShareTrader shareTrader = new ShareTrader();
        shareTrader.input();
        shareTrader.findMaxProfit();
    }
}