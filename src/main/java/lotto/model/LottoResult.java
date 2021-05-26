package lotto.model;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LottoResult {

    private final Map<LottoRanking, Integer> lottoResult;

    public LottoResult() {
        this.lottoResult = Arrays.stream(LottoRanking.values())
                .collect(Collectors.toMap(Function.identity(), count -> 0));
    }

    public void addLottoRankingCount(LottoRanking lottoRanking) {
        if (lottoRanking != null) {
            lottoResult.put(lottoRanking, lottoResult.get(lottoRanking) + 1);
        }
    }

    public Map<LottoRanking, Integer> lottoResult(List<LottoNumbers> purchaseLottoNumbers, LottoNumbers winningNumbers) {

        for (LottoNumbers purchaseLottoNumber : purchaseLottoNumbers) {
            addLottoRankingCount(LottoRanking.lottoRanking(new WinningLotto(purchaseLottoNumber).correctCount(winningNumbers.lottoNumbers())));
        }

        return this.lottoResult;
    }

    public float rateOfReturn(int inputMoney) {
        long sum = 0;

        for (LottoRanking lottoRanking : lottoResult.keySet()) {
            sum += (long) lottoRanking.getPrice() * lottoResult.get(lottoRanking);
        }

        return (float) sum / inputMoney;
    }

}
