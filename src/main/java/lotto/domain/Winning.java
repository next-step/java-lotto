/*
 * 당첨 번호와 당첨수를 지니는 클래스
 * */
package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class Winning {

    public static final int MAX_MATCH_NUM = 6;
    public static final int MINIMUM_MATCH = 3;

    private List<LottoNumber> winningNumbers;
    private int[] match = new int[MAX_MATCH_NUM+1];  //당첨 개수를 확인하는 array, matchArr[2]은 2개 당첨개수를 뜻한다.

    public Winning(List<LottoNumber> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    /*
    * 테스트를 위한 생성자
    * */
    public Winning(List<LottoNumber> winningNumbers, int[] match) {
        this.winningNumbers = winningNumbers;
        this.match = match;
    }

    /*
    * 당첨된 수만큼 해당 당첨개수를 하나 증가시킨다.
    * */
    public void matches(int matchNum) {
        match[matchNum]++;
    }

    /*
    * 구매한 금액을 인자로 받아 당첨금액/구매금액 수익률을 계산한다.
    * */
    public double yield(int buyNum) {
        Long winningMoney = Price.calculate(match);
        Long buyMoney = buyNum * 1000L;
        return winningMoney / buyMoney;
    }

    /*
    * 당첨번호를 확인하기 위한 getter 메소드. 불변객체로 반환한다.
    * */
    public List<LottoNumber> getWinningNumbers() {
        return Collections.unmodifiableList(winningNumbers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Winning winning = (Winning) o;
        return winningNumbers.containsAll(winning.winningNumbers) && Arrays.equals(match, winning.match);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(winningNumbers);
        result = 31 * result + Arrays.hashCode(match);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        IntStream.range(0, match.length)
                .filter(i -> i >= MINIMUM_MATCH)
                .forEach(i -> {
                    sb.append(i + "개 일치 (" + Price.winningPrice(i) + "원) - " + match[i] + "개");
                    sb.append((System.getProperty("line.separator")));
                });
        return sb.toString();
    }
}
