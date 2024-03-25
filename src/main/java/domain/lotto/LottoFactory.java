package domain.lotto;

import domain.common.Money;
import domain.lotto.genrate.LottoGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class LottoFactory {
    private final static Money LOTTO_PRICE = new Money(1000L);
    private final LottoGenerator lottoGenerator;

    public LottoFactory(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public UserLotto createUserLotto(Money money) {
        return UserLotto.from(createListOfIntegerList(availableCountForPurchase(money)));
    }

    private static long availableCountForPurchase(Money money) {
        return LOTTO_PRICE.divide(money);

    }

    private List<List<Integer>> createListOfIntegerList(long count) {
        List<List<Integer>> result = new ArrayList<>();
        Stream.generate(() -> lottoGenerator.create()).limit(count)
                .forEach(lottoIntegerList -> result.add(lottoIntegerList));
        return result;
    }
}
