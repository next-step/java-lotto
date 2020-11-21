package lotto;

import lotto.controller.LottoGameController;
import lotto.domain.LottoGameResults;


public class LottoMain {

    public static void main(String[] args){

        int gameMoney = LottoGameController.inputGameMoney();

        LottoGameResults lottoGameResults = LottoGameController.execute(gameMoney);

        LottoGameController.showLottoTickets(lottoGameResults);

        String lastWinningNumbers = LottoGameController.getLastWinningNumbers();

        LottoGameController.getPrizeResult(lottoGameResults, lastWinningNumbers);

    }
}
