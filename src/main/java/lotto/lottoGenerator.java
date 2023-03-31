package lotto;

import lotto.domain.LottoGame;
import lotto.domain.LottoTicket;
import lotto.domain.WinningNumber;
import lotto.domain.enums.LottoRank;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.Map;

public class lottoGenerator {
    private static final int DEFAULT_PURCHASE = 1000;

    public static void main(String[] args) {
        InputView inputView = new InputView();
        int buyPrice = inputView.inputMoney(); //(총)구입금액
        int buyManualPrice = inputView.inputManualMoney(); //수동구매금액
        buyPrice = buyPrice - buyManualPrice; // 자동구매금액 = 구입금액-수동구매금액

        LottoGame lottoGame = new LottoGame(buyPrice,buyManualPrice);

        /*수동구매*/
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        ArrayList<LottoTicket> ticket2 = lottoGame.buyLotto2(buyManualPrice/DEFAULT_PURCHASE, buyPrice/DEFAULT_PURCHASE);


        ResultView resultView2 = new ResultView();
        resultView2.printBuyTicket(buyManualPrice/DEFAULT_PURCHASE, buyPrice/DEFAULT_PURCHASE);


        /*자동구매*/
        ArrayList<LottoTicket> ticket = lottoGame.buyLotto();


        ticket.addAll(ticket2);

        ArrayList<Integer> winningNums = inputView.inputWinningNum();
        int bonusNum = inputView.inputBonusNum();
        WinningNumber winningNumber = new WinningNumber(winningNums, bonusNum);

        Map<LottoRank, Integer> result = LottoRank.getResult(winningNumber, ticket);
        double totalRate = lottoGame.calculateRate(result);

        ResultView resultView = new ResultView();
        resultView.printResult(result, totalRate);
    }
}