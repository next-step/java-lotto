package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoStore {

    private final static int LOTTO_PRICE_PER_ONE = 1000;
    private final List<LottoGenerator> lottoGenerators = new ArrayList<>();

    public LottoStore() {
    }

    public List<Lotto> buy(int price, ManualLottoMemo memo) {
        validatePrice(price);
        validatePriceOverManualLottoCount(price, memo);
        lottoGenerators.add(new ManualLottoGenerator(memo));
        lottoGenerators.add(new AutoLottoGenerator(getCountPossibleBuyAutoLotto(price, memo)));
        return generator();
    }

    private int getCountPossibleBuyAutoLotto(int price, ManualLottoMemo manualLottoMemo) {
        return ((int) Math.floor(price / LOTTO_PRICE_PER_ONE)) - manualLottoMemo.size();
    }

    private List<Lotto> generator() {
        return lottoGenerators.stream()
                .flatMap(lottoGenerator -> lottoGenerator.generator().stream())
                .collect(Collectors.toList());
    }

    private static void validatePrice(int price) {
        if(price < LOTTO_PRICE_PER_ONE) {
            throw new IllegalArgumentException("입력된 금액이 로또구매 최소금액보다 작습니다.");
        }
    }

    private static void validatePriceOverManualLottoCount(int price, ManualLottoMemo manualLottoMemo) {
        if(price < manualLottoMemo.size() * LOTTO_PRICE_PER_ONE) {
            throw new IllegalArgumentException("입력된 금액으로는 원하시는 수동 로또 수 만큼 구매할 수 없습니다.");
        }
    }
}
