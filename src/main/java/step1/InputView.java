package step1;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public static boolean isValidInputFormat(String input) {
        if (input == null || input.isBlank() || input.trim().isEmpty()) {
            throw new IllegalArgumentException("계산식을 입력해 주세요.(e.g.2 + 3 * 4 / 2)");
        }
        if (!input.matches("^[0-9]+( [\\+\\-\\*/] [0-9]+)*$")) {
            throw new IllegalArgumentException("제대로 된 형식으로 입력해 주세요.(e.g.2 + 3 * 4 / 2)");
        }
        return true;
    }

}
