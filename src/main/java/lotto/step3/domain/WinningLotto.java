package lotto.step3.domain;

import java.util.List;
import java.util.Objects;

public class WinningLotto {

    private final Lotto winningNumbers;
    private final LottoNumber bonusBall;

    public WinningLotto(List<Integer> winningNumbers, int bonusBall) {
        this.winningNumbers = new Lotto(winningNumbers);
        this.bonusBall = LottoNumber.of(bonusBall);
        if (winningNumbers.contains(bonusBall)) {
            throw new IllegalArgumentException("당첨번호 외에 보너스볼을 입력해주세요");
        }
    }

    public Lotto getWinningNumbers() {
        return winningNumbers;
    }

    public LottoNumber getBonusBall() {
        return bonusBall;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningLotto that = (WinningLotto) o;
        return Objects.equals(winningNumbers, that.winningNumbers) && Objects.equals(bonusBall, that.bonusBall);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningNumbers, bonusBall);
    }

    @Override
    public String toString() {
        return "WinningLotto{" +
                "winningNumbers=" + winningNumbers +
                ", bonusBall=" + bonusBall +
                '}';
    }

}
