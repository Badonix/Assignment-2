import acm.program.ConsoleProgram;

public class PythagoreanTheorem extends ConsoleProgram {
    public void run() {
        println("Enter numbers to compute Pythagorean theorem");
        int a = readInt("a: ");
        while (a <= 0) {
            a = readInt("a has to be positive integer: ");
        }
        int b = readInt("b: ");
        while (b <= 0) {
            b = readInt("b has to be positive integer: ");
        }
        print("c = " + Math.sqrt(a * a + b * b));
    }
}
