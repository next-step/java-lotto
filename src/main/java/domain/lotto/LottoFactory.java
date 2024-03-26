package domain.lotto;

import domain.common.Money;
import domain.lotto.genrate.CustomLottoGenerator;
import domain.lotto.genrate.LottoGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoFactory {
    private final List<LottoGenerator> factory;
    private final LottoCount lottoCount;

    public LottoFactory(List<LottoGenerator> factory, LottoCount lottoCount) {
        this.factory = factory;
        this.lottoCount = lottoCount;
    }

    public UserLotto createUserLotto() {
        return UserLotto.from(createListOfIntegerList(lottoCount));
    }

    private List<Lotto> createListOfIntegerList(LottoCount lottoCount) {
        List<Lotto> result = new ArrayList<>();
        factory.stream()
                .forEach(addLottoByLottoGenerator(lottoCount, result));
        return result;
    }

    private static Consumer<LottoGenerator> addLottoByLottoGenerator(LottoCount lottoCount, List<Lotto> result) {
        return item -> Stream.generate(() -> item.create()).limit(lottoCount.getCount(item))
                .forEach(integerList -> {
                    result.add(Lotto.from(integerList));
                });
    }
}
