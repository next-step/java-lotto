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
            LottoNumbers lottoNumbers = lottoMachine.generateLottoNumber();
            ResultView.printLottoNumber(lottoNumbers);
            lottoNumbersSet.add(lottoNumbers);
        }
        //중복 있을 때 추가적으로 생성
        for(int i = 0; i <  lottoMachine.getPurchaseLottoCount() - lottoNumbersSet.size(); i++){
            LottoNumbers lottoNumbers = lottoMachine.generateLottoNumber();
            ResultView.printLottoNumber(lottoNumbers);
            lottoNumbersSet.add(lottoNumbers);
        }

        LottoNumbers winningLottoNumbers = LottoNumbers.of(InputView.getWinningNumber());

        System.out.println(winningLottoNumbers);
//
//        int[] matchingRecords = lottoNumbers.getMatchingRecords(winningLottoNumber);
//
//        ResultView.printWinningStatistics(matchingRecords);
//
//        ResultView.printProfitRate(lottoMachine.calculateProfitRate(matchingRecords));

    }
}
