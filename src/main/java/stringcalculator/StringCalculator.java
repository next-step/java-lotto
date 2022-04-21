package stringcalculator;

import java.util.Stack;
import java.util.regex.Pattern;

public class StringCalculator {

    public long calculate(Equation equation) {
        Pattern numberPattern = Pattern.compile("[0-9]+");
        Stack<Integer> numbers = new Stack<>();
        Stack<String> operators = new Stack<>();

        String input = equation.getInput();
        String[] characters = input.split(" ");
        for (String character : characters) {
            if (numberPattern.matcher(character).matches()) {
                if (operators.isEmpty()) {
                    numbers.push(Integer.parseInt(character));
                } else {
                    Integer previous = numbers.pop();
                    String operator = operators.pop();
                    switch (operator) {
                        case "+":
                            numbers.push(Integer.parseInt(character) + previous);
                        default:
                    }
                }
            } else {
                operators.push(character);
            }
        }
        return numbers.pop();
    }
}
