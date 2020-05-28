package step2.model;

import java.util.List;

public class LottoResults {

    List<LottoResult> lottoResults;
    private LottoResults(List<LottoResult> lottoResult) {this.lottoResults = lottoResult;}

    public static LottoResults of(List<LottoResult> lottoResults) {
        return new LottoResults(lottoResults);
    }
}
