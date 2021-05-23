package lottoauto;

import java.util.List;

public class LottoTicket {
    private final LottoNumbers lottoNumbers;
    private HitCount hitCount;

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


    public void calcHitCount(LottoNumbers winningNumbers) {
        hitCount = lottoNumbers.checkHitCount(winningNumbers);
    }
}
