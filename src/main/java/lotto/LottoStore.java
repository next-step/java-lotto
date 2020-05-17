package lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoStore {

    public List<Lotto> sell(long price) {
        final int lottoCount = (int) (price/1000);
        return Stream.generate(() -> new Lotto())
            .limit(lottoCount)
            .collect(Collectors.toList());
    }
}
