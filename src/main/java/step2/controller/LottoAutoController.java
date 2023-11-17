package step2.controller;

import step2.model.Lotto;
import step2.model.LottoMake;
import step2.model.LottoWinner;
import step2.view.InputView;
import step2.view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoAutoController {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        int payPrice = inputView.payPriceInput();
        OutputView outputView = new OutputView();

        outputView.viewLottoCount(payPrice);

        List<Lotto> lottos = new LottoMake(payPrice).makeLottos();
        outputView.viewLotto(lottos);

        String lastWinNumbers = inputView.putLastWinNumbers();
        LottoWinner lottoWinner = new LottoWinner(lottos);

        Map<Integer, Long> winnerScore = lottoWinner.getWinnerScore(lastWinNumbers);
        outputView.viewLottoRating(winnerScore);

        outputView.viewRating(lottoWinner.getRating(payPrice));
    }
}
