package step3.domain.shop;

import step3.domain.lotto.Lotto;
import step3.domain.lotto.LottoNumber;
import step3.strategy.LottoShuffleStrategy;

import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class LottoShop {

    private final static int FROM_INDEX = 0;
    private final static int TO_INDEX = 6;

    private static class LottoShopHolder {
        public static final LottoShop instance = new LottoShop();
    }

    private LottoShop() {
    }

    public static final LottoShop getInstance() {
        return LottoShopHolder.instance;
    }

    public final List<Lotto> buyLottos(int money, LottoShuffleStrategy strategy) {
        return Stream.generate(() -> generateLotto(strategy))
                .limit(money / Lotto.PRICE)
                .collect(Collectors.toList());
    }

    private final Lotto generateLotto(LottoShuffleStrategy strategy) {
        List<LottoNumber> lottoNumbers = LottoNumber.values();
        strategy.shuffle(lottoNumbers);
        lottoNumbers = lottoNumbers.subList(FROM_INDEX, TO_INDEX);
        return Lotto.of(new TreeSet<>(lottoNumbers));
    }

}
