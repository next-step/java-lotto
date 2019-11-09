package com.lotto.model;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto {

    public static final String INPUT_WRONG_WINNING_NUMBER = "잘못 된 당첨번호 입력 입니다.";

    private List<Integer> winningNumbers = new ArrayList<>();

    public void inputWinningNumber(int winningNumber) {
        if(winningNumbers.size() > 6) {
            throw new IllegalArgumentException(INPUT_WRONG_WINNING_NUMBER);
        }
        winningNumbers.add(winningNumber);
    }
}
