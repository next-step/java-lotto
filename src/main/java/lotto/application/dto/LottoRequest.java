package lotto.application.dto;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Lottos;


public class LottoRequest {
    private Integer inputAmount;
    private Lottos lottos;
    private Lotto winningLotto;
    private LottoNumber bonusNumber;

    public LottoRequest(
            Integer inputAmount,
            Lottos lottos,
            Lotto winningLotto,
            LottoNumber bonusNumber) {
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

    public LottoNumber getBonusNumber() { return bonusNumber; }
}
