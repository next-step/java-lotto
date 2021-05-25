package lottoauto;

public class LottoTicket {
    private final LottoNumbers lottoNumbers;
    private HitCount hitCount;
    private boolean isMatchedBonus;

    public LottoTicket(LottoGenerateStrategy lottoGenerateStrategy) {
        this.lottoNumbers = lottoGenerateStrategy.generateLottoNumbers();
    }

    public LottoTicket(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public HitCount hitCount() {
        return hitCount;
    }

    public boolean isMatchedBonus() {
        return isMatchedBonus;
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }

    public void calcHitCount(WinningNumbersWithBonus winningNumbersWithBonus) {
        hitCount = lottoNumbers.checkHitCount(winningNumbersWithBonus);
        isMatchedBonus = lottoNumbers.checkHitBonus(winningNumbersWithBonus);
    }
}
