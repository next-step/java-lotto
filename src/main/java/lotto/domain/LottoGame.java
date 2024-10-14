package lotto.domain;

import static lotto.domain.LottoNumber.generateAutoLottoNumbers;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private final LottoPrice lottoPrice;
    private final List<Lotto> lottoList;
    private final LottoResults lottoResults;

    public LottoGame(int gameMoney) {
        this(new LottoPrice(gameMoney), new LottoResults());
    }

    public LottoGame(LottoPrice lottoPrice, LottoResults lottoResults) {
        this.lottoPrice = lottoPrice;
        this.lottoList = generateLotto(lottoPrice.getLottoCount());
        this.lottoResults = lottoResults;
    }

    private List<Lotto> generateLotto(int count) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottoList.add(new Lotto(generateAutoLottoNumbers()));
        }
        return lottoList;
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
