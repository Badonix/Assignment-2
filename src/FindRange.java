import acm.program.ConsoleProgram;

public class FindRange extends ConsoleProgram {
    public void run() {
        println("This program finds the largest and smallest numbers");
        int current = readInt("? ");
        int min = current;
        int max = current;
        while (current != 0) {
            current = readInt("? ");
            min = findMin(current, min);
            max = findMax(current, max);
        }
        println("smallest: " + min);
        println("largest: " + max);
    }

    private int findMin(int a, int b) {
        return a > b ? b : a;
    }

    private int findMax(int a, int b) {
        return a > b ? a : b;
    }
}
