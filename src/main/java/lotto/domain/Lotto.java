package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private final List<LottoNum> lottoNumList;

    public Lotto(List<Integer> numList) {
        this.lottoNumList = numList.stream().map(LottoNum::new).collect(Collectors.toList());
    }

    @Override
    public String toString() {

        return "[" + lottoNumList.stream()
                .map(LottoNum::toString)
                .collect(Collectors.joining(", ")) + "]";
    }
}
