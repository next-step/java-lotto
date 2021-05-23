package lotto.ui;

import calculator.SplitUtil;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputView {

    private final Pattern VALID_NUMBER_PATTERN = Pattern.compile("^-?[0-9]+$");
    private final String ERROR_NON_NUMBER = "숫자만 입력해주세요.";
    private final String ERROR_NON_POSITIVE_NUMBER = "0을 초과하는 숫자를 입력해주세요.";
    private final String ERROR_EMPTY_INPUT = "빈 값이 입력되었습니다. 다시 입력해주세요.";

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
            stopReceivingInput = checkNotNull(input)
                    && checkIsNumber(input)
                    && checkPositiveNumber(input);
        } catch (IllegalArgumentException e) {
            outputView.printExceptionMessage(e);
        }
        return stopReceivingInput;
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
            stopReceivingInput = checkAllValidNumbers(inputs);
        } catch (IllegalArgumentException e) {
            outputView.printExceptionMessage(e);
        }
        return stopReceivingInput;
    }

    private boolean checkAllValidNumbers(String[] inputs) throws IllegalArgumentException {
        for (String input : inputs) {
            checkIsNumber(input);
            checkPositiveNumber(input);
        }
        return true;
    }
}
