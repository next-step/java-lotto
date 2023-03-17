package lotto.domain;

import lotto.view.LottoMessage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoResult {

    private Map<Integer, Integer> lottoResultSet = new HashMap<>();
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
        for (int i = 0; i < lottoNumberList.size(); i++) {
            int resultCount = winLottoNumber.matchingLottoNumber(lottoNumberList.get(i));
            lottoResultSet.put(resultCount, (lottoResultSet.containsKey(lottoResultSet.get(resultCount)) ? lottoResultSet.get(resultCount) : 0) + 1);
        }
        LottoMessage.getLottoRankMessage(lottoResultSet);
    }

    private void lottoResultReturns() {
        double result = 0;

        for (LottoRank lottoRank : LottoRank.values()) {
            result += LottoRank.lottoRankValue(lottoRank.getKeyNumber()) * (lottoResultSet.containsKey(lottoRank.getKeyNumber()) ? lottoResultSet.get((lottoRank.getKeyNumber())) : 0);
        }
        result = Math.round(result / (double) purchasesNumber * 100) / 100.0;

        LottoMessage.getLottoResultMessage(String.valueOf(result));
    }
}