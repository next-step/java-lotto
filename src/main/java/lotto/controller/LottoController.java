package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.util.LottoUtils;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;
import java.util.Scanner;

public class LottoController {

    private static final InputView inputView = new InputView(new Scanner(System.in));
    private static final ResultView resultView = new ResultView();

    public static void main(String[] args) {
        lotto();
    }

    public static void lotto() {

        int lottoPriceStr = Integer.parseInt(inputView.setBuyLottoPrice());

        int lottoGameCount = LottoUtils.getLottoGameCount(lottoPriceStr);

        Lotto lotto = new Lotto();
        lotto.buyLottoGames(lottoGameCount);

        List<LottoGame> lottoGames = lotto.getLottoGames();

        resultView.resultOfBuyLotto(lottoGameCount);
        resultView.resultOfLottoGameList(lottoGames);

        String lottoResultNumber = inputView.setLottoResultNumber();


        resultView.resultGame();
    }
}
