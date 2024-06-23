package lotto.model;

public class WinningLotto {
    private final LottoTicket winningLotto;
    private final LottoNumber bonusNumber;

    public WinningLotto(LottoTicket winningLotto, LottoNumber bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public int match(LottoTicket target) {
        int matchCount = winningLotto.countMatchingNumbers(winningLotto);
        boolean hasBonus = target.getLottoNumbers().contains(bonusNumber);

        if (matchCount == 5 && hasBonus) {
            return 6;
        }

        return matchCount;
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }
}
