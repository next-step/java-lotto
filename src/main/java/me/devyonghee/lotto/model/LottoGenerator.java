package me.devyonghee.lotto.model;

import me.devyonghee.common.StringsProvider;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {

    private static final List<LottoNumber> ALL_LOTTO_NUMBERS = IntStream.rangeClosed(LottoNumber.MIN_NUMBER, LottoNumber.MAX_NUMBER)
            .mapToObj(LottoNumber::from)
            .collect(Collectors.toList());
    private static final int START_SUB_INDEX = 0;
    private static final int START_RANGE_INDEX = 0;
    private final List<StringsProvider> providers;

    private LottoGenerator(List<StringsProvider> providers) {
        Objects.requireNonNull(providers, "stringNumbers must not be null");
        this.providers = providers;
    }

    public static LottoGenerator from(List<StringsProvider> providers) {
        return new LottoGenerator(providers);
    }

    Lottos manualLottos() {
        return Lottos.from(providers.stream()
                .map(this::manualLotto)
                .collect(Collectors.toList()));
    }

    private Lotto manualLotto(StringsProvider provider) {
        return Lotto.manual(LottoNumbers.from(provider.strings()
                .stream()
                .map(LottoNumber::from)
                .collect(Collectors.toList())));
    }

    Lottos autoLottos(int count) {
        return Lottos.from(IntStream.range(START_RANGE_INDEX, count)
                .mapToObj(i -> autoLotto())
                .collect(Collectors.toList()));
    }

    private Lotto autoLotto() {
        List<LottoNumber> numbers = new ArrayList<>(ALL_LOTTO_NUMBERS);
        Collections.shuffle(numbers);
        return Lotto.auto(LottoNumbers.from(numbers.subList(START_SUB_INDEX, Lotto.NUMBER_SIZE)));
    }
}
