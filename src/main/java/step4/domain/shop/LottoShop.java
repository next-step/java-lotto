package step4.domain.shop;

import step4.domain.lotto.Lotto;
import step4.domain.lotto.LottoNumber;
import step4.domain.money.Money;
import step4.strategy.LottoShuffleStrategy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class LottoShop {

    public static final int FROM_INDEX = 0;
    public static final int TO_INDEX = 6;

    private static class LottoShopHolder {
        private static LottoShop lottoShop = new LottoShop();
    }

    public LottoShop() { }

    public static final LottoShop getInstance() {
        return LottoShopHolder.lottoShop;
    }

    public final List<Lotto> purchaseLotto(int availablePurchaseCount, LottoShuffleStrategy strategy) {
        return Stream.generate(() -> generateLotto(strategy))
                .limit(availablePurchaseCount)
                .collect(Collectors.toList());
    }

    private final Lotto generateLotto(LottoShuffleStrategy strategy) {
        List<LottoNumber> lottoNumbers = LottoNumber.values();
        strategy.shuffle(lottoNumbers);
        return Lotto.of(lottoNumbers.subList(FROM_INDEX, TO_INDEX));
    }

}
