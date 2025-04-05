package com.nextstep.camp.lotto.domain.vo;

import com.nextstep.camp.lotto.domain.type.Rank;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Ranks {
    private final List<Rank> values;

    private Ranks(List<Rank> values) {
        this.values = values;
    }

    public static Ranks of(List<Rank> values) {
        return new Ranks(values);
    }

    public Map<Rank, Integer> getRanksCount() {
            return Rank.getValidValues().stream()
                .collect(Collectors.toMap(
                        Function.identity(),
                        matchResult -> Collections.frequency(values, matchResult),
                        (a, b) -> a,
                        LinkedHashMap::new
                ));
    }
}
