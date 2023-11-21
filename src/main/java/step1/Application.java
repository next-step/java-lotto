package step1;

public class Application {

    public static void main(String[] args) {
        String input = InputView.readStringInput("계산식을 입력하세요.");
        System.out.println(" input : " + input);
        StringCalculator calculator = new StringCalculator(Tokenizer.tokens(input));
        System.out.println(" result : " + calculator.calculate());
    }
}
