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

    public LottoFactory(List<LottoGenerator> factory) {
        this.factory = factory;
    }

    public UserLotto createUserLotto() {
        return UserLotto.from(createListOfIntegerList());
    }

    private List<Lotto> createListOfIntegerList() {
        List<Lotto> result = new ArrayList<>();
        factory.stream()
                .forEach(addLottoByLottoGenerator(result));
        return result;
    }

    private static Consumer<LottoGenerator> addLottoByLottoGenerator(List<Lotto> result) {
        return item -> Stream.generate(() -> item.create()).limit(item.getSize())
                .forEach(integerList -> {
                    result.add(Lotto.from(integerList));
                });
    }
}
