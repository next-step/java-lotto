package step2.view;

import step2.ViewUtils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final String MONEY_INPUT_INFORMATION = "구매금액을 입력해 주세요.";
    private static final String MANUAL_LOTTO_COUNT_INFORMATION = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String MANUAL_LOTTO_NUMBER_INFORMATION = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String WINNING_NUMBER_INPUT_INFORMATION = "지난 주 당첨 번호를 입력해주세요";
    private static final String BONUS_NUMBER_INPUT_INFORMATION = "보너스 볼을 입력해 주세요";
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

    public int getManualLottoCount() {
        viewUtils.printLine(MANUAL_LOTTO_COUNT_INFORMATION);
        return viewUtils.readLineToInt();
    }

    public List<List<Integer>> getManualLottos(int manualLottoCount) {
        viewUtils.printLine(MANUAL_LOTTO_NUMBER_INFORMATION);
        List<String> inputTexts = new ArrayList<>();

        for(int i = 0; i < manualLottoCount; i++) {
            inputTexts.add(viewUtils.readLine());
        }
        return convertInputTextToLottos(inputTexts);
    }

    private List<List<Integer>> convertInputTextToLottos(List<String> inputTexts) {
        List<List<Integer>> manualLottos = new ArrayList<>();

        for(String inputText : inputTexts) {
            manualLottos.add(convertStringToNumbers(inputText));
        }
        return manualLottos;
    }

    private List<Integer> convertStringToNumbers(String inputText) {
        String[] stringNumbers = splitNumber(inputText);

        return Arrays.stream(stringNumbers)
                .map(Integer::valueOf)
                .collect(Collectors.toList());
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

    public int getBonusNumber() {
        try {
            return Integer.parseInt(getBonusNumberText());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(LOTTO_NUMBER_NOT_INTEGER_ERROR);
        }
    }

    private String getBonusNumberText() {
        viewUtils.printLine(BONUS_NUMBER_INPUT_INFORMATION);
        return viewUtils.readLine();
    }

    public static InputView getInstance() {
        return new InputView();
    }
}
