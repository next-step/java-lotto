/*
 * WinningChecker.java
 *
 * v0.1 ,  2021.08.14
 */

package edu.nextstep.lottoauto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningChecker {

    private static final Map<Integer, WinningPrize> WINNING_MAP = new HashMap<>();

    private final List<Integer> winningNumbers;

    static {
        WINNING_MAP.put(3, WinningPrize.THREE);
        WINNING_MAP.put(4, WinningPrize.FOUR);
        WINNING_MAP.put(5, WinningPrize.FIVE);
        WINNING_MAP.put(6, WinningPrize.SIX);
    }

    private WinningChecker(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }


    public static WinningChecker createOf(int[] winningNumbersArr) {
        List<Integer> winningNumbers = new ArrayList<>();
        for (int winningNumber : winningNumbersArr) {
            winningNumbers.add(winningNumber);
        }
        return new WinningChecker(winningNumbers);
    }

    public Map<WinningPrize, Integer> winningCheck(List<List<Integer>> lottoTickets) {
        Map<WinningPrize, Integer> winningCheckResult = new HashMap<>();
        for (List<Integer> lottoTicket : lottoTickets) {
            int count = 0;

            for (Integer winningNumber : winningNumbers) {
                if (lottoTicket.contains(winningNumber)) {
                    count++;
                }
            }

            if (count >= 3) {
                int winningCheckResultValue = winningCheckResult.getOrDefault(WINNING_MAP.get(count), 0) + 1;
                winningCheckResult.put(WINNING_MAP.get(count), winningCheckResultValue);
            }
        }
        return winningCheckResult;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }
}
