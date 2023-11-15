package me.namuhuchutong.lotto.domain;

import static java.util.Collections.*;
import static java.util.stream.Collectors.*;
import static me.namuhuchutong.lotto.domain.LottoWinnings.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import me.namuhuchutong.lotto.domain.generator.NumberGenerator;
import me.namuhuchutong.lotto.dto.LottoResult;

public class Lotto {

    private final List<Numbers> values;

    public static Lotto create(int times, NumberGenerator generator, String[] manualNumber) {
        return new Lotto(addAllLottos(
                createManualLotto(manualNumber),
                createAutoLotto(times, generator, manualNumber.length)));
    }

    private static List<Numbers> addAllLottos(List<Numbers> manualLotto, List<Numbers> autoLotto) {
        List<Numbers> collectAll = new ArrayList<>();
        collectAll.addAll(manualLotto);
        collectAll.addAll(autoLotto);
        return unmodifiableList(collectAll);
    }

    private static List<Numbers> createAutoLotto(int times, NumberGenerator generator, int manualTimes) {
        return Stream.generate(() -> Numbers.create(generator))
                     .limit(times - manualTimes)
                     .collect(toUnmodifiableList());
    }

    private static List<Numbers> createManualLotto(String[] manualNumber) {
        return Arrays.stream(manualNumber)
                     .map(Numbers::create)
                     .collect(toUnmodifiableList());
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
        if (bonusMatches.size() == 0) {
            return;
        }
        fiveMatches.values.removeAll(bonusMatches.values);
        removeIfZero(collect, fiveMatches);
        collect.put(new LottoCount(BONUS.getCount()), bonusMatches);
    }

    private void removeIfZero(Map<LottoCount, Lotto> collect, Lotto fiveMatches) {
        if (fiveMatches.size() == 0) {
            collect.remove(new LottoCount(FIVE.getCount()));
        }
    }

    public int size() {
        return this.values.size();
    }

    @Override
    public String toString() {
        return values.toString();
    }
}
