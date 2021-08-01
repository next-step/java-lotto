package lotto;

import lotto.domain.LottoMachine;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class LottoApplication {
    public static void main(String args[]) {
        int purchaseAmount = InputView.getPurchaseAmount();

        LottoMachine lottoMachine = new LottoMachine(purchaseAmount);

        int lottoCount = lottoMachine.getPurchaseLottoCount();
        ResultView.countOfLotto(lottoCount);

        List<LottoNumber> lottoNumberList = new ArrayList<>();
        for (int i = 0; i < lottoMachine.getPurchaseLottoCount(); i++) {
            LottoNumber lottoNumber = lottoMachine.generateLottoNumber();
            ResultView.printLottoNumber(lottoNumber);
            lottoNumberList.add(lottoNumber);
        }

        LottoNumbers lottoNumbers = LottoNumbers.of(lottoNumberList);

        LottoNumber winningLottoNumber = new LottoNumber(InputView.getWinningNumber());

        int[] matchingRecords = lottoNumbers.getMatchingRecords(winningLottoNumber);

        ResultView.printWinningStatistics(matchingRecords);

        ResultView.printProfitRate(lottoMachine.calculateProfitRate(matchingRecords));

    }
}
