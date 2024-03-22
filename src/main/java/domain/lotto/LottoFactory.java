package domain.lotto;

import domain.common.Money;
import domain.lotto.genrate.LottoGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class LottoFactory {
    private final LottoGenerator lottoGenerator;

    public LottoFactory(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public UserLotto createUserLotto(Money money) {
        long count = LottoPrice.availableForPurchase(money);
        return UserLotto.from(createListOfIntegerList(count));
    }

    private List<List<Integer>> createListOfIntegerList(long count) {
        List<List<Integer>> result = new ArrayList<>();
        Stream.generate(() -> lottoGenerator.create()).limit(count)
                .forEach(lottoIntegerList -> result.add(lottoIntegerList));
        return result;
    }
}
