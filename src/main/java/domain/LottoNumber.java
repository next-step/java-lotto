package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LottoNumber {

    List<Integer> lottos = new ArrayList<>();

    public LottoNumber() {
        lottoNumberRange();
    }

    public void lottoNumberRange() {
        IntStream
            .range(1, 46)
            .forEach(i -> this.lottos.add(i));
    }

    public List<Integer> getLottos() {
        return lottos;
    }
}
