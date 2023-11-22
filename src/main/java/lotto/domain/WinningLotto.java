package lotto.domain;


public class WinningLotto {

    private final Lotto winningLotto;
    private final LottoNo bonusNumber;

    public WinningLotto(Lotto winningNumbers, LottoNo bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("당첨번호와 중복된 번호는 입력할 수 없습니다.");
        }
        this.winningLotto = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Rank matchRank(Lotto lotto) {
        int count = lotto.matchCount(winningLotto);
        boolean isBonus = lotto.contains(bonusNumber);

        return Rank.valueOf(count, isBonus);
    }
}
