/*
 * 당첨 번호와 당첨수를 지니는 클래스
 * */
package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Winning {
    public static final int THREE_MATCH_PRICE = 5000;
    public static final int FOUR_MATCH_PRICE = 50000;
    public static final int FIVE_MATCH_PRICE = 1500000;
    public static final int SIX_MATCH_PRICE = 2000000000;

    public static final int THREE_MATCH = 3;
    public static final int FOUR_MATCH = 4;
    public static final int FIVE_MATCH = 5;
    public static final int SIX_MATCH = 6;
    public static final int MAX_MATCH_NUM = 6;

    private List<Integer> winningNumbers;
    private int[] matchArr = new int[MAX_MATCH_NUM+1];

    public Winning(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    /*
    * 테스트를 위한 생성자
    * */
    public Winning(List<Integer> winningNumbers, int[] matchArr) {
        this.winningNumbers = winningNumbers;
        this.matchArr = matchArr;
    }

    public void matches(int matchNum) {
        matchArr[matchNum]++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Winning winning = (Winning) o;
        return winningNumbers.containsAll(winning.winningNumbers) && Arrays.equals(matchArr, winning.matchArr);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(winningNumbers);
        result = 31 * result + Arrays.hashCode(matchArr);
        return result;
    }
}
