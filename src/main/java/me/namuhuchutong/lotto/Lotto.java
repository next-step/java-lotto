package me.namuhuchutong.lotto;

import static java.util.stream.Collectors.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Lotto {

    private static final int MINIMUM_MATCH = 3;

    private final List<Numbers> values;

    public static Lotto create(int times, NumberGenerator generator) {
        List<Numbers> collect = Stream.generate(() -> Numbers.create(generator))
                                      .limit(times)
                                      .collect(toUnmodifiableList());
        return new Lotto(collect);
    }

    public Lotto(List<Numbers> values) {
        this.values = values;
    }

    public LottoResult getMatchNumbers(Numbers given) {
        Map<LottoCount, Lotto> collect = this.values.stream()
                                                    .filter(numbers -> numbers.howManyMatch(given) >= MINIMUM_MATCH)
                                                    .collect(groupingBy(
                                                            numbers -> new LottoCount(numbers.howManyMatch(given)),
                                                            collectingAndThen(toUnmodifiableList(), Lotto::new)));
        return new LottoResult(collect);
    }

    public int getSize() {
        return this.values.size();
    }

    @Override
    public String toString() {
        return values.toString();
    }
}
