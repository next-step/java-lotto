/*
* 당첨 번호와 당첨수를 지니는 클래스
* */
package lotto;

import java.util.List;
import java.util.Objects;

public class Winning {

    private List<Integer> winningNumbers;
    private int threeMatch = 0;
    private int fourMatch = 0;
    private int fiveMatch = 0;
    private int sixMatch = 0;

    public Winning(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Winning winning = (Winning) o;
        return threeMatch == winning.threeMatch && fourMatch == winning.fourMatch && fiveMatch == winning.fiveMatch && sixMatch == winning.sixMatch && winningNumbers.containsAll(winning.winningNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningNumbers, threeMatch, fourMatch, fiveMatch, sixMatch);
    }
}
