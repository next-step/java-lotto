package lotto.domain;


import static java.util.stream.Collectors.toList;

import java.util.Collections;
import java.util.List;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoList {

    private static final int LOTTO_COUNT = 6;
    private static final List<Integer> numList = IntStream
        .rangeClosed(1, 45)
        .boxed()
        .collect(toList());
    private final List<Lotto> lottos;

    private LottoList(List<Lotto> lottoList) {
        this.lottos = lottoList;
    }

    public static LottoList of(int count) {
        return new LottoList(IntStream.rangeClosed(1, count)
            .mapToObj(value -> getLottoNumbers())
            .map(Lotto::from)
            .collect(toList()));
    }

    public List<Lotto> getLottoList() {
        return lottos;
    }

    private static Set<Integer> getLottoNumbers() {
        Collections.shuffle(numList);
        return numList.stream()
            .limit(LOTTO_COUNT)
            .collect(Collectors.toSet());
    }
}
