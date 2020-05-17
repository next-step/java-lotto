package lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoStore {

    public List<Lotto> sell(long price) {
        return Stream.generate(() -> getLotto())
            .limit(getLottoCount(price))
            .collect(Collectors.toList());
    }

    private int getLottoCount(long price) {
        return (int) (price / 1000);
    }

    private Lotto getLotto() {
        return new Lotto(getLottoNums());
    }

    private LottoNums getLottoNums() {
        return new LottoNums(Stream.generate(() -> new LottoNum(1))
            .limit(6)
            .collect(Collectors.toList()));
    }
}
