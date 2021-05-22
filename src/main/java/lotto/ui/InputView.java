package lotto.ui;

import calculator.SplitUtil;
import lotto.ui.OutputView;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputView {

    private final Pattern VALID_NUMBER_PATTERN = Pattern.compile("^-?[0-9]+$");
    private final String ERROR_NON_NUMBER = "숫자만 입력해주세요.";
    private final String ERROR_NON_POSITIVE_NUMBER = "0을 초과하는 숫자를 입력해주세요.";
    private final String ERROR_NUMBER_OUT_OF_RANGE = "1과 45 사이의 숫자를 입력해주세요.";
    private final String ERROR_EMPTY_INPUT = "빈 값이 입력되었습니다. 다시 입력해주세요.";
    private final String ERROR_NUMBERS_COUNT_INVALID = "중복없이 알맞은 갯수의 번호를 입력해주세요 : ";
    public final String ERROR_AMOUNT_OUT_OF_RANGE = "1천원 이상, 10만원 이하의 금액을 입력해주세요.";

    private final int MINIMUM_PURCHASE_AMOUNT = 1000;
    private final int MAXIMUM_PURCHASE_AMOUNT = 100000;

    private final int LOTTO_NUMBER_MIN_VALUE = 1;
    private final int LOTTO_NUMBER_MAX_VALUE = 45;
    private final int NUMBER_COUNT = 6;

    private Scanner scanner;
    private OutputView outputView;

    public InputView() {
        this.scanner = new Scanner(System.in);
        this.outputView = new OutputView();
    }

    public int receivePurchaseAmount() {
        String input = "";
        boolean stopReceivingInput = false;
        while (!stopReceivingInput) {
            input = scanner.nextLine();
            stopReceivingInput = checkValidAmount(input);
        }
        return Integer.parseInt(input);
    }

    private boolean checkValidAmount(String input) {
        boolean stopReceivingInput = false;
        try {
            stopReceivingInput = checkNotNull(input) && checkIsNumber(input)
                    && checkPositiveNumber(input) && checkAmountRange(input);
        } catch (IllegalArgumentException e) {
            outputView.printExceptionMessage(e);
        }
        return stopReceivingInput;
    }

    private boolean checkAmountRange(String input) {
        int amount = Integer.parseInt(input);
        if (amount < MINIMUM_PURCHASE_AMOUNT
                || amount > MAXIMUM_PURCHASE_AMOUNT) {
            throw new IllegalArgumentException(ERROR_AMOUNT_OUT_OF_RANGE);
        }
        return true;
    }

    private boolean checkPositiveNumber(String input) throws IllegalArgumentException {
        if (Integer.parseInt(input) <= 0) {
            throw new IllegalArgumentException(ERROR_NON_POSITIVE_NUMBER);
        }
        return true;
    }

    private boolean checkIsNumber(String input) throws IllegalArgumentException {
        Matcher numberMatcher = VALID_NUMBER_PATTERN.matcher(input);
        if (!numberMatcher.find()) {
            throw new IllegalArgumentException(ERROR_NON_NUMBER);
        }
        return true;
    }

    private boolean checkNotNull(String input) throws IllegalArgumentException {
        if (input == null || input.length() == 0) {
            throw new IllegalArgumentException(ERROR_EMPTY_INPUT);
        }
        return true;
    }

    public int[] receiveWinningNumbers() {
        String input = "";
        String[] inputs;
        boolean stopReceivingInput = false;
        while (!stopReceivingInput) {
            input = scanner.nextLine();
            stopReceivingInput = checkValidLottoNumbers(input);
        }
        inputs = SplitUtil.splitByDelimiter(input);
        return convertStringArrayToIntArray(inputs);
    }

    private int[] convertStringArrayToIntArray(String[] input) {
        int inputLength = input.length;
        int[] result = new int[inputLength];
        for (int i = 0; i < inputLength; i++) {
            result[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(result);
        return result;
    }

    private boolean checkValidLottoNumbers(String input) {
        boolean stopReceivingInput = false;
        try {
            stopReceivingInput = checkNotNull(input);
        } catch (IllegalArgumentException e) {
            outputView.printExceptionMessage(e);
        }

        try {
            stopReceivingInput = false;
            String[] inputs = SplitUtil.splitByDelimiter(input);
            stopReceivingInput = checkAllValidNumbers(inputs) && checkCountOfNumbers(inputs);
        } catch (IllegalArgumentException e) {
            outputView.printExceptionMessage(e);
        }

        return stopReceivingInput;
    }

    private boolean checkAllValidNumbers(String[] inputs) throws IllegalArgumentException {
        for (String input : inputs) {
            checkIsNumber(input);
            checkPositiveNumber(input);
            checkNumberRange(input);
        }
        return true;
    }

    private void checkNumberRange(String input) {
        int number = Integer.parseInt(input);
        if (number < LOTTO_NUMBER_MIN_VALUE || number > LOTTO_NUMBER_MAX_VALUE) {
            throw new IllegalArgumentException(ERROR_NUMBER_OUT_OF_RANGE);
        }
    }

    private boolean checkCountOfNumbers(String[] inputs) throws IllegalArgumentException {
        HashSet<Integer> inputToSet = new HashSet<>();
        for (String input : inputs) {
            inputToSet.add(Integer.parseInt(input));
        }
        if (inputToSet.size() != NUMBER_COUNT) {
            throw new IllegalArgumentException(ERROR_NUMBERS_COUNT_INVALID + NUMBER_COUNT + "개");
        }
        return true;
    }
}
