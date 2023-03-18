package lotto.domain;

import lotto.view.LottoMessage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoResult {

    private Map<LottoRank, Integer> lottoResultSet = new HashMap<>();
    private List<LottoNumbers> lottoNumberList;
    private WinLottoNumber winLottoNumber;
    private int purchasesNumber;

    public LottoResult(List<LottoNumbers> lottoNumberList, int purchasesNumber, WinLottoNumber winLottoNumber) {
        this.lottoNumberList = lottoNumberList;
        this.purchasesNumber = purchasesNumber;
        this.winLottoNumber = winLottoNumber;
        lottoResultsStatistics();
        lottoResultReturns();
    }

    private void lottoResultsStatistics() {
        LottoRank lottoRank;

        for (int i = 0; i < lottoNumberList.size(); i++) {
            lottoRank = winLottoNumber.matchingLottoNumber(lottoNumberList.get(i));
            if (lottoRank != null) {
                lottoResultSet.put(lottoRank, (lottoResultSet.containsKey(lottoRank) ? lottoResultSet.get(lottoRank) : 0) + 1);
            }
        }
        LottoMessage.getLottoRankMessage(lottoResultSet);
    }

    private void lottoResultReturns() {
        double result = 0;

        for (Map.Entry<LottoRank, Integer> resultSet : lottoResultSet.entrySet()) {
            result += resultSet.getKey().getReward() * (lottoResultSet.containsKey(resultSet.getKey()) ? lottoResultSet.get(resultSet.getKey()) : 0);
        }

        result = Math.round(result / (double) purchasesNumber * 100) / 100.0;
        LottoMessage.getLottoResultMessage(String.valueOf(result));
    }
}