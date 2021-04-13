package lotto;

import lotto.View.InputView;
import lotto.View.ResultView;
import lotto.domain.Lottos;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        Lottos lottos = new Lottos();

        int purchaseAmount = InputView.inputPurchaseAmount();
        int purchaseNum = lottos.calculatePurchaseNum(purchaseAmount);
        ResultView.printPurchaseNum(purchaseNum);

        lottos.initializeLottoNumbers();
        String lottoNumbers = lottos.lottoNumbersToString();
        ResultView.printLottoNumbers(lottoNumbers);

        String stringWinNumbers = InputView.inputWinNumber();
        List<Integer> winNumbers = lottos.winNumbers(stringWinNumbers);


    }

}
