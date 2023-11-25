package lotto.application.dto;

import lotto.domain.Lotto;
import lotto.domain.Lottos;


public class LottoRequest {
    private Integer inputAmount;
    private Lottos lottos;
    private Lotto winningLotto;
    private Integer bonusNumber;

    public LottoRequest(
            Integer inputAmount,
            Lottos lottos,
            Lotto winningLotto,
            Integer bonusNumber) {
        this.inputAmount = inputAmount;
        this.lottos = lottos;
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public Integer getInputAmount() { return inputAmount; }

    public Lottos getLottos() { return lottos; }

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    public Integer getBonusNumber() { return bonusNumber; }
}
