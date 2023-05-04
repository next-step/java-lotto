package lotto;

import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LottoMain {
    public static void main(String[] args) {
        InputView inputView = new InputView(new Scanner(System.in));
        ResultView resultView = new ResultView();
        LottoGame lottoGame = new LottoGame(
                new LottoNumberGenerator(),
                new ArrayList<>()
        );

        lottoGame.buyLotto(inputView.price());
        inputView.buy(lottoGame);
        resultView.view(lottoGame.lottos());

        List<LottoNumber> winNumber = inputView.result();
        LottoScore lottoScore = lottoGame.result(winNumber);

        resultView.result(lottoScore);
    }


}
