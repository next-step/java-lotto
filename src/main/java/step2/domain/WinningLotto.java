package step2.domain;

public class WinningLotto {
    public static final String BONUS_NUMBER_DUPLICATE_EXCEPTION_MESSAGE = "보너스 번호가 로또 번호와 중복될 수 없습니다.";

    private Lotto lotto;
    private LottoNumber bonusNumber;

    public WinningLotto(Lotto lotto, LottoNumber bonusNumber) {
        assertBonusNumber(lotto, bonusNumber);
        
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    private void assertBonusNumber(Lotto lotto, LottoNumber bonusNumber) {
        if(lotto.contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATE_EXCEPTION_MESSAGE);
        }
    }

    public LottoTier getLottoTier(Lotto targetLotto) {
        return LottoTier.getTier(getMatchingCount(targetLotto), isMatchedBonusNumber(targetLotto));
    }

    private long getMatchingCount(Lotto targetLotto) {
        return lotto.getValue()
                .stream()
                .filter(number -> targetLotto.contains(number))
                .count();
    }

    private boolean isMatchedBonusNumber(Lotto targetLotto) {
        return targetLotto.getValue().contains(bonusNumber);
    }
}
