package lotto;

import lotto.domain.LottoMachine;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoApplication {
    public static void main(String args[]) {
        int purchaseAmount = InputView.getPurchaseAmount();

        LottoMachine lottoMachine = new LottoMachine(purchaseAmount);

        int lottoCount = lottoMachine.getPurchaseLottoCount();
        ResultView.countOfLotto(lottoCount);

        Set<LottoNumbers> lottoNumbersSet = new HashSet<>();
        for (int i = 0; i < lottoMachine.getPurchaseLottoCount(); i++) {
            lottoNumbersSet.add(lottoMachine.generateLottoNumber());
        }
        //중복 있을 때 추가적으로 생성
        for(int i = 0; i <  lottoMachine.getPurchaseLottoCount() - lottoNumbersSet.size(); i++){
            lottoNumbersSet.add(lottoMachine.generateLottoNumber());
        }
//
//        LottoNumbers lottoNumbers = LottoNumbers.of(lottoNumberList);
//
//        LottoNumber winningLottoNumber = new LottoNumber(InputView.getWinningNumber());
//
//        int[] matchingRecords = lottoNumbers.getMatchingRecords(winningLottoNumber);
//
//        ResultView.printWinningStatistics(matchingRecords);
//
//        ResultView.printProfitRate(lottoMachine.calculateProfitRate(matchingRecords));

    }
}
