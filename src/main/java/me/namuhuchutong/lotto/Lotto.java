package me.namuhuchutong.lotto;

import static java.util.stream.Collectors.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Lotto {

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
                                              .filter(numbers -> numbers.howManyMatch(given) >= 3)
                                              .collect(
                                                      groupingBy(
                                                              numbers -> new LottoCount(numbers.howManyMatch(given)),
                                                              collectingAndThen(toUnmodifiableList(), Lotto::new)));
        return new LottoResult(collect);
    }

    @Override
    public String toString() {
        return "{" + values + "}" + "\n";
    }
}
