/*
 * WinningChecker.java
 *
 * v0.1 ,  2021.08.14
 */

package edu.nextstep.lottoauto;

import java.util.List;
import java.util.Map;

public class WinningChecker {

    private final List<Integer> winningNumbers;

    public WinningChecker(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public static WinningChecker createOf(int[] winningNumbers) {
        return null;
    }

    public Map<Map<Integer, Integer>, Integer> winningCheck(List<List<Integer>> lottoTickets) {
        return null;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }
}
