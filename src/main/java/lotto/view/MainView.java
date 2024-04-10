package lotto.view;

import lotto.domain.LottoGame;
import lotto.domain.LottoMatchNumber;
import lotto.domain.LottoTicket;

import java.util.HashMap;
import java.util.List;

import static lotto.view.InputView.userInputInteger;
import static lotto.view.InputView.userInputString;
import static lotto.view.ResultView.*;

public class MainView {

    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame();

        int money = userInputInteger("구입금액을 입력해 주세요.");
        printLottoTickets(lottoGame.buyLottoTicket(money));

        System.out.println();
        lottoGame.inputTargetNumbers(userInputString("지난 주 당첨 번호를 입력해 주세요."));

        System.out.println();
        HashMap<LottoMatchNumber, Integer> results = lottoGame.winLotto();
        printWinLottoResult(results);
        printIncomeResult(lottoGame.checkIncome(results, money));
    }
}
