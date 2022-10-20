package lotto.domain;

import java.util.List;

public interface LottoGenerable {

    List<Lotto> generate(PlayLottoCount playLottoCount);
}
