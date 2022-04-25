package Calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    private static final String NUMBER_REGULAR = "[0-9]";
    private static final String OPERATION_REGULAR = "[+*-/]";
    
    private Numbers numbers;
    private Operations operators;
    private Integer result;

    public Calculator(String input) {
        validation(input);
        result = 0;
        numbers = new Numbers(findNumber(input));
        operators = new Operations(findOperator(input));
    }

    private void validation(String input) {
        if (input == null) {
            throw new IllegalArgumentException("입력 값이 존재하지 습니다.");
        }

        if (input.isBlank()) {
            throw new IllegalArgumentException("입력 값이 공백 입니다.");
        }
    }

    private List<Integer> findNumber(String input) {
        ArrayList<Integer> numbers = new ArrayList<>();

        Matcher matcher = Pattern.compile(NUMBER_REGULAR).matcher(input);
        while (matcher.find()) {
            numbers.add(Integer.parseInt(matcher.group()));
        }
        return numbers;
    }

    private List<String> findOperator(String input) {
        List<String> operators = new ArrayList<>();

        Matcher matcher = Pattern.compile(OPERATION_REGULAR).matcher(input);
        while (matcher.find()) {
            operators.add(matcher.group());
        }
        return operators;
    }

    public Integer operation() {
        if (operators.isAddition()) {
            Addition addition = new Addition();
            result += addition.sum(numbers.next(), numbers.next());
        }

        if (operators.isSubtraction()) {
            Subtraction subtraction = new Subtraction();
            result += subtraction.subtract(numbers.next(), numbers.next());
        }

        if (operators.isMultiplication()) {
            Multiplication multiplication = new Multiplication();
            result += multiplication.multiply(numbers.next(), numbers.next());
        }

        if (operators.isDivision()) {
            Division division = new Division();
            result += division.division(numbers.next(), numbers.next());
        }

        return result;
    }
}
