package step2.dto;

import step2.domain.Lotto;
import step2.domain.Lottos;

import java.util.List;

public class ShopResponse {

    private final int originMoney;
    private final int lottoCount;
    private final Lottos lottos;
    private final int change;

    public ShopResponse(int originMoney, int lottoCount, Lottos lottos, int change) {
        this.originMoney = originMoney;
        this.lottoCount = lottoCount;
        this.lottos = lottos;
        this.change = change;
    }

    public int getChange() {
        return change;
    }

    public int getOriginMoney() {
        return originMoney;
    }

    public int getLottoCount() {
        return lottoCount;
    }

    public Lottos getLottos() {
        return lottos;
    }
}
