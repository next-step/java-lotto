package autolotto.controller;

import autolotto.domain.*;
import autolotto.strategy.LottoNumberGeneratorImpl;
import autolotto.ui.InputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoMain {
    public static void main(String[] args) {
        int ticketsCount = new Ticket(InputView.buyAmt()).toTicketCount();
        int manualLottoCount = 0;
        int autoLottoCount = 0;
        List<Lotto> lottoTotal = new ArrayList<>();
        List<Lotto> manualLottos = InputView.manualLotto();
        LottoGame lottoGame = new LottoGame(new LottoNumberGeneratorImpl());
        if(manualLottos!= null){
            manualLottoCount = manualLottos.size();
            System.out.println("manualLottoCount>>>"+manualLottoCount);
            autoLottoCount = ticketsCount - manualLottoCount;
        }

            lottoGame.getLottoTickets(autoLottoCount).orElse(Collections.emptyList());



        //         List<Lotto> lottoTickets = lottoGame.getLottoTickets(자동건수);
        //         List<Lotto> lottoTickets = lottoGame.getLottoTickets(수동건수);

        //모든 로또 티켓 출력
//        ResultView.printLottoNumber(lottoTickets);
//        통계도 동일
//        LottoStatistics lottoStatistics
//                = new LottoStatistics(lottoTickets, new WinLotto(new Lotto(InputView.lastWeekWinNumber()), InputView.bonusNumber()));

//        Map<Rank, Integer> rankIntegerMap = lottoStatistics.calcuratorRankCount();
//        ResultView.printStatistics(rankIntegerMap, lottoStatistics.calcuratorProfit(rankIntegerMap, ticketsCount));
    }
}