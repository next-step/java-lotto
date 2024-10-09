package step2.model;

import java.util.ArrayList;
import java.util.List;

public class LottoResult {
    List<Lotto> lottoResult = new ArrayList<>();

    public void setLottoResult(Lotto lotto) {
        this.lottoResult.add(lotto);
    }

    public List<Lotto> getLottoResults() {
        return lottoResult;
    }

    public int size() {
        return lottoResult.size();
    }
}
