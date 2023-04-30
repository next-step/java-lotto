package step1;

public class Execution {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        //String input = "2 + 3 * 4 / 2";
        String input = "2 * 3 + 4 / 2";
        int result = calculator.calculate(input);
        System.out.println(result);
    }
}
