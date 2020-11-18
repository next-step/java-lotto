package lotto.domain;

import java.util.List;

public class LottoGameResult {

    private List<Integer> lottoGameResult;

    public LottoGameResult(List<Integer> lottoGameResult) {
        this.lottoGameResult = lottoGameResult;
    }

    public List<Integer> getLottoGameResult(){
        return lottoGameResult;
    }


}
