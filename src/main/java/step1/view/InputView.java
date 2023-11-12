package step1.view;

import java.util.Objects;
import java.util.Scanner;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);
    private static final String SPLIT_SEPARATOR = "\\s";

    public String[] input() {
        System.out.println("수행할 수식을 입력해주세요.");
        String inputValue = scanner.nextLine();
        return getExpression(inputValue);
    }

    public String[] getExpression(String inputValue) {
        if (Objects.isNull(inputValue) || inputValue.isBlank()) {
            throw new IllegalArgumentException("입력 값은 null 이거나 빈 공백 문자일 수 없습니다.");
        }
        return inputValue.trim().split(SPLIT_SEPARATOR);
    }
}
