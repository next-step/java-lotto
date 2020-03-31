package step2.domain;

public class WinningLotto {

    public static final String BONUS_NUMBER_DUPLICATION_ERROR = "보너스 번호는 다른 번호와 중복될 수 없습니다.";
    private Lotto lotto;
    private LottoNumber bonusNumber;

    public WinningLotto(Lotto lotto, LottoNumber bonusNumber) {
        validateBonusNumber(lotto, bonusNumber);

        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(Lotto lotto, LottoNumber bonusNumber) {
        if(lotto.contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATION_ERROR);
        }
    }

    public LottoTier getLottoTier(Lotto targetLotto) {
        return LottoTier.getTier(getMatchedNumberCount(targetLotto), isMatchedBonusNumber(targetLotto));
    }

    public long getMatchedNumberCount(Lotto targetLotto) {
        return lotto
                .getValue()
                .stream()
                .filter(winningLottoNumber -> targetLotto.contains(winningLottoNumber))
                .count();
    }

    private boolean isMatchedBonusNumber(Lotto targetLotto) {
        return targetLotto.getValue().contains(bonusNumber);
    }
}
