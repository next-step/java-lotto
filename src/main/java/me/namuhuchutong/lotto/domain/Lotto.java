package me.namuhuchutong.lotto.domain;

import static java.util.Collections.*;
import static java.util.stream.Collectors.*;
import static me.namuhuchutong.lotto.domain.LottoWinnings.*;

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

    public LottoResult getMatchNumbers(Numbers given, Number bonusNumber) {
        Map<LottoCount, Lotto> collect = this.values.stream()
                                                    .collect(groupingBy(
                                                                    numbers -> new LottoCount(numbers.howManyMatch(given)),
                                                            collectingAndThen(toList(), Lotto::new)));
        Lotto fiveMatches = collect.getOrDefault(new LottoCount(FIVE.getCount()), new Lotto(EMPTY_LIST));
        Lotto bonusMatches = fiveMatches.values.stream()
                                           .filter(numbers -> numbers.contains(bonusNumber))
                                           .collect(collectingAndThen(toList(), Lotto::new));
        removeDuplicated(collect, fiveMatches, bonusMatches);
        return new LottoResult(collect);
    }

    private void removeDuplicated(Map<LottoCount, Lotto> collect, Lotto fiveMatches, Lotto bonusMatches) {
        fiveMatches.values.removeAll(bonusMatches.values);
        collect.put(new LottoCount(BONUS.getCount()), bonusMatches);
    }

    public int size() {
        return this.values.size();
    }

    @Override
    public String toString() {
        return values.toString();
    }
}
