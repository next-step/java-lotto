package lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoStore {

    public List<Lotto> sell(long price) {
        final int lottoCount = (int) (price/1000);
        return Stream.generate(() -> new Lotto(new LottoNums(Stream.generate(() -> new LottoNum(1)).limit(6).collect(
            Collectors.toList()))))
            .limit(lottoCount)
            .collect(Collectors.toList());
    }
}
