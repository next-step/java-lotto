package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoStore {

    private final static int LOTTO_PRICE_PER_ONE = 1000;

    public LottoStore() {}

    public List<Lotto> buy(PriceLotto price, ManualLottoMemo memo) {
        validatePrice(price);
        validatePriceOverManualLottoCount(price, memo);
        List<Lotto> lottos = LottoGenerator.generate(getCountPossibleBuyAutoLotto(price, memo), memo);
        price.boughtLotto(lottos.size(), LOTTO_PRICE_PER_ONE);
        return lottos;
    }

    private int getCountPossibleBuyAutoLotto(PriceLotto price, ManualLottoMemo manualLottoMemo) {
        return ((int) Math.floor(price.getIntValue() / LOTTO_PRICE_PER_ONE)) - manualLottoMemo.size();
    }

    private static void validatePrice(PriceLotto price) {
        if(price.getIntValue() < LOTTO_PRICE_PER_ONE) {
            throw new IllegalArgumentException("입력된 금액이 로또구매 최소금액보다 작습니다.");
        }
    }

    private static void validatePriceOverManualLottoCount(PriceLotto price, ManualLottoMemo manualLottoMemo) {
        if(price.getIntValue() < manualLottoMemo.size() * LOTTO_PRICE_PER_ONE) {
            throw new IllegalArgumentException("입력된 금액으로는 원하시는 수동 로또 수 만큼 구매할 수 없습니다.");
        }
    }
}
