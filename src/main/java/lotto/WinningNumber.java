package lotto;

import lotto.type.WinningLevel;

import java.util.*;

/**
 * 당첨 번호입니다.
 * 당첨 번호는 중복되지 않은 6개의 숫자로 이루어집니다. 추후 보너스 번호가 추가될 수 있습니다.
 *
 */
public class WinningNumber {
    /** 당첨 번호가 몇 개의 번호로 구성되는지를 나타냅니다. */
    private static final int WINNING_NUMBER_COUNT = 6;

    List<Integer> numberList = new ArrayList<>(WINNING_NUMBER_COUNT);

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
        if (numberList.size() != WINNING_NUMBER_COUNT) {
            throw new IllegalArgumentException("주어진 숫자가 "+WINNING_NUMBER_COUNT+"개가 아니라 " + numberList.size() + "개입니다.");
        }

        WinningNumber winningNumber = new WinningNumber();
        winningNumber.numberList.addAll(numberList);
        winningNumber.numberList.sort(Comparator.naturalOrder());

        winningNumber.validateLottoNumbers();

        return winningNumber;
    }

    /**
     * 로또 번호 유효성 체크.
     * 문제가 없다면 통과되고, 문제가 있다면 예외가 던져집니다.
     */
    private void validateLottoNumbers() {
        for (int i = 0; i < WINNING_NUMBER_COUNT; i++) {
            if (numberList.get(i) < 1) {
                throw new IllegalArgumentException("주어진 당첨 번호는 " + numberList.get(i) + "로 1 미만입니다.");
            }

            if (numberList.get(i) > 45) {
                throw new IllegalArgumentException("주어진 당첨 번호는 " + numberList.get(i) + "로 45 초과입니다.");
            }
        }
    }

    /**
     * 주어진 로또에 이 당첨번호를 적용했을 때 몇 등인지 계산합니다.
     *
     * @param lotto 로또 용지
     *
     * @return 이 로또의 당첨 등수
     */
    public WinningLevel whatRank(Lotto lotto) {
        final int matchCount = lotto.howManyContain(this.numberList);

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

        return Objects.equals(numberList, that.numberList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberList);
    }

    @Override
    public String toString() {
        return "WinningNumber{" +
                "numbers=" + numberList +
                '}';
    }
}