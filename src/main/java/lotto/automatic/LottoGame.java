package lotto.automatic;

import lotto.automatic.domain.Lotto;
import lotto.automatic.domain.Lottos;
import lotto.automatic.domain.LottoRank;
import lotto.automatic.domain.LottoResult;

import java.util.List;

public class LottoGame {

    public Lottos generateAutoLotto(int lottoAmount) {

        Lottos lottos = new Lottos();

        for(int i = 0; i < lottoAmount; i ++ ) {
            lottos.append(Lotto.auto());
        }

        return lottos;
    }

    public LottoResult getLottoResult(int investMoney, List<LottoRank> rankList) {

        return new LottoResult(investMoney, rankList);
    }

}
