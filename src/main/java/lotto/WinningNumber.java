package lotto;

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
     * @param numberList 당첨 번호
     *
     * @return 생성된 당첨 번호
     */
    public static WinningNumber of(List<Integer> numberList) {
        WinningNumber winningNumber = new WinningNumber();
        winningNumber.numbers = SixNumberComposition.of(numberList);

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
        final int matchCount = lotto.howManyContain(this.numbers.toList());

        if (matchCount < 3) {
            return WinningLevel.NONE;
        }

        if (matchCount == 3) {
            return WinningLevel.FIVE;
        }

        if (matchCount == 4) {
            return WinningLevel.FOUR;
        }

        if (matchCount == 5) {
            return WinningLevel.THREE;
        }

        if (matchCount == 6) {
            return WinningLevel.ONE;
        }

        throw new IllegalArgumentException("로또 용지가 당첨 번호와 매치되는 숫자는 6개를 넘을 수 없으나 알 수 없는 이유로 6개를 넘어 " + matchCount +"가 매치되었습니다." + lotto + this);
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
}