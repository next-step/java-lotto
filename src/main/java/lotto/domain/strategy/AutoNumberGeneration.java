package lotto.domain.strategy;

import lotto.domain.LottoNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

public class AutoNumberGeneration implements NumberGeneration {
    public static final int TO_INDEX = 6;
    private final List<LottoNumber> list;

    public AutoNumberGeneration(Map<Integer, LottoNumber> cacheList) {
        this.list = new ArrayList<>(cacheList.values());
    }

    @Override
    public List<LottoNumber> generate() {
        Collections.shuffle(list);

        return list.stream()
                .limit(TO_INDEX)
                .collect(toList());
    }

}
