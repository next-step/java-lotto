package lotto.model;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static lotto.view.InputView.LOTTO_PRICE;

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

    public String result(List<LottoNumbers> purchaseLottoNumbers, WinningNumbers winningNumbers) {

        for (LottoNumbers purchaseLottoNumber : purchaseLottoNumbers) {
            addLottoRankingCount(LottoRanking.lottoRanking(purchaseLottoNumber.correctCount(winningNumbers.winningNumbers())));
        }

        float rateOfReturn = rateOfReturn(purchaseLottoNumbers.size() * LOTTO_PRICE);

        return new StringBuilder().append(rankingPrintInfo()).append(rateResultString(rateOfReturn)).toString();
    }


    private String rateResultString(float rateOfReturn) {
        return String.format("총 수익률은 %s입니다.(기준이 1이기 때문에 결과적으로 %s라는 의미임", String.format("%.2f", rateOfReturn), LottoResultMessage.message(rateOfReturn));
    }

    private float rateOfReturn(int inputMoney) {

        long sum = 0;

        for (LottoRanking lottoRanking : lottoResult.keySet()) {
            sum += (long) lottoRanking.getPrice() * lottoResult.get(lottoRanking);
        }

        return (float) sum / inputMoney;
    }


    private String rankingPrintInfo() {
        return Arrays.stream(LottoRanking.values())
                .filter(ranking -> !ranking.equals(LottoRanking.MISS))
                .map((LottoRanking) -> resultString(LottoRanking, lottoResult.get(LottoRanking)))
                .sorted()
                .collect(Collectors.joining());
    }

    public String resultString(LottoRanking lottoRanking, int count) {
        return String.format("%d개 일치 (%d원)- %d개\n", lottoRanking.getCorrectCount(), lottoRanking.getPrice(), count);
    }
}
