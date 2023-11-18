package lotto;

import lotto.type.SingleNumber;
import lotto.type.SixNumberComposition;

import java.util.*;

/**
 * 당첨 번호입니다.
 * 당첨 번호는 중복되지 않은 6개의 숫자와 보너스 번호 1개로 이루어집니다.
 * 불변 객체입니다.
 */
public class WinningNumber {
    private final SixNumberComposition winningNumbers;
    private final SingleNumber bonusNumber;

    private WinningNumber(SixNumberComposition winningNumbers, SingleNumber bonusNumber) {
        checkDuplication(winningNumbers, bonusNumber);

        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    /**
     * 보너스 번호가 이미 winningNumber에 있는지 확인합니다.
     * 없다면 유효성 검사를 통과합니다.
     *
     * @param winningNumbers 당첨 번호
     * @param bonusNumber 보너스 당첨 번호
     */
    private void checkDuplication(SixNumberComposition winningNumbers, SingleNumber bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 당첨 번호 " + bonusNumber + "가 당첨 번호 목록" + winningNumbers + "에 이미 있습니다.");
        }
    }

    /**
     * 주어진 번호로 당첨번호를 세팅합니다.
     *
     * @param winningNumbers 당첨 번호
     * @param bonusNumber 보너스 당첨 번호
     *
     * @return 생성된 당첨 번호
     */
    public static WinningNumber of(List<Integer> winningNumbers, int bonusNumber) {
        return new WinningNumber(
                SixNumberComposition.ofByInt(winningNumbers),
                SingleNumber.of(bonusNumber)
        );
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

        if (!Objects.equals(winningNumbers, that.winningNumbers)) {
            return false;
        }

        return Objects.equals(bonusNumber, that.bonusNumber);
    }

    @Override
    public int hashCode() {
        int result = winningNumbers != null ? winningNumbers.hashCode() : 0;
        result = 31 * result + (bonusNumber != null ? bonusNumber.hashCode() : 0);
        return result;
    }

    /**
     * 당첨 번호 목록을 반환합니다. 보너스 번호는 포함하지 않습니다.
     * 같은 패키지 간 연산을 위한 default getter 메서드.
     */
    List<SingleNumber> getWinningNumbers() {
        return List.copyOf(this.winningNumbers.toList());
    }

    /**
     * 보너스 번호를 반환합니다.
     * 같은 패키지 간 연산을 위한 default getter 메서드
     */
    SingleNumber getBonusNumber() {
        return this.bonusNumber;
    }
}