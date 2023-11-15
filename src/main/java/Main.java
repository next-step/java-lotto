import java.io.PrintStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CalculatorController.of(new Scanner(System.in), System.out).calculate();
    }
}
