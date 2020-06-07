package step2.domain;

import java.util.List;
import java.util.Objects;

public class UserLotto extends Lotto {

    private int hitCount;
    private int prize;
    private boolean isMatchedBonus;

    public UserLotto(List<Integer> lottoNumbers) {
        super(lottoNumbers);
        this.hitCount = 0;
        this.prize = 0;
        this.isMatchedBonus = false;
    }

    private void drawLotto(List<Integer> winningNumbers, int bonusNumber) {
        winningNumbers.stream().forEach(number -> findHit(number, bonusNumber));
    }

    private void findHit(Integer winningNumber, int bonusNumber) {
        if (getLottoNumbers().contains(winningNumber)) {
            this.hitCount++;
        }

        if (getLottoNumbers().contains(bonusNumber)) {
            isMatchedBonus = true;
        }
    }

    public int getPrize() {
        return prize;
    }

    public void setPrize(List<Integer> winningNumbers, int bonusNumber) {

        drawLotto(winningNumbers, bonusNumber);

        prize = Prize.valueOf(hitCount, isMatchedBonus).getGrade();
    }

    public long getCashPrice() {
        return Prize.getCashPrize(prize);
    }

    @Override
    public String toString() {
        return "UserLotto{" +
            "hitCount=" + hitCount +
            ", prize=" + prize +
            ", isMatchedBonus=" + isMatchedBonus +
            '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLottoNumbers());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserLotto lotto = (UserLotto) o;
        return Objects.equals(getLottoNumbers(), lotto.getLottoNumbers());
    }
}
