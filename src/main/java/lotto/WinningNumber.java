package lotto;

import lotto.rule.*;
import lotto.type.SingleNumber;
import lotto.type.SixNumberComposition;
import lotto.type.WinningLevel;

import java.util.*;

/**
 * 당첨 번호입니다.
 * 당첨 번호는 중복되지 않은 6개의 숫자로 이루어집니다. 추후 보너스 번호가 추가될 수 있습니다.
 *
 */
public class WinningNumber {
    private SixNumberComposition numbers;

    private WinningNumber() {
    }

    /**
     * 주어진 번호로 당첨번호를 세팅합니다.
     *
     * @param numbers 당첨 번호
     *
     * @return 생성된 당첨 번호
     */
    public static WinningNumber of(List<Integer> numbers) {
        WinningNumber winningNumber = new WinningNumber();
        winningNumber.numbers = SixNumberComposition.ofByInt(numbers);

        return winningNumber;
    }

    /**
     * 주어진 로또에 이 당첨번호를 적용했을 때 몇 등인지 계산합니다.
     *
     * @param lotto 로또 용지
     *
     * @return 이 로또의 당첨 등수
     */
    public WinningLevel whatRank(Lotto lotto) {
        List<WinningRule> rules = List.of(
                FirstRule.getInstance(),
                ThirdRule.getInstance(),
                FourthRule.getInstance(),
                FifthRule.getInstance()
        );

        for (WinningRule rule : rules) {
            //TODO: 이 if문을 빼버리고 for문 하나로 이를 처리할 수 있을까요??
            if (rule.isMatched(lotto, this)) {
                return rule.getRank();
            }
        }

        return WinningLevel.NONE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        WinningNumber that = (WinningNumber) o;

        return Objects.equals(numbers, that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    @Override
    public String toString() {
        return "WinningNumber{" +
                "numbers=" + numbers +
                '}';
    }

    /**
     * 이 타입과 호환되지 않는 곳에서 사용하기 위하여 리스트로 변환합니다.
     */
    public List<SingleNumber> toList() {
        return List.copyOf(this.numbers.toList());
    }
}