package dto;

import domain.LottoResult;

import java.util.Collections;
import java.util.List;

public class WinningLottoResult {
    private List<LottoResult> lottoResults;

    public WinningLottoResult(List<LottoResult> lottoResults) {
        this.lottoResults = lottoResults;
    }

    private void validateOnlyWinning() {
        if (lottoResults.stream().anyMatch(LottoResult::isNotWinning)) {
            throw new IllegalArgumentException("당첨 번호만 입력 가능합니다.");
        }
    }

    public List<LottoResult> getLottoResults() {
        return Collections.unmodifiableList(lottoResults);
    }
}
