import acm.program.ConsoleProgram;

public class FindRange extends ConsoleProgram {
    private static final int SENTINEL = 0;

    public void run() {
        println("This program finds the largest and smallest numbers");
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        while (true) {
            int current = readInt("? ");
            if (current == SENTINEL) {
                if (min == Integer.MAX_VALUE) {
                    println("You need to enter at least one number");
                    return;
                }
                break;
            }
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
