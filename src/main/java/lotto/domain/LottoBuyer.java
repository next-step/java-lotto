package lotto.domain;

import lombok.Getter;

import java.util.List;

public class LottoBuyer {
    @Getter
    private List<Lotto> lottos;

    public LottoBuyer(int money) {
        this.lottos = LottoStore.sellLotto(money);
    }

    public int getCount() {
        return lottos.size();
    }
}
