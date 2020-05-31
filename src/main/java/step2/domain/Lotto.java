package step2.domain;

import static step2.domain.LottoGenerator.LOTTO_SELECTION_COUNT;

import java.util.List;
import java.util.Objects;

public class Lotto {

    private List<Integer> lottoNumbers;
    private int hitCount;
    private int prize;

    public Lotto(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
        this.hitCount = 0;
        this.prize = 0;
    }

    private void drawLotto(List<Integer> winningNumbers) {
        winningNumbers.stream().forEach(this::findHit);
    }

    private void findHit(Integer winningNumber) {
        if (this.lottoNumbers.contains(winningNumber)) {
            this.hitCount++;
        }
    }

    public int getPrize() {
        return prize;
    }

    public void setPrize(List<Integer> winningNumbers) {

        drawLotto(winningNumbers);

        if (this.hitCount >= 3) {
            this.prize = this.hitCount % LOTTO_SELECTION_COUNT + 1;
        }
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    public int getCashPrice() {
        return Prize.getCashPrize(this.prize);
    }

    @Override
    public String toString() {
        return "Lotto{" +
            "lottoNumbers=" + lottoNumbers +
            ", hitCount=" + hitCount +
            ", prize=" + prize +
            '}';
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
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
