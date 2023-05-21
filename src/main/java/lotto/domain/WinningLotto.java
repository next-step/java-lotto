package lotto.domain;

public class WinningLotto {

    private final Lotto winningLotto;
    private final LottoNumber bonusLottoNumber;
    private static final String WINNING_LOTTO_NUMBERS_AND_THE_BOUNS_NUMBER_CANNOT_BE_DUPLICATED = "당첨 로또 번호와 보너스 번호는 중복될 수 없습니다.";

    public WinningLotto(Lotto winningLotto, LottoNumber bonusLottoNumber) {
        this.winningLotto = winningLotto;
        this.bonusLottoNumber = bonusLottoNumber;
        validateBonusLottoNumber();
    }

    private void validateBonusLottoNumber() {
        if (doesWinningLottoContainBonusNumber()) {
            throw new IllegalArgumentException(WINNING_LOTTO_NUMBERS_AND_THE_BOUNS_NUMBER_CANNOT_BE_DUPLICATED);
        }
    }

    private boolean doesWinningLottoContainBonusNumber() {
        return winningLotto.getLottoNumbers().contains(bonusLottoNumber);
    }

    public Rank calculateRank(Lotto lotto) {
        return Rank.findRank(getMatchNumbers(lotto), hasBonusNumber(lotto));
    }

    public int getMatchNumbers(Lotto lotto) {
        return (int) lotto.getLottoNumbers().stream()
                .filter(winningLotto.getLottoNumbers()::contains)
                .count();
    }

    private boolean hasBonusNumber(Lotto lotto) {
        return lotto.getLottoNumbers().contains(bonusLottoNumber);
    }
}
