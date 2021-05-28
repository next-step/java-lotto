package lottoAuto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoResults {
    private List<LottoResult> lottoResult;

    public LottoResults() {
        this.lottoResult = new ArrayList<>();
    }

    public void add(LottoResult lottoResult) {
        this.lottoResult.add(lottoResult);
    }

    public List<LottoResult> getLottoResult() {
        return lottoResult;
    }

}
