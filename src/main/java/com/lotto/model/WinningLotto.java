package com.lotto.model;

import java.util.*;

public class WinningLotto {

    private static final String WARNING_WINNING_NUMBER_COUNT = "당첨번호는 6개만 입력가능 합니다.";
    private static final String WARNING_WINNING_NUMBER_DUPLICATE = "이미 이력 된 당첨번호 입니다.";
    private static final String WARING_WRONG_INPUT_MESSAGE = "숫자만 입력 가능합니다.";
    private static final String DELIMITER_CHARACTER = ",";
    private static final int LOTTO_NUMBER_SIZE = 6;

    private final List<Integer> winningNumbers;

    public static WinningLotto ofComma(String inputStringNumbers) {
        String[] inputNumbers = inputStringNumbers.split(DELIMITER_CHARACTER);
        List<Integer> winningNumbers = new ArrayList<>();
        for (String inputNumber : inputNumbers) {
            winningNumbers.add(checkWinningNumber(inputNumber.trim()));
        }
        return new WinningLotto(winningNumbers);
    }

    private static int checkWinningNumber(String inputStringNumber) {
        try {
            return Integer.parseInt(inputStringNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(WinningLotto.WARING_WRONG_INPUT_MESSAGE, e);
        }
    }

    public WinningLotto(List<Integer> winningNumbers) {
        if (winningNumbers.size() > LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(WARNING_WINNING_NUMBER_COUNT);
        }

        if (isDuplicate(winningNumbers)) {
            throw new IllegalArgumentException(WARNING_WINNING_NUMBER_DUPLICATE);
        }

        this.winningNumbers = winningNumbers;
    }

    private boolean isDuplicate(List<Integer> winningNumbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(winningNumbers);
        return uniqueNumbers.size() != LOTTO_NUMBER_SIZE;
    }

    public int match(int userNumber) {
        return (winningNumbers.contains(userNumber)) ? 1 : 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningLotto that = (WinningLotto) o;
        return Objects.equals(winningNumbers, that.winningNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningNumbers);
    }
}
