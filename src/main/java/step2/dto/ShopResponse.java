package step2.dto;

import java.util.List;

public class ShopResponse {

    private static final int LOTTO_PRICE = 1000;

    private final int originMoney;
    private final int lottoCount;
    private final List<Lotto> lottoList;
    private final int change;

    public ShopResponse(int originMoney, int lottoCount, List<Lotto> lottoList, int change) {
        this.originMoney = originMoney;
        this.lottoCount = lottoCount;
        this.lottoList = lottoList;
        this.change = change;
        if(!isResponseValid(this)) throw new IllegalArgumentException();
    }

    private boolean isResponseValid(ShopResponse shopResponse) {
        return shopResponse.getLottoCount()*LOTTO_PRICE+change==originMoney;
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
