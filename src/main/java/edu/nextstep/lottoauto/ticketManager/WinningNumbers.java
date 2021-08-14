/*
 * WinningNumbers.java
 *
 * v0.1   2021.08.15
 */

package edu.nextstep.lottoauto.ticketManager;

import java.util.ArrayList;
import java.util.List;

public class WinningNumbers {

    private final List<Integer> winningNumbers;

    private WinningNumbers(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public static WinningNumbers from(int[] numbers) {
        List<Integer> winningNumbers = new ArrayList<>();
        for (int number : numbers) {
            winningNumbers.add(number);
        }
        return new WinningNumbers(winningNumbers);
    }

    public static WinningNumbers from(String numbersOfString) {
        return null;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }
}
