package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class TestLottoPublisher implements LottoPublisher {
    private final List<Lotto> lottoList;
    private int counter;

    TestLottoPublisher(List<List<Integer>> lottoList) {
        this.lottoList = lottoList.stream()
                .map(lotto -> lotto.stream()
                        .map(LottoNumber::new)
                        .collect(Collectors.toList())
                )
                .map(Lotto::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<LottoNumber> get() {
        return lottoList.get(counter++ % lottoList.size()).getNumbers();
    }
}
