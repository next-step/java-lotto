package step1;

public class Main {

    public static void main(String[] args) {
        String input = View.readInput();
        Numbers numbers = new Numbers(InputSplitter.split(input));

        View.printResult(StringAddCalculator.calculate(numbers));
    }
}
