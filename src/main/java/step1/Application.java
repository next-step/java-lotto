package step1;

public class Application {

    public static void main(String[] args) {
        String input = "5 - 4 + 3 * 2 / 1";
        System.out.println(" input : " + input);
        StringCalculator calculator = new StringCalculator(Tokenizer.tokens(input));
        System.out.println(" result : " + calculator.calculate());
    }
}
