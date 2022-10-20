package lotto.domain;

import java.util.List;

public class FixedLottoGenerator implements LottoGenerable {

    private static final List<Lotto> lottos = List.of(
            Lotto.from("31,32,33,34,35,36"),
            Lotto.from("37,38,39,40,41,42")
    );

    @Override
    public List<Lotto> generate(PlayLottoCount playLottoCount) {
        return lottos.subList(0, playLottoCount.getValue());
    }
}
