package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoResult {

    private static List<LottoNumberResult> lottoNumberResult;

    public LottoResult() {
        this.lottoNumberResult = lottoResultInit();
    }

    public static double profitPercent(LottoPrice lottoPrice) {
        return lottoPrice.profitPercent(totalResultPrice());
    }

    private static int totalResultPrice() {
        return lottoNumberResult.stream()
                .filter(LottoNumberResult::isCountNotZero)
                .mapToInt(LottoNumberResult::multiplication)
                .sum();
    }

    public void putLottoResult(LottoRank lottoRank) {
        if (lottoRank != null) {
            LottoNumberResult findLottoResult = findLottoNumberResult(lottoRank);
            findLottoResult.plus();
        }
    }

    public static List<LottoNumberResult> lottoNumberResult() {
        return lottoNumberResult;
    }

    private List<LottoNumberResult> lottoResultInit() {
        List<LottoNumberResult> lottoNumberResults = new ArrayList<>();
        lottoNumberResults.add(new LottoNumberResult(LottoRank.FOURTH, 0));
        lottoNumberResults.add(new LottoNumberResult(LottoRank.THIRD, 0));
        lottoNumberResults.add(new LottoNumberResult(LottoRank.SECOND, 0));
        lottoNumberResults.add(new LottoNumberResult(LottoRank.FIRST, 0));
        return lottoNumberResults;
    }

    private LottoNumberResult findLottoNumberResult(LottoRank lottoRank) {
        return lottoNumberResult.stream()
                .filter(lotto -> lotto.isEqualsRank(lottoRank))
                .findFirst()
                .orElse(null);
    }

    public List<LottoNumberResult> getLottoNumberResult() {
        return lottoNumberResult;
    }
}
