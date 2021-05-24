package lottoauto;

public class LottoTicket {
    private final LottoNumbers lottoNumbers;
    private HitCount hitCount;

    public LottoTicket() {
        this.lottoNumbers = new AutoStrategy().generateLottoNumbers();
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
