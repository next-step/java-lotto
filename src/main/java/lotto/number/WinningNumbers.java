package lotto.number;

import java.util.Objects;

public class WinningNumbers {
    private final LottoBalls winNumbers;
    private final LottoNumber bonusNumber;

    public WinningNumbers(LottoBalls lottoBalls, LottoNumber bonusNumber) {
        if (lottoBalls.match(bonusNumber)) {
            throw new IllegalArgumentException("보너스 숫자는 당첨 숫자에 포함된 수를 사용할 수 없습니다.");
        }
        this.winNumbers = lottoBalls;
        this.bonusNumber = bonusNumber;
    }

    public int countMatchedNumber(LottoBalls otherBalls) {
        return otherBalls.countMatchedNumber(winNumbers);
    }

    public boolean isBonusNumberMatched(LottoBalls otherBalls) {
        return otherBalls.match(bonusNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningNumbers that = (WinningNumbers) o;
        return Objects.equals(winNumbers, that.winNumbers) && Objects.equals(bonusNumber, that.bonusNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winNumbers, bonusNumber);
    }
}
