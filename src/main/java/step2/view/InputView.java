package step2.view;

import step2.ViewUtils;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    private static final String MONEY_INPUT_INFORMATION = "구매금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_INPUT_INFORMATION = "지난 주 당첨 번호를 입력해주세요";
    private static final String LOTTO_NUMBER_NOT_INTEGER_ERROR = "숫자만 입력해주세요";
    private static final String COMMA = ",";

    private final ViewUtils viewUtils;

    public InputView() {
        viewUtils = new ViewUtils();
    }

    public int getMoney() {
        viewUtils.printLine(MONEY_INPUT_INFORMATION);
        return viewUtils.readLineToInt();
    }

    public List<Integer> getWinningNumbers() {
        String inputText = getWinningNumbersText();
        List<Integer> winningNumbers = new ArrayList<>();
        String[] stringNumbers = splitNumber(inputText);

        try {
            addIntegerNumbers(stringNumbers, winningNumbers);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(LOTTO_NUMBER_NOT_INTEGER_ERROR);
        }
        return winningNumbers;
    }

    private void addIntegerNumbers(String[] stringNumbers, List<Integer> winningNumbers) {
        for(int i = 0; i < stringNumbers.length; i++) {
            winningNumbers.add(Integer.parseInt(stringNumbers[i]));
        }
    }


    private String[] splitNumber(String inputText) {
        return inputText.split(COMMA);
    }

    private String getWinningNumbersText() {
        viewUtils.printLine(WINNING_NUMBER_INPUT_INFORMATION);
        return viewUtils.readLine();
    }

    public static InputView getInstance() {
        return new InputView();
    }
}
