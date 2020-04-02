package lotto.model.dto;

import lotto.model.LottoResult;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoWinStatResults {
    private final List<LottoWinStatResult> winResult;

    private LottoWinStatResults(List<LottoWinStatResult> winResult) {
        this.winResult = winResult;
    }

    public static LottoWinStatResults newInstance(Map<LottoResult, Long> result) {
        List<LottoWinStatResult> winResult = Collections.unmodifiableList(
                result.keySet()
                        .stream()
                        .filter(lottoResult -> !lottoResult.isBlank())
                        .map(lottoResult -> new LottoWinStatResult(lottoResult, result.get(lottoResult)))
                        .collect(Collectors.toList()));

        return new LottoWinStatResults(winResult);
    }

    public List<LottoWinStatResult> getWinResult() {
        return winResult;
    }
}
