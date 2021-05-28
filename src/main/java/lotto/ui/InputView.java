package lotto.ui;

import calculator.SplitUtil;
import lotto.exception.CustomIllegalArgumentException;
import lotto.domain.Message;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputView {

    private final Pattern VALID_NUMBER_PATTERN = Pattern.compile("^[0-9]+$");

    private Scanner scanner;
    private OutputView outputView;

    public InputView() {
        this.scanner = new Scanner(System.in);
        this.outputView = new OutputView();
    }

    public int receiveIntegerInput() {
        String input = "";
        boolean stopReceivingInput = false;
        while (!stopReceivingInput) {
            input = scanner.nextLine();
            stopReceivingInput = isValidInteger(input);
        }
        return Integer.parseInt(input);
    }

    private boolean isValidInteger(String input) {
        boolean stopReceivingInput;
        try {
            stopReceivingInput = isNotNull(input) && isPositiveInteger(input);
        } catch (Exception e) {
            stopReceivingInput = false;
            outputView.printExceptionMessage(e);
        }
        return stopReceivingInput;
    }

    private boolean isNotNull(String input) throws CustomIllegalArgumentException {
        if (input == null || input.length() == 0) {
            throw new CustomIllegalArgumentException(Message.ERROR_EMPTY_INPUT);
        }
        return true;
    }

    private boolean isPositiveInteger(String input) throws CustomIllegalArgumentException {
        Matcher numberMatcher = VALID_NUMBER_PATTERN.matcher(input);
        if (!numberMatcher.find()) {
            throw new CustomIllegalArgumentException(Message.ERROR_NON_POSITIVE_NUMBER);
        }
        return true;
    }

    public Integer[] receiveIntegerArrayInput() {
        String input = "";
        String[] inputs;
        boolean stopReceivingInput = false;
        while (!stopReceivingInput) {
            input = scanner.nextLine();
            stopReceivingInput = isNotNull(input) && isValidIntegerArray(input);
        }
        inputs = SplitUtil.splitByDelimiter(input);
        return convertStringArrayToIntegerArray(inputs);
    }

    private Integer[] convertStringArrayToIntegerArray(String[] input) {
        int inputLength = input.length;
        Integer[] result = new Integer[inputLength];
        for (int i = 0; i < inputLength; i++) {
            result[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(result);
        return result;
    }

    private boolean isValidIntegerArray(String input) {
        boolean stopReceivingInput = false;
        try {
            String[] inputs = SplitUtil.splitByDelimiter(input);
            stopReceivingInput = areAllValidIntegers(inputs);
        } catch (Exception e) {
            outputView.printExceptionMessage(e);
        }
        return stopReceivingInput;
    }

    private boolean areAllValidIntegers(String[] inputs) throws IllegalArgumentException {
        for (String input : inputs) {
            isPositiveInteger(input);
        }
        return true;
    }
}
