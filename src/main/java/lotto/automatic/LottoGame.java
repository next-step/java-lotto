package lotto.automatic;

import lotto.automatic.domain.Lotto;
import lotto.automatic.domain.LottoCollection;
import lotto.automatic.domain.LottoRank;
import lotto.automatic.domain.LottoResult;

import java.util.List;

public class LottoGame {

    public LottoCollection generateAutoLotto(int lottoAmount) {

        LottoCollection collection = new LottoCollection();

        for(int i = 0; i < lottoAmount; i ++ ) {
            collection.append(Lotto.auto());
        }

        return collection;
    }

    public LottoResult getLottoResult(int investMoney, List<LottoRank> rankList) {

        return new LottoResult(investMoney, rankList);
    }

}
