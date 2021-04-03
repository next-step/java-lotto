package step3.domain.shop;

import step3.domain.lotto.Lotto;
import step3.domain.lotto.LottoNumber;

import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class LottoShop {

    private final static int FROM_INDEX = 1;
    private final static int TO_INDEX = 7;

    private static class LottoShopHolder {
        public static final LottoShop instance = new LottoShop();
    }

    private LottoShop() {
    }

    public static final LottoShop getInstance() {
        return LottoShopHolder.instance;
    }

    public final List<Lotto> buyLottos(int money) {
        return Stream.generate(this::generateLotto)
                .limit(money / Lotto.PRICE)
                .collect(Collectors.toList());
    }

    private final Lotto generateLotto() {
        List<LottoNumber> lottoNumbers = LottoNumber.values();
        lottoNumbers = lottoNumbers.subList(FROM_INDEX, TO_INDEX);
        return Lotto.of(new TreeSet<>(lottoNumbers));
    }

}
