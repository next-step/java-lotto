package step2.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_LOTTO_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String COMMA = ",";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요.";

    public int getMoney() {
        ViewUtils.printLine(INPUT_MONEY_MESSAGE);

        return ViewUtils.nextInt();
    }

    public List<Integer> getWinningNumbers() {
        String winningNumberString = getWinningNumberString();
        String[] winningNumberArray = winningNumberString.split(COMMA);

        return Arrays.stream(winningNumberArray)
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }

    private String getWinningNumberString() {
        ViewUtils.printLine(INPUT_WINNING_LOTTO_MESSAGE);

        return ViewUtils.nextLine();
    }

    public int getBonusNumber() {
        ViewUtils.printLine(INPUT_BONUS_NUMBER_MESSAGE);

        return ViewUtils.nextInt();
    }
}
