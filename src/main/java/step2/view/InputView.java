package step2.view;

import step2.ViewUtils;

public class InputView {
    private static final String MONEY_INPUT_INFORMATION = "구매금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_INPUT_INFORMATION = "지난 주 당첨 번호를 입력해주세요";

    private final ViewUtils viewUtils;

    public InputView() {
        viewUtils = new ViewUtils();
    }

    public int getMoney() {
        viewUtils.printLine(MONEY_INPUT_INFORMATION);
        return viewUtils.readLineToInt();
    }

    public String getWinningNumber() {
        viewUtils.printLine(WINNING_NUMBER_INPUT_INFORMATION);
        return viewUtils.readLine();
    }

    public static InputView getInstance() {
        return new InputView();
    }
}
