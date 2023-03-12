package lotto.service;

import lotto.domain.LottoNumber;
import lotto.view.LottoMessage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static lotto.common.commonUtils.isnullCheck;

public class LottoResult {

    private Map<Integer, Integer> lottoResultSet = new HashMap<>();
    private List<LottoNumber> lottoNumberList;
    private LottoNumber resultLottoNumber;
    private int purchasesNumber;
    private int bonusNumber;

    public LottoResult(List<LottoNumber> lottoNumberList, LottoNumber resultLottoNumber, int purchasesNumber, int bonusNumber) {
        this.lottoNumberList = lottoNumberList;
        this.resultLottoNumber = resultLottoNumber;
        this.bonusNumber = bonusNumber;
        this.purchasesNumber = purchasesNumber;

        LottoResultsStatistics();
        LottoResultReturns();
    }

    public void LottoResultsStatistics() {
        for (int i = 0; i < lottoNumberList.size(); i++) {
            int count = 0;
            boolean bonusYN = false;

            count = lottoNumberList.get(i).getLottoNumber()
                    .stream().filter(x ->resultLottoNumber.getLottoNumber().contains(x))
                    .collect(Collectors.toList()).size();

            if(lottoResultSet.get(count) == null){
                lottoResultSet.put(count, 0);
            }

            if(count == 5){
                bonusYN = lottoNumberList.get(i).getLottoNumber().contains(bonusNumber);
                if(bonusYN){
                    count = 7;
                }
            }
            lottoResultSet.put(count, lottoResultSet.get(count) + 1);
        }
        new LottoMessage(resultLottoNumber).getLottoRankMessage(lottoResultSet);
    }

    public void LottoResultReturns(){
        double result = 0;

        for(LottoRank lottoRank : LottoRank.values()){
            result += LottoRank.lottoRankValue(lottoRank.getKeyNumber()) * isnullCheck(lottoResultSet.get((lottoRank.getKeyNumber())));
        }

        result = Math.round(result / (double) purchasesNumber * 100)/100.0;
        new LottoMessage(resultLottoNumber).getLottoResultMessage(String.valueOf(result));
    }
}