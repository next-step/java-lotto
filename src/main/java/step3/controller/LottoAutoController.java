package step3.controller;

import step3.enumeration.LottoRank;
import step3.model.*;
import step3.view.InputView;
import step3.view.OutputView;

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
        int bonusNumber = inputView.bonusNumberInput();

        LottoWinner lottoWinner = new LottoWinner(lottos, new LottoWinNumbers(lastWinNumbers), bonusNumber);

        Map<LottoRank, Integer> winnerScore = lottoWinner.getWinnerNumberMatchCount();
        outputView.viewLottoRating(winnerScore);

        outputView.viewRating(lottoWinner.getRating(payPrice, winnerScore));
    }
}
