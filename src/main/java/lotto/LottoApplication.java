package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.view.InputView;
import lotto.view.ResultView;

import static lotto.view.InputView.inputInt;
import static lotto.view.InputView.inputStr;
import static lotto.view.ResultView.printLottoGames;

public class LottoApplication {
    public static void main(String[] args) {
        int price = inputInt(ResultView::printInputPrice);
        LottoGame lottoGame = new LottoGame(price);
        printLottoGames(lottoGame);
        Lotto winningLotto = new Lotto(inputStr(ResultView::printLastWeekLotto));

    }



}
