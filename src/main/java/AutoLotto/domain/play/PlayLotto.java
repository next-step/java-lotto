package AutoLotto.domain.play;

import AutoLotto.domain.lotto.LottoNum;
import AutoLotto.domain.lotto.Lottos;

import java.util.List;

public class PlayLotto {

    private final Lottos lottos;
    private final List<LottoNum> buzzNumList;

    PlayLotto(Lottos lottos, List<LottoNum> buzzNumList) {
        this.lottos = lottos;
        this.buzzNumList = buzzNumList;
    }



}
