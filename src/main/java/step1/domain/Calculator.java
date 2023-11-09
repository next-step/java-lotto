package step1.domain;

import java.util.LinkedList;

public class Calculator {

    public static int calculation(LinkedList<Integer> numbers, LinkedList<Operator> operators) {
        while (!operators.isEmpty()) {
            Integer number1 = numbers.pollFirst();
            Integer number2 = numbers.pollFirst();
            Operator operator = operators.pollFirst();

            Integer result = operator.calculation(number1, number2);
            numbers.addFirst(result);
        }

        return numbers.getFirst();
    }

}
