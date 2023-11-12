package me.namuhuchutong.lotto.domain;

import static java.util.stream.Collectors.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import me.namuhuchutong.lotto.domain.generator.NumberGenerator;
import me.namuhuchutong.lotto.dto.LottoResult;

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
                                                    .collect(groupingBy(
                                                            numbers -> new LottoCount(numbers.howManyMatch(given)),
                                                            collectingAndThen(toUnmodifiableList(), Lotto::new)));
        return new LottoResult(collect);
    }


    @Override
    public String toString() {
        return values.toString();
    }
}
