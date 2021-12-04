package step2.domain;

import step2.domain.dto.LottoWinningResult;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lotto {
    private final LottoWinningRules lottoWinningRules;
    private final List<LottoNumbers> lottoNumbersList;
//    private final List<Integer> lottoNumbers;
    private final int price;

    Lotto(LottoWinningRules lottoWinningRules, List<LottoNumbers> lottoNumbersList, int price) {
        this.lottoWinningRules = lottoWinningRules;
        this.lottoNumbersList = lottoNumbersList;
        this.price = price;
    }




    public int numberOfLottoNumbers(){
        return lottoNumbersList.size();
    }


    public Map<Integer, Integer> countNumberOfMatching(LottoWinningNumbers lottoWinningNumbers){
        Map<Integer, Integer> map = new HashMap<>();
        for(LottoNumbers lottoNumbers : lottoNumbersList){
            int numberOfMatching = lottoNumbers.numberOfMatching(lottoWinningNumbers);
            if(map.containsKey(numberOfMatching)){
                map.put(numberOfMatching, map.get(numberOfMatching) + 1);
            }else{
                map.put(numberOfMatching, 1);

            }
        }
        return map;

    }


    public int prizeMoney(LottoWinningNumbers lottoWinningNumbers){
        Map<Integer, Integer> map = countNumberOfMatching(lottoWinningNumbers);
        return map.entrySet().stream().map((m) -> lottoWinningRules.getPrizeOf(m.getKey()) * m.getValue()).reduce(0, Integer::sum);
    }
    public int prizeMoney(Map<Integer, Integer> countNumberOfMatching){
        return countNumberOfMatching.entrySet().stream().map((m) -> lottoWinningRules.getPrizeOf(m.getKey()) * m.getValue()).reduce(0, Integer::sum);
    }

    public int earningRate(LottoWinningNumbers lottoWinningNumbers){
        int prizeMoney = prizeMoney(lottoWinningNumbers);
        return prizeMoney / price;
    }

    public int earningRate(Map<Integer, Integer> countNumberOfMatching){
        int prizeMoney = prizeMoney(countNumberOfMatching);
        return prizeMoney / price;
    }

    public int size(){
        return lottoNumbersList.size();
    }


    public List<LottoNumbers> getLottoNumbersList(){
        return Collections.unmodifiableList(lottoNumbersList);
    }

    public LottoWinningRules getLottoWinningRules() {
        return lottoWinningRules;
    }
//
//    private int numberOfMatches(LottoWinningNumbers lottoWinningNumbers) {
//        int numberOfMatching = 0;
//        for (int lottoNumber : lottoNumbers) {
//            if (lottoWinningNumbers.contain(lottoNumber)) {
//                numberOfMatching += 1;
//            }
//        }
//        return numberOfMatching;
//
//    }
//
//    public LottoWinningResult getWinningResult(LottoWinningNumbers lottoWinningNumbers){
//        int numberOfMatches = numberOfMatches(lottoWinningNumbers);
//        boolean winLotto = lottoWinningRules.winLotto(numberOfMatches);
//        int prize = lottoWinningRules.getPrizeOf(numberOfMatches);
//        return new LottoWinningResult(winLotto, numberOfMatches, prize);
//
//    }

}
