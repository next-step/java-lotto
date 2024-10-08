package lotto;

import stringcalculator.exception.StringCalculatorIllegalArgumentException;
import stringcalculator.util.StringUtil;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final String COMMA_DELIMITER = ",";

    private final Scanner scanner = new Scanner(System.in);

    public int getAmountFromUser() {
        System.out.println("구매금액을 입력해 주세요.");

        String inputLine = scanner.nextLine();

        if (StringUtil.isBlank(inputLine)) {
            throw new StringCalculatorIllegalArgumentException("입력값이 비어있습니다.");
        }

        return Integer.parseInt(inputLine);
    }

    public List<Integer> getWinningNumbersFromUser() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        String inputLine = scanner.nextLine();

        if (StringUtil.isBlank(inputLine)) {
            throw new StringCalculatorIllegalArgumentException("입력값이 비어있습니다.");
        }
        return splitBySpace(inputLine);
    }

    private List<Integer> splitBySpace(String text) {
        return Arrays.stream(text.split(COMMA_DELIMITER))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toUnmodifiableList());
    }
}
