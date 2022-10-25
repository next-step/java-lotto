package step2.domain;

public class BonusLottoNumber extends LottoNumber {

    public BonusLottoNumber(int bonusLottoNumber, LottoPaper winLottoPaper) {
        super(bonusLottoNumber);
        validateDuplicateWinLottoPaper(winLottoPaper);
    }

    private void validateDuplicateWinLottoPaper(LottoPaper winLottoPaper) {
        if (winLottoPaper.isInclude(this)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 같을 수 없습니다. 당첨번호: " + winLottoPaper + " |입력한 보너스 번호: " + lottoNumber);
        }
    }

    @Override
    public String toString() {
        return Integer.toString(this.lottoNumber);
    }
}
