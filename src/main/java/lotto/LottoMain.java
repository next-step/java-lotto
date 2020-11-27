package lotto;

import lotto.controller.LottoGameController;
import lotto.domain.LottoGameResults;

import java.util.List;


public class LottoMain {

    public static void main(String[] args){

        int gameMoney = LottoGameController.inputGameMoney();
        int manualTicketCount = LottoGameController.inputManualTicketCount();

        List<String> manualTicket = LottoGameController.inputManualTicket(manualTicketCount);

        LottoGameResults lottoGameResults = LottoGameController.execute(gameMoney, manualTicket);

        LottoGameController.showLottoTickets(lottoGameResults);

        String lastWinningNumbers = LottoGameController.getLastWinningNumbers();
        String bonusNumber = LottoGameController.getLastBonusNumber();

        LottoGameController.getPrizeResult(lottoGameResults, lastWinningNumbers, bonusNumber);

    }
}
