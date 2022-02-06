package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final String PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WIN_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요.";
    private static final int LOTTO_LENGTH = 6;
    private final Scanner scanner = new Scanner(System.in);

    private String getInputValue(String message) {
        System.out.println(message);
        return scanner.nextLine().trim();
    }

    public final int getTotalPrice() {
        try {
            return Integer.parseInt(getInputValue(PRICE_MESSAGE));
        } catch (NumberFormatException e) {
            throw new NumberFormatException("숫자를 입력해주세요");
        }
    }

    public final List<Integer> getWinNumbers() {
        String[] winNumbers = getInputValue(WIN_NUMBER_MESSAGE).split(",");
        if (winNumbers.length != LOTTO_LENGTH) {
            throw new IllegalArgumentException("숫자 6개를 입력해주세요");
        }
        try {
            return Arrays.stream(winNumbers)
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new NumberFormatException("숫자를 입력해주세요");
        }

    }

    public final int getBonusNumber() {
        try {
            return Integer.parseInt(getInputValue(BONUS_NUMBER_MESSAGE));
        } catch (NumberFormatException e) {
            throw new NumberFormatException("숫자를 입력해주세요");
        }
    }


}
