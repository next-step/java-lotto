package step2.domain;

import java.util.List;

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

        if (this.hitCount < 2) {
            this.prize = this.hitCount % 6 + 1;
        }
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }
}
