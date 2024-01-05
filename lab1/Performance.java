import java.util.Scanner;

public class Performance {
    private int[] marks = new int[10];
    private int[] rep = new int[10];
    private int[] freq = new int[10];
    private int Mode = -1;

  
    public Performance() {
        readMarks();
    }

    public void readMarks() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter marks for 10 students:");
        for (int i = 0; i < 10; i++) {
            System.out.print("Student " + (i + 1) + ": ");
            marks[i] = scanner.nextInt();


            if (marks[i] < 0 || marks[i] > 100) {
                System.out.println("Invalid marks. Marks should be between 0 and 100.");
                i--; 
            }
        }
    }

    
    public int highestMark() {
        int max = marks[0];
        for (int i = 1; i < marks.length; i++) {
            if (marks[i] > max) {
                max = marks[i];
            }
        }
        return max;
    }

    public int leastMark() {
        int min = marks[0];
        for (int i = 1; i < marks.length; i++) {
            if (marks[i] < min) {
                min = marks[i];
            }
        }
        return min;
    }

  
    public int getMode() {
        int k = 0;
        int[] samp = new int[10];
        for (int i = 0; i < 10; i++)
            samp[i] = marks[i];b
            
        for (int i = 0; i <= 9; i++) {
            for (int j = i + 1; j <= 9; j++) {
                if (samp[i] == samp[j] && samp[i] != -1) {
                    rep[k] = samp[i];
                    freq[k]++;
                    samp[j] = -1;
                }
            }
            k++;
        }

        int maxFreq = freq[0];
        int modeIndex = 0;

        for (int i = 0; i < 10; i++) {
            if (freq[i] > maxFreq) {
                maxFreq = freq[i];
                modeIndex = i;
            }
        }

        if (maxFreq == 0) {
            return -1; 
        }

        Mode = rep[modeIndex];
        return Mode;
    }
    public int getFreqAtMode() {
        int k = 0;
            for (int i = 0; i < 10; i++) {
                if (Mode == marks[i])
                    k++;
            }
            return k;
        
    }

    public void display() {
        System.out.println("Highest Mark: " + highestMark());
        System.out.println("Least Mark: " + leastMark());
        System.out.println("Mode: " + getMode());
        System.out.println("Mode Frequency: " + getFreqAtMode());
    }

    public static void main(String[] args) {
        Performance performance = new Performance();
        performance.display();
    }
}