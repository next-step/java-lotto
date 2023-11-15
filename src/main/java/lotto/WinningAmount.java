package lotto;

import lotto.type.WinningLevel;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 로또 당첨금액을 의미합니다.
 * 불변 객체입니다.
 */
public class WinningAmount {
    private final int winningAmount;

    private WinningAmount(int winningAmount) {
        this.winningAmount = winningAmount;
    }

    public static WinningAmount of(int winningAmount) {
        if (winningAmount < 0) {
            throw new IllegalArgumentException("당첨 금액은 0보다 작을 수 없으나 " + winningAmount + "이 주어졌습니다.");
        }

        return new WinningAmount(winningAmount);
    }

    public static WinningAmount zero() {
        return WinningAmount.of(0);
    }

    /**
     * 두 당첨금을 더해 새 당첨금을 생성합니다.
     * 기존 객체를 수정하지 않고 새 객체를 반환합니다.
     *
     * @param operand 더할 당첨금
     *
     * @return 새 당첨금.
     */
    public WinningAmount add(WinningAmount operand) {
        return WinningAmount.of(this.winningAmount + operand.winningAmount);
    }

    /**
     * 당첨금을 주어진 크기만큼 정수배 합니다.
     * 기존 객체를 수정하지 않고 새 객체를 반환합니다.
     *
     * @param coefficient 얼만큼 정수배 시킬 것인지
     *
     * @return 새 당첨금.
     */
    public WinningAmount multiply(int coefficient) {
        return WinningAmount.of(this.winningAmount * coefficient);
    }

    @Override
    public String toString() {
        return "" + winningAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        WinningAmount that = (WinningAmount) o;
        return winningAmount == that.winningAmount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningAmount);
    }

    /**
     * 이 객체와 호환되지 않는 곳에서 값을 사용하기 위하여 int로 변환합니다.
     * 가능하면 호출하지 마십시오.
     *
     * @return 정수값
     */
    public int toInt() {
        return this.winningAmount;
    }
}
