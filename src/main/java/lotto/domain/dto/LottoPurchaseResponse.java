package lotto.domain.dto;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

import java.util.List;

public class LottoPurchaseResponse {
    private List<Lotto> lottoList;

    public LottoPurchaseResponse(Lottos lottos) {
        lottoList = lottos.getLottos();
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }
}
