package lotto.model;

public class WinningLotto {
    private final LottoTicket winningLotto;
    private final LottoNumber bonusNumber;

    public WinningLotto(LottoTicket winningLotto, LottoNumber bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public int match(LottoTicket target) {
        int matchCount = winningLotto.match(winningLotto);
        if (winningLotto.getLottoNumbers().contains(bonusNumber)) {
            matchCount++;
        }
        return matchCount;
    }
}
