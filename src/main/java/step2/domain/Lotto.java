package step2.domain;

import step2.domain.dto.LottoWinningResult;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final LottoWinningRules lottoWinningRules;
    private final List<LottoNumbers> lottoNumbersList;
//    private final List<Integer> lottoNumbers;
    private int price;

    Lotto(LottoWinningRules lottoWinningRules, List<LottoNumbers> lottoNumbersList) {
        this.lottoWinningRules = lottoWinningRules;
        this.lottoNumbersList = lottoNumbersList;
    }

    public int numberOfLottoNumbers(){
        return lottoNumbersList.size();
    }

//    public List<Integer> getLottoNumbers(){
//        return Collections.unmodifiableList(lottoNumbers);
//    }
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
