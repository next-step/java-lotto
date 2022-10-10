package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    public LottoWrapper buyLotto(int purchaseAmount, int passiveLottoCount, List<LottoNumbersWrapper> passiveLottoNumbersCollection) {
        List<Lotto> lottos = new ArrayList<>();

        lottos.addAll(buyPassiveLotto(passiveLottoNumbersCollection));
        int activeLottoCount = (purchaseAmount - (passiveLottoCount * Config.LOTTO_PRICE)) / Config.LOTTO_PRICE;
        lottos.addAll(buyActiveLotto(activeLottoCount));

        return new LottoWrapper(lottos);
    }

    private List<Lotto> buyPassiveLotto(List<LottoNumbersWrapper> passiveLottoNumbersCollection) {
        List<Lotto> lottos = new ArrayList<>();
        for (LottoNumbersWrapper numbers : passiveLottoNumbersCollection) {
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }

    private List<Lotto> buyActiveLotto(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int index = 0; index < lottoCount; index++) {
            lottos.add(new Lotto(NumberGenerator.pickLottoNumber()));
        }
        return lottos;
    }
}
