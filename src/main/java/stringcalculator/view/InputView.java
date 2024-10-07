package stringcalculator.view;

import stringcalculator.exception.StringCalculatorIllegalArgumentException;
import stringcalculator.util.StringUtil;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String SPACE_DELIMITER = " ";

    private final Scanner scanner = new Scanner(System.in);

    public List<String> getInputsFromUser() {
        System.out.println("값을 입력하세요. ex) 1 + 2 * 3 / 3");

        String inputLine = scanner.nextLine();

        if (StringUtil.isBlank(inputLine)) {
            throw new StringCalculatorIllegalArgumentException("입력값이 비어있습니다.");
        }

        return splitBySpace(inputLine);

    }

    private List<String> splitBySpace(String text) {
        return Arrays.stream(text.split(SPACE_DELIMITER))
                .map(String::trim)
                .collect(Collectors.toUnmodifiableList());
    }
}
