package step2.domain;

import static step2.domain.LottoGenerator.LOTTO_SELECTION_COUNT;

import java.util.List;
import java.util.Objects;

public class Lotto extends AbstractLotto {

    private int hitCount;
    private int prize;

    public Lotto(List<Integer> lottoNumbers) {
        super.setLottoNumbers(lottoNumbers);
        this.hitCount = 0;
        this.prize = 0;
    }

    private void drawLotto(List<Integer> winningNumbers) {
        winningNumbers.stream().forEach(this::findHit);
    }

    private void findHit(Integer winningNumber) {
        if (getLottoNumbers().contains(winningNumber)) {
            this.hitCount++;
        }
    }

    public int getPrize() {
        return prize;
    }

    public void setPrize(List<Integer> winningNumbers) {

        drawLotto(winningNumbers);

        if (hitCount >= Prize.FORTH.getHitCount()) {
            prize = hitCount % LOTTO_SELECTION_COUNT + 1;
        }
    }

    public int getCashPrice() {
        return Prize.getCashPrize(prize);
    }

    @Override
    public String toString() {
        return "Lotto{" +
            "lottoNumbers=" + getLottoNumbers() +
            ", hitCount=" + hitCount +
            ", prize=" + prize +
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
        Lotto lotto = (Lotto) o;
        return Objects.equals(getLottoNumbers(), lotto.getLottoNumbers());
    }
}
