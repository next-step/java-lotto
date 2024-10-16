package lotto.domain;

import static lotto.domain.Lotto.LOTTO_SIZE;
import static lotto.domain.LottoCount.LOTTO_MINIMUM_COUNT;
import static lotto.domain.LottoNumber.generateAutoLottoNumbers;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private final LottoPrice lottoPrice;
    private final List<Lotto> lottoList;
    private final LottoResults lottoResults;
    private final LottoCount lottoCount;

    public LottoGame(LottoPrice lottoPrice) {
        this(lottoPrice, new LottoCount(lottoPrice, LOTTO_MINIMUM_COUNT), new ArrayList<>());
    }

    public LottoGame(LottoPrice lottoPrice, LottoCount lottoCount, List<Lotto> lottos) {
        this(lottoPrice, lottoCount, lottos, new LottoResults());
    }

    public LottoGame(LottoPrice lottoPrice, LottoCount lottoCount, List<Lotto> lottos, LottoResults lottoResults) {
        this.lottoPrice = lottoPrice;
        this.lottoList = generateLotto(lottos, lottoCount);
        this.lottoCount = lottoCount;
        this.lottoResults = lottoResults;
    }


    private List<Lotto> generateLotto(List<Lotto> lottos, LottoCount lottoCount) {
        for (int i = 0; i < lottoCount.getAutoCount(); i++) {
            lottos.add(new Lotto(generateAutoLottoNumbers(LOTTO_SIZE)));
        }
        return lottos;
    }

    public LottoCount getLottoCount() {
        return lottoCount;
    }

    public List<Lotto> getLottos() {
        return lottoList;
    }

    public LottoResults makeLottoResult(WinningLotto winningLotto) {
        for (Lotto lotto : lottoList) {
            lottoResults.addResult(winningLotto.getLottoResult(lotto));
        }
        return lottoResults;
    }

    public String getEarnRate() {
        return lottoPrice.calculateEarnRate(lottoResults.getPrizeMoney());
    }
}
