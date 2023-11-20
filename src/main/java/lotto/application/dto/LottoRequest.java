package lotto.application.dto;

import lotto.domain.Lotto;

import java.util.List;

public class LottoRequest {
    private Integer inputAmount;
    private List<Lotto> lottos;
    private List<Integer> winningLottoNumber;

    public LottoRequest(Integer inputAmount, List<Lotto> lottos, List<Integer> winningLottoNumber) {
        this.inputAmount = inputAmount;
        this.lottos = lottos;
        this.winningLottoNumber = winningLottoNumber;
    }

    public Integer getInputAmount() { return inputAmount; }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public List<Integer> getWinningLottoNumber() {
        return winningLottoNumber;
    }
}
