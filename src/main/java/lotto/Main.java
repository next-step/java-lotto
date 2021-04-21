package lotto;

import lotto.View.InputView;
import lotto.View.ResultView;
import lotto.domain.*;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        int purchaseAmount = InputView.inputPurchaseAmount();
        int purchaseNum = LottoMachine.calculatePurchaseNum(purchaseAmount);
        ResultView.printPurchaseNum(purchaseNum);

        List<Lotto> lottos = LottoMachine.ticketingLotto(purchaseNum);
        PurchasedLottos purchasedLottos = new PurchasedLottos(lottos);
        String lottoNumbers = purchasedLottos.lottoNumbersToString();
        ResultView.printLottoNumbers(lottoNumbers);

        String stringWinNumbers = InputView.inputWinNumber();
        WinNumbers winNumbers = new WinNumbers(stringWinNumbers);

        Map<Long, Integer> countLottoPerCorrectNum = Statistic.countLottoPerCorrectNum(purchasedLottos.correctNumbersPerEachLotto(winNumbers.getWinNumbers()));
        ResultView.printStatistics(purchaseAmount,countLottoPerCorrectNum);



    }

}
