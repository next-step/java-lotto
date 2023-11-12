package me.namuhuchutong.lotto;


import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LottoResult {

    private final Map<LottoCount, Lotto> lottoResult;

    public LottoResult(Map<LottoCount, Lotto> lottoResult) {
        this.lottoResult = lottoResult;
    }

    public long getWinnings() {
        long totalPrice = 0;
        for (LottoCount count : lottoResult.keySet()) {
            totalPrice += LottoWinnings.valueOfCount(count);
        }
        return totalPrice;
    }

    public List<String> getLottoCountResult() {
        return lottoResult.keySet().stream()
                          .map(buildMatchNumberAndCount())
                          .collect(Collectors.toList());
    }

    private Function<LottoCount, String> buildMatchNumberAndCount() {
        return lottoCount -> lottoCount.toString() + ": "
                + lottoResult.get(lottoCount).getSize() + "\n"
                + lottoResult.get(lottoCount);
    }

    @Override
    public String toString() {
        return lottoResult.toString();
    }
}
