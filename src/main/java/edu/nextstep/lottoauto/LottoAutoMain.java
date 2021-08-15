/*
 * LottoAutoMain.java
 *
 * v0.1   2021.08.15
 */

package edu.nextstep.lottoauto;

import edu.nextstep.lottoauto.View.InputView;
import edu.nextstep.lottoauto.View.ResultView;
import edu.nextstep.lottoauto.strategy.AutoNumberMaker;
import edu.nextstep.lottoauto.strategy.NumberMaker;
import edu.nextstep.lottoauto.ticketManager.TicketManager;
import edu.nextstep.lottoauto.ticketManager.WinningPrizeResult;

public class LottoAutoMain {

    public static void main(String[] args) {
        // 구입금액 입력, 출력
        int payment = InputView.inputPayment();

        // 복권 생성
        TicketManager ticketManager = new TicketManager();
        NumberMaker numberMaker = new AutoNumberMaker();
        ticketManager.createTickets(payment, numberMaker);

        // 복권 출력
        ResultView.printTickets(ticketManager.getTickets());

        // 당첨 번호 입력, 출력
        String winningNumbersOfString = InputView.inputWinningNumbers();

        // 당첨 번호를 이용한 당첨 결과 생성
        ticketManager.setWinningNumbersFrom(winningNumbersOfString);
        WinningPrizeResult winningPrizeResult = ticketManager.makeWinningPrizeResult();

        // 당첨 통계(결과) 출력
        ResultView.printWinningPrizeResult(winningPrizeResult);

    }
}
