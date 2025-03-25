package calculator;

import calculator.operator.*;
import calculator.ui.InputView;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Main {

    private static List<Operator> operators ;

    public static void main(String[] args) {
        operators = Arrays.asList(new Plus(), new Minus(), new Multiply(), new Divide());


        String input = InputView.get();
        String[] splits = input.split(" ");

        int a = 0;
        Operator operator = null;
        var b = 0;
        for (String element : splits) {
            boolean digit = Character.isDigit(element.charAt(0));

            if (digit) {
                try {
                    if (a == 0) {
                        a = Integer.parseInt(element);
                    } else if (b == 0) {
                        b = Integer.parseInt(element);
                    }

                    if (a != 0 && b != 0 && operator != null) {
                        a = operator.calculate(a, b);
                        b = 0;
                        operator = null;
                    }
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다.");
                }
            } else {
                operator = operators.stream().filter(s -> s.isOperator(element))
                        .findFirst()
                        .orElseThrow(IllegalArgumentException::new);
            }
        }
        System.out.println("result: " + a);
    }
}
