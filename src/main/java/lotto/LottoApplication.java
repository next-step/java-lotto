package lotto;

import lotto.domain.LottoMachine;
import lotto.domain.LottoNumbers;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.*;

public class LottoApplication {
    public static void main(String args[]) {
        int purchaseAmount = InputView.getPurchaseAmount();

        LottoMachine lottoMachine = new LottoMachine(purchaseAmount);

        int lottoCount = lottoMachine.getPurchaseLottoCount();
        ResultView.countOfLotto(lottoCount);

        Set<LottoNumbers> lottoResult = new HashSet<>();
        for (int i = 0; i < lottoMachine.getPurchaseLottoCount(); i++) {
            LottoNumbers lottoNumbers = lottoMachine.generateLottoNumber();
            ResultView.printLottoNumber(lottoNumbers);
            lottoResult.add(lottoNumbers);
        }
        //중복 있을 때 추가적으로 생성
        for(int i = 0; i <  lottoMachine.getPurchaseLottoCount() - lottoResult.size(); i++){
            LottoNumbers lottoNumbers = lottoMachine.generateLottoNumber();
            ResultView.printLottoNumber(lottoNumbers);
            lottoResult.add(lottoNumbers);
        }

        LottoNumbers winningLottoNumbers = LottoNumbers.of(InputView.getWinningNumber());

        Map<LottoRankEnum, Integer> lottoPrice = new HashMap<>();
        for(LottoNumbers lottoNumbers : lottoResult){
            int matchCount = lottoNumbers.getMatchCount(winningLottoNumbers);

            if(matchCount > 2) {
                LottoRankEnum lottoRankEnum = LottoRankEnum.valueOf(matchCount);
                lottoPrice.put(lottoRankEnum, lottoPrice.get(lottoRankEnum) + 1);
            }
        }

        System.out.println(winningLottoNumbers);
//
//        int[] matchingRecords = lottoNumbers.getMatchingRecords(winningLottoNumber);
//
//        ResultView.printWinningStatistics(matchingRecords);
//
//        ResultView.printProfitRate(lottoMachine.calculateProfitRate(matchingRecords));

    }
}
