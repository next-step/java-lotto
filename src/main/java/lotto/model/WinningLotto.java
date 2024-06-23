package lotto.model;

public class WinningLotto {
    private final LottoTicket winningLotto;
    private final LottoNumber bonusNumber;

    public WinningLotto(LottoTicket winningLotto, LottoNumber bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public int match(LottoTicket target) {
        int matchCount = winningLotto.countMatchingNumbers(target);
        boolean hasBonus = target.getLottoNumbers().contains(bonusNumber);

        if (matchCount == 5 && hasBonus) {
            return 5;
        }

        return matchCount;
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }
}
