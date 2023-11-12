package me.namuhuchutong.lotto.ui;


import me.namuhuchutong.lotto.domain.Number;
import me.namuhuchutong.lotto.domain.Numbers;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {

    private static final String NOT_NUMBER_REGEX = "^[,\\s\\d]+$";
    private static final String INPUT_NUMBER_REGEX = ", ";

    private final Scanner scanner = new Scanner(System.in);

    public int showBuyPrompt() {
        printMessage("금액을 입력하세요.");
        return inputIntegerFromStandardOut();
    }

    private int inputIntegerFromStandardOut() {
        int amount = 0;
        try {
            amount = scanner.nextInt();
            cleanBuffer();
        } catch (InputMismatchException exception) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }
        validateAmount(amount);
        return amount;
    }

    private void cleanBuffer() {
        scanner.nextLine();
    }

    private void validateAmount(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("금액은 0원 혹은 음수일 수 없습니다.");
        }
    }

    public Numbers showNumbersPrompt() {
        printMessage("지난 주 당첨 번호를 입력하세요.");
        return inputStringFromStandardInput();
    }

    private Numbers inputStringFromStandardInput() {
        String[] split = inputAndTrim();
        List<Number> collect = Stream.of(split)
                                     .map(character -> new Number(Integer.parseInt(character)))
                                     .collect(Collectors.toUnmodifiableList());
        return new Numbers(collect);
    }

    private String[] inputAndTrim() {
        String input = scanner.nextLine();
        validateNotNumber(input);
        return input.split(INPUT_NUMBER_REGEX);
    }

    private void validateNotNumber(String input) {
        String[] split = input.split(NOT_NUMBER_REGEX);
        if (split.length != 0) {
            throw new IllegalArgumentException("로또 번호만 입력할 수 있습니다.");
        }
    }

    private void printMessage(String message) {
        System.out.println(message);
    }
}
