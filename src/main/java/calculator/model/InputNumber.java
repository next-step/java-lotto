package calculator.model;

import java.util.List;

public class InputNumber {
    List<Integer> numbers;

    public InputNumber(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static void isInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("숫자로 변환할 수 없는 값입니다.");
        }
    }
}
