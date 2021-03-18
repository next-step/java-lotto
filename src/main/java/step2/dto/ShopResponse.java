package step2.dto;

import step2.domain.Lotto;

import java.util.List;

public class ShopResponse {
    private final int originMoney;
    private final int lottoCount;
    private final List<Lotto> lottoList;
    private final int change;

    public ShopResponse(int originMoney, int lottoCount, List<Lotto> lottoList, int change) {
        this.originMoney = originMoney;
        this.lottoCount = lottoCount;
        this.lottoList = lottoList;
        this.change = change;
    }

    public int getOriginMoney() {
        return originMoney;
    }

    public int getLottoCount() {
        return lottoCount;
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }
}
