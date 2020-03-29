package lotto.domain;

public class WinningLotto {
    private static final int FIVE_MATCH_COUNT = 5;
    private Lotto winningLotto;
    private int bonusNumber;

    public WinningLotto(String lottoNumber, int bonusNumber) {
        this.winningLotto = new Lotto(lottoNumber);
        this.bonusNumber = bonusNumber;
    }

    public WinningType checkWinning(Lotto lotto) {
        long matchCount = winningLotto.getLottoNumbers().stream()
                .filter(lottoNumber -> lotto.isContainsLottoNumber(lottoNumber))
                .count();
        boolean bonusMatch = false;

        if (isWinningFive(matchCount)) {
            bonusMatch = lotto.isContainsLottoNumber(LottoNumber.valueOf(bonusNumber));
        }
        return WinningType.findLottoWinningtype(matchCount, bonusMatch);
    }

    private boolean isWinningFive(long matchCount) {
        return matchCount == FIVE_MATCH_COUNT;
    }
}
