package lotto.domain;

import lotto.random.LottoGenerator;

import java.util.List;

public class Lotto {
    private final AllRoundLottoNumbers allRoundLottoNumbers;
    private final TryCount tryCount;

    public Lotto(LottoGenerator lottoGenerator, int purchaseAmount) {
        tryCount = TryCount.initTryCount(purchaseAmount);
        allRoundLottoNumbers = AllRoundLottoNumbers.initAllRoundLottoNumbers(lottoGenerator,tryCount.getTryCount());
    }

    public int getTryCount() {
        return tryCount.getTryCount();
    }
    public List<List<Integer>> totalRoundLottoNumberList(){
        return allRoundLottoNumbers.totalRoundLottoNumberList();
    }

    public List<Integer> lottoRankList(LottoNumbers winningLottoNumbers){
        return allRoundLottoNumbers.lottoRankList(winningLottoNumbers);

    }

}
