package lotto.application.dto;

import lotto.domain.Lottos;


public class LottoRequest {
    private Integer inputAmount;
    private Lottos lottos;

    public LottoRequest(Integer inputAmount, Lottos lottos) {
        this.inputAmount = inputAmount;
        this.lottos = lottos;
    }

    public Integer getInputAmount() { return inputAmount; }

    public Lottos getLottos() {
        return lottos;
    }
}
