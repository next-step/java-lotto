package lotto;

import lotto.domain.LottoMachine;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoResult;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.*;

public class LottoApplication {
    public static void main(String args[]) {
        int purchaseAmount = InputView.getPurchaseAmount();

        LottoMachine lottoMachine = new LottoMachine(purchaseAmount);

        int lottoCount = lottoMachine.getPurchaseLottoCount();
        ResultView.countOfLotto(lottoCount);

        Set<LottoNumbers> totalLottoNumbers = new HashSet<>();

        for (int i = 0; i < lottoMachine.getPurchaseLottoCount(); i++) {
            LottoNumbers generateLottoNumbers = lottoMachine.generateLottoNumber();
            ResultView.printLottoNumber(generateLottoNumbers);
            totalLottoNumbers.add(generateLottoNumbers);
        }
        //중복 있을 때 추가적으로 생성
        for (int i = 0; i < lottoMachine.getPurchaseLottoCount() - totalLottoNumbers.size(); i++) {
            LottoNumbers generateLottoNumbers = lottoMachine.generateLottoNumber();
            ResultView.printLottoNumber(generateLottoNumbers);
            totalLottoNumbers.add(generateLottoNumbers);
        }

        LottoNumbers winningLottoNumbers = LottoNumbers.of(InputView.getWinningNumber());

        LottoResult lottoResult = LottoResult.of(totalLottoNumbers, winningLottoNumbers);

        ResultView.printWinningStatistics(lottoResult);
        ResultView.printProfitRate(lottoResult.calculateProfitRate(purchaseAmount));

    }
}
