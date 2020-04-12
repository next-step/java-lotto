package lotto.domain;

public class WinningLotto {
    public static final String BOUNS_NOT_DUPLICATE = "보너스 번호와 당첨 번호 중복은 안됩니다.";
    private final Lotto lotto;
    private final LottoNumber bonusNumber;

    public WinningLotto(final Lotto lotto, final LottoNumber bounsNumber) {
        this.lotto = lotto;
        this.bonusNumber = validateBonusNumber(bounsNumber);
    }

    public Prize match(Lotto lotto) {
        int matchCount = lotto.getMatchCount(this.lotto);
        boolean bonusMatched = lotto.isMatch(bonusNumber);

        return Prize.of(matchCount, bonusMatched);
    }

    private LottoNumber validateBonusNumber(LottoNumber bonusNumber) {
        if (lotto.isMatch(bonusNumber)) {
            throw new IllegalArgumentException(BOUNS_NOT_DUPLICATE);
        }
        return bonusNumber;
    }

    @Override
    public String toString() {
        return "WinningLotto{" +
                "lotto=" + lotto +
                '}';
    }
}
