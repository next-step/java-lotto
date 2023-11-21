package StringCalculator;

import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Pattern;

public class InputView {
    private static final Pattern NUMBER_PATTERN = Pattern.compile("\\d+");
    public static final int MIN_INPUT_VALUE_COUNT = 3;

    public static String[] inputCalculation() {
        System.out.println("계산할 식을 입력하세요");
        Scanner scanner = new Scanner(System.in);
        String rawCalculation = scanner.nextLine();

        String[] calculationValues = rawCalculation.split(" ");

        validateBlank(rawCalculation);
        validateMinSize(calculationValues);
        validateForm(calculationValues);

        return calculationValues;
    }

    private static void validateBlank(String value) {
        if (Objects.isNull(value)) {
            throw new IllegalArgumentException("공백은 입력할 수 없습니다.");
        }
        if (value.isBlank()) {
            throw new IllegalArgumentException("공백은 입력할 수 없습니다.");
        }
    }

    private static void validateMinSize(String[] calculationValues) {
        if (calculationValues.length < MIN_INPUT_VALUE_COUNT) {
            throw new IllegalArgumentException("숫자와 연산자가 1개이상 포함되게 입력해야합니다");
        }
    }

    private static void validateForm(String[] values) {
        for (int index = 0; index < values.length; index += 2) {
            validateNumber(values[index]);
        }
    }

    private static void validateNumber(String value) {
        if (!isNumber(value)) {
            throw new IllegalArgumentException("숫자를 입력해주세요");
        }
    }

    private static boolean isNumber(String value) {
        return NUMBER_PATTERN.matcher(value).matches();
    }

}