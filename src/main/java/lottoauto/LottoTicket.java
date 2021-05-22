package lottoauto;

import java.util.List;

public class LottoTicket {
    private final LottoNumbers lottoNumbers;
    private final HitCount hitCount = new HitCount();

    public LottoTicket() {
        this.lottoNumbers = new LottoNumbers();
    }

    public LottoTicket(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public HitCount hitCount() {
        return hitCount;
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }

    public void checkWinning(List<Integer> winningNumber) {
        for(int number: winningNumber) {
            hitCount.accumulate(lottoNumbers.containNumber(number));
        }
    }
}
