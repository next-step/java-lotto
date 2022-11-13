package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WinningNumber {

    private List<Integer> winningNumber;

    public WinningNumber(Integer[] winningNumber) {
        this(Arrays.asList(winningNumber));
    }

    WinningNumber(List<Integer> winningNumber) {
        this.winningNumber = winningNumber;
    }

    public boolean same(List<Integer> numbersList) {
        return this.winningNumber.equals(numbersList);
    }

    public int countWinning(List<Integer> tryLotto) {
       return (int) tryLotto.stream()
               .filter(n -> winningNumber.contains(n))
               .count();
    }

}
