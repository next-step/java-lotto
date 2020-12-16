package step2.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_LOTTO_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String COMMA = ",";

    private final ViewUtils viewUtils;

    public InputView() {
        this.viewUtils = new ViewUtils();
    }

    public int getMoney() {
        viewUtils.printLine(INPUT_MONEY_MESSAGE);

        return viewUtils.nextInt();
    }

    public List<Integer> getWinningNumbers() {
        String winningNumberString = getWinningNumberString();
        String[] winningNumberArray = winningNumberString.split(COMMA);

        return Arrays.stream(winningNumberArray)
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }

    private String getWinningNumberString() {
        viewUtils.printLine(INPUT_WINNING_LOTTO_MESSAGE);

        return viewUtils.nextLine();
    }
}
