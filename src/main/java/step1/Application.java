package step1;

public class Application {

    private static final int FIRST_OPERATOR = 1;
    private static final int EACH_OPERATOR = 2;

    public static void main(String[] args) {
        final var word = UserInput.word();
        final var words = word.split(" ");
        var num1 = Integer.parseInt(words[0]);

        for (int i = FIRST_OPERATOR; i < words.length; i += EACH_OPERATOR) {
            final var num2 = Integer.parseInt(words[i + 1]);
            final var calculator = Calculator.findOperator(words[i]);
            num1 = calculator.calculate(num1, num2);
        }
        System.out.println("실행 결과: " + num1);
    }

}
