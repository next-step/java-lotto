package lotto.domain;

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
            lottoList.add(Lotto.autoLotto());
        }
        return lottoList;
    }

    public List<Lotto> getLottos() {
        return lottoList;
    }

    public LottoResults makeLottoResult(Lotto winningLotto) {
        for (Lotto lotto : lottoList) {
            setLottoResult(lotto.getLottoResult(winningLotto));
        }
        return lottoResults;
    }

    private void setLottoResult(LottoRank rank) {
        lottoResults.addResult(rank);
    }

    public String getEarnRate(){
        return lottoPrice.calculateEarnRate(lottoResults.getPrizeMoney());
    }
}
