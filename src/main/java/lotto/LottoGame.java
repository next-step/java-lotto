package lotto;

import lotto.domain.Lottos;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.Collections;
import java.util.List;

public class LottoGame {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        Lottos lottos = new Lottos();

        int price = inputView.buyLotto();
        lottos.addLotto(inputView.validateLotto(price));

        for(int i = 0; i < lottos.getSize(); i++) {
            resultView.lottoList(lottos.getLotto(i));
        }

        List<Integer> correctNumbers = inputView.lastWeekendNumber();

        Collections.sort(correctNumbers);

        for(int i = 0; i < lottos.getSize(); i++) {
            resultView.correctCheck(lottos.getLotto(i), correctNumbers);
        }

        resultView.printResult(price);
    }
}
