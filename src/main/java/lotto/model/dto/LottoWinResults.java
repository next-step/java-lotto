package lotto.model.dto;

import lotto.model.LottoResult;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoWinResults {
    private final List<LottoWinResult> winResult;

    private LottoWinResults(List<LottoWinResult> winResult) {
        this.winResult = winResult;
    }

    public static LottoWinResults newInstance(Map<LottoResult, Long> result) {
        List<LottoWinResult> winResult = Collections.unmodifiableList(
                result.keySet()
                .stream()
                .filter(lottoResult -> !lottoResult.isBlank())
                .map(lottoResult -> new LottoWinResult(lottoResult, result.get(lottoResult)))
                .collect(Collectors.toList()));

        return new LottoWinResults(winResult);
    }

    public List<LottoWinResult> getWinResult() {
        return winResult;
    }
}
