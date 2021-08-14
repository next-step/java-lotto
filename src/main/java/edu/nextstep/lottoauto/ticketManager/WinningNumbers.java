/*
 * WinningNumbers.java
 *
 * v0.1   2021.08.15
 */

package edu.nextstep.lottoauto.ticketManager;

import java.util.*;

public class WinningNumbers {

    private final List<Integer> winningNumbers;

    private WinningNumbers(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public static WinningNumbers from(List<Integer> winningNumbers) {
        validateNumberOfNumbers(winningNumbers);
        validateOutOfRange(winningNumbers);
        validateSameNumber(winningNumbers);
        return new WinningNumbers(winningNumbers);
    }

    public static WinningNumbers from(String numbersOfString) {
        String[] numbersStringArr = numbersOfString.split(",");

        List<Integer> winningNumbers = new ArrayList<>();

        for(String numberString : numbersStringArr){
            winningNumbers.add(Integer.parseInt(numberString.trim()));
        }

        return WinningNumbers.from(winningNumbers);
    }

    private static void validateNumberOfNumbers(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("당첨 번호는 6개가 필요 합니다.");
        }
    }

    private static void validateOutOfRange(List<Integer> winningNumbers) {
        Collections.sort(winningNumbers);
        if (winningNumbers.get(0) < 1 || winningNumbers.get(5) > 45) {
            throw new IllegalArgumentException("당첨 번호는 1~45 의 범위 안에 있어야 합니다.");
        }
    }

    private static void validateSameNumber(List<Integer> winningNumbers) {
        Set<Integer> winningNumbersSet = new HashSet<>(winningNumbers);
        if (winningNumbersSet.size() < 6) {
            throw new IllegalArgumentException("당첨 번호는 중복되지 않아야 합니다.");
        }
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }
}
