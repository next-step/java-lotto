package lotto.domain;

import java.util.List;

public class TestLottoPublisher implements LottoPublisher {
    private final List<List<Integer>> lottoList;
    private int counter;

    TestLottoPublisher(List<List<Integer>> lottoList) {
        this.lottoList = lottoList;
    }

    @Override
    public List<Integer> get() {
        return lottoList.get(counter++ % lottoList.size());
    }
}
