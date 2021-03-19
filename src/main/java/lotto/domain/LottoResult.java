package lotto.domain;

import lotto.common.LottoConstants;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LottoResult {

    private final Map<LottoRanking, Integer> lottoResult;

    public LottoResult() {
        this.lottoResult = Arrays.stream(LottoRanking.values())
                .collect(Collectors.toMap(Function.identity(), count -> 0));
    }

    public void addLottoRankingCount(LottoRanking lottoRanking){
        if (lottoRanking != null) {
            lottoResult.put(lottoRanking, lottoResult.get(lottoRanking) + 1);
        }
    }

    public String result(List<LottoNumbers> purchaseLottoNumbers, LottoNumbers winningNumbers){

        for (LottoNumbers purchaseLottoNumber : purchaseLottoNumbers) {
            addLottoRankingCount(LottoRanking.lottoRanking(winningNumbers.correctCount(purchaseLottoNumber)));
        }

        float rateOfReturn = rateOfReturn(purchaseLottoNumbers.size() * LottoConstants.LOTTO_PRICE);

        String result = "";
        result += rankingPrintInfo();
        result += rateResultString(rateOfReturn);
        return result;
    }


    private String rateResultString(float rateOfReturn) {
        String result = LottoResultMessage.message(rateOfReturn);
        return String.format("총 수익률은 %s입니다.(기준이 1이기 때문에 결과적으로 %s라는 의미임", String.format("%.2f", rateOfReturn), result);
    }

    private float rateOfReturn(int inputMoney) {

        long sum = 0;

        for (LottoRanking lottoRanking : lottoResult.keySet()) {
            sum += Long.parseLong(lottoRanking.getPrice().replace(",", "")) * lottoResult.get(lottoRanking);
        }

        return (float) sum / inputMoney;
    }

    private String rankingPrintInfo() {
        return Arrays.stream(LottoRanking.values())
                .map((LottoRanking) -> LottoRanking.resultString(lottoResult.get(LottoRanking)))
                .sorted()
                .collect(Collectors.joining());
    }
}
