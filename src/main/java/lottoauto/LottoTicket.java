package lottoauto;

import java.util.List;

public class LottoTicket {
    private final LottoNumbers lottoNumbers;
    private int hitCount = 0;

    public LottoTicket() {
        this.lottoNumbers = new LottoNumbers();
    }

    public LottoTicket(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public int hitCount() {
        return hitCount;
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }

    public void checkWinning(List<Integer> winningNumber) {
        for(int number: winningNumber) {
            hitCount += lottoNumbers.containNumber(number);
        }
    }
}
