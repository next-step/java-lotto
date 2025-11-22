package lotto.domain;

import lotto.domain.constant.LottoRank;

import java.util.ArrayList;
import java.util.List;

public class LottoResult {

    private static List<LottoNumberResult> lottoNumberResults = new ArrayList<>();

    static {
        lottoNumberResults.add(new LottoNumberResult(LottoRank.FIFTH, 0));
        lottoNumberResults.add(new LottoNumberResult(LottoRank.FOURTH, 0));
        lottoNumberResults.add(new LottoNumberResult(LottoRank.THIRD, 0));
        lottoNumberResults.add(new LottoNumberResult(LottoRank.SECOND, 0));
        lottoNumberResults.add(new LottoNumberResult(LottoRank.FIRST, 0));
    }

    public static double profitPercent(LottoPrice lottoPrice) {
        return lottoPrice.profitPercent(totalResultPrice());
    }

    private static int totalResultPrice() {
        return lottoNumberResults.stream()
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
        return lottoNumberResults;
    }


    private LottoNumberResult findLottoNumberResult(LottoRank lottoRank) {
        return lottoNumberResults.stream()
                .filter(lotto -> lotto.isEqualsRank(lottoRank))
                .findFirst()
                .orElse(null);
    }

    public List<LottoNumberResult> getLottoNumberResult() {
        return lottoNumberResults;
    }
}
