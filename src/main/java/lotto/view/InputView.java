package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final String PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WIN_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요.";
    private static final String ERROR_MESSAGE = "[ERROR] 숫자를 입력해주세요";

    private static final String SPLIT = ",";

    private final Scanner scanner = new Scanner(System.in);

    public final int getPayment() {
        try {
            return Integer.parseInt(getInputValue(PRICE_MESSAGE));
        } catch (NumberFormatException e) {
            throw new NumberFormatException(ERROR_MESSAGE);
        }
    }

    public final List<Integer> getWinningNumbers() {
        String[] winNumbers = getInputValue(WIN_NUMBER_MESSAGE).split(SPLIT);
        try {
            return Arrays.stream(winNumbers)
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new NumberFormatException(ERROR_MESSAGE);
        }
    }

    public final int getBonusNumber() {
        try {
            return Integer.parseInt(getInputValue(BONUS_NUMBER_MESSAGE));
        } catch (NumberFormatException e) {
            throw new NumberFormatException(ERROR_MESSAGE);
        }
    }

    private String getInputValue(String message) {
        System.out.println(message);
        return scanner.nextLine().trim();
    }
}
