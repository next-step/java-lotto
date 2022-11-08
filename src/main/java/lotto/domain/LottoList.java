package lotto.domain;


import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;


public class LottoList {

    private final List<Lotto> lottoList;

    private LottoList(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public static LottoList from(List<Set<Integer>> lottoList) {
        return new LottoList(lottoProcess(lottoList));
    }

    public void add(List<Set<Integer>> lottoList) {
        this.lottoList.addAll(lottoProcess(lottoList));
    }

    private static List<Lotto> lottoProcess(List<Set<Integer>> lottoList) {
        return lottoList
            .stream()
            .map(Lotto::from)
            .collect(toList());
    }

    public List<Lotto> getLottoList() {
        return lottoList.stream()
            .collect(Collectors.toUnmodifiableList());
    }
}
