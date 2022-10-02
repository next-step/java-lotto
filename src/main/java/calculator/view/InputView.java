package calculator.view;

import calculator.Operator;

import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class InputView {

    private static final String SEPARATOR = " ";

    public List<String> receiveFormula() {
        System.out.println("계산식을 입력해주세요. 숫자와 연산자를 공백으로 구분합니다. ex) 6 + 5 - 4 * 3 / 2");
        String input = new Scanner(System.in).nextLine();
        List<String> result = List.of(input.split(SEPARATOR));
        validate(result.size() < 3, "적어도 숫자 2개와 연산자 하나를 입력해야합니다. ex) 1 + 2");
        validate(result.size() % 2 == 0, "연산자와 숫자 개수의 합은 짝수일 수 없습니다. 숫자로 끝나는 정확한 계산식을 입력하세요.");
        validateEvenIndexIsNumber(result);
        validateOddIndexIsOperator(result);
        return result;
    }

    private void validate(boolean result, String message) {
        if (result) {
            System.out.println(message);
            throw new IllegalArgumentException(message);
        }
    }

    private void validateEvenIndexIsNumber(List<String> result) {
        IntStream.range(0, result.size())
                .filter(i -> i % 2 == 0)
                .mapToObj(result::get)
                .forEach(this::validateNumber);
    }

    private void validateNumber(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            System.out.println("숫자의 위치에 숫자가 아닌 값이 입력되었습니다. 숫자 연산자 숫자 순으로 번갈아가며 입력해주세요.");
            throw new IllegalArgumentException("숫자의 위치에 숫자가 아닌 값이 입력되었습니다. 숫자 연산자 숫자 순으로 번갈아가며 입력해주세요.");
        }
    }

    private void validateOddIndexIsOperator(List<String> result) {
        IntStream.range(0, result.size())
                .filter(i -> i % 2 == 1)
                .mapToObj(result::get)
                .forEach(this::validateOperator);
    }

    private void validateOperator(String operator) {
        if (!isOperator(operator)) {
            System.out.println("연산자(+,-,*,/)의 위치에 연산자가 아닌 값이 입력되었습니다.");
            throw new IllegalArgumentException("연산자(+,-,*,/)의 위치에 연산자가 아닌 값이 입력되었습니다.");
        }
    }

    private boolean isOperator(String operator) {
        return Operator.isOperator(operator);
    }
}
