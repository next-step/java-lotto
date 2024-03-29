package auto_lotto.controller;

import auto_lotto.domain.LottoTicket;
import auto_lotto.domain.LottoVendingMachine;
import auto_lotto.domain.WinningStatistic;

import java.util.List;

public class LottoController {

    private final LottoVendingMachine lottoMachine;

    public LottoController(LottoVendingMachine lottoMachine) {
        this.lottoMachine = lottoMachine;
    }

    public void start() {
        //구매
        List<LottoTicket> lottoTickets = lottoMachine.receive(14000);

        //발권
        System.out.println(String.format("%n개를 구매했습니다.", lottoTickets.size()));


        //당첨본호를 입력
        List<Integer> winingNumberOfLastWeek = List.of(1, 2, 3, 4, 5, 6);

        //당첨통계
        List<WinningStatistic> winningStatistics = lottoMachine.checkIfWinningEntry(winingNumberOfLastWeek);

        //통계출력

        for (WinningStatistic winningStatistic : winningStatistics) {
            System.out.println("winningStatistic = " + winningStatistic);
        }
    }
}
