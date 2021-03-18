package lotto.domain;

import lotto.common.LottoConstants;

import java.util.*;
import java.util.stream.Collectors;

public class LottoResult {
    public String result(List<LottoNumbers> purchaseLottoNumbers, LottoNumbers winningNumbers){

        for (LottoNumbers purchaseLottoNumber : purchaseLottoNumbers) {
            addLottoRanking(winningNumbers.correctCount(purchaseLottoNumber));
        }

        float rateOfReturn = getRateOfReturn(purchaseLottoNumbers.size() * LottoConstants.LOTTO_PRICE);

        String result = "";
        result += getRankingPrintInfo();
        result += getRateResultString(rateOfReturn);
        return result;
    }


    private String getRateResultString(float rateOfReturn) {
        String result = LottoResultMessage.message(rateOfReturn);
        return String.format("총 수익률은 %s입니다.(기준이 1이기 때문에 결과적으로 %s라는 의미임", String.format("%.2f", rateOfReturn), result);
    }

    private float getRateOfReturn(int inputMoney) {
        long sum = Arrays.stream(LottoRanking.values())
                .map(LottoRanking::getResultMoney)
                .mapToLong(Long::longValue).sum();

        return (float) sum / inputMoney;
    }

    private String getRankingPrintInfo() {
        return Arrays.stream(LottoRanking.values())
                .map(LottoRanking::getResultString)
                .sorted()
                .collect(Collectors.joining());
    }

    private void addLottoRanking(int correctCount){
        LottoRanking lottoRaking = LottoRanking.getLottoRaking(correctCount);
        if (lottoRaking != null) {
            lottoRaking.addCount();
        }
    }
}
