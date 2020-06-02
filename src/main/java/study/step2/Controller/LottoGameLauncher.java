package study.step2.Controller;

import study.step2.domain.*;
import study.step2.dto.LottoGameRequestDto;
import study.step2.service.LottoGameService;
import study.step2.view.InputView;
import study.step2.view.ResultView;

import java.util.List;

public class LottoGameLauncher {
    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame(InputView.inputMoney());
        LottoGameService lottoGameService = new LottoGameService();
        List<LottoTicket> tickets = lottoGameService.purchaseLottos(lottoGame);
        ResultView.printPurchasedLottoTickets(tickets);

        List<Integer> matchingCounts = lottoGameService.matchWithLastWinningNumbers(tickets, InputView.inputLastWinningNumbers());
        Long prizeMoney = lottoGameService.totalPrizeMoney(matchingCounts);
        double earningsRate = lottoGame.getEarningsRate(prizeMoney);
        LottoGameRequestDto lottoGameRequestDto = new LottoGameRequestDto(matchingCounts, earningsRate);
        ResultView.printWinningStatisTics(lottoGameRequestDto);
    }
}
