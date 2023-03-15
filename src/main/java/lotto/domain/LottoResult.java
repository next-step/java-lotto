package lotto.domain;

import lotto.view.LottoMessage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoResult {

    private Map<Integer, Integer> lottoResultSet = new HashMap<>();
    private LottoMessage lottoMessage = new LottoMessage();
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

    public void lottoResultsStatistics() {
        for (int i = 0; i < lottoNumberList.size(); i++) {
            int count = 0;
            boolean bonusYN = false;

            count = lottoNumberList.get(i).getLottoNumber()
                    .stream().filter(e -> winLottoNumber.getBeforeLottoNumber().getLottoNumber().contains(e))
                    .collect(Collectors.toList()).size();

            if (count == 5) {
                bonusYN = lottoNumberList.get(i).getLottoNumber().contains(winLottoNumber.getBonusNumber());
                if (bonusYN) {
                    count = 7;
                }
            }
            lottoResultSet.put(count, (lottoResultSet.containsKey(lottoResultSet.get(count)) ? lottoResultSet.get(count) : 0) + 1);
        }
        lottoMessage.getLottoRankMessage(lottoResultSet);
    }

    private void lottoResultReturns() {
        double result = 0;

        for (LottoRank lottoRank : LottoRank.values()) {
            result += LottoRank.lottoRankValue(lottoRank.getKeyNumber()) * (lottoResultSet.containsKey(lottoRank.getKeyNumber()) ? lottoResultSet.get((lottoRank.getKeyNumber())) : 0);
        }
        result = Math.round(result / (double) purchasesNumber * 100) / 100.0;

        lottoMessage.getLottoResultMessage(String.valueOf(result));
    }
}