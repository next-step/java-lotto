import java.util.List;

public class StringCalculator {
    public int add(String input) {

        InputValue inputValue = new InputValue(input);
        List<String> expression = inputValue.getExpression();
        for (int i = 0; i < expression.size(); i++) {
            if (expression.get(i).contains("+")) {
                return Integer.parseInt(expression.get(i - 1)) + Integer.parseInt(expression.get(i + 1));
            }
        }
       throw new IllegalArgumentException();
    }
}
