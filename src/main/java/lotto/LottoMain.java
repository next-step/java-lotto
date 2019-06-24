package lotto;

import java.util.List;

public class LottoMain {

    public static void main(String[] arg) {
        int inputLottoGames = InputView.inputLotteGames();

        LottoGamesExecute lottoGamesExecute = new LottoGamesExecute(inputLottoGames);
        List <Lotto> lottos = lottoGamesExecute.extractLottoNumbers();
        OutputView.printPurchaseLottoNumber(lottos);

        String inputLastWeekLottoNumber = InputView.inputLastWeekLottoNumber();
        LottoGames lottoGames = lottoGamesExecute.lottoGameResult(inputLastWeekLottoNumber);
        OutputView outputView = new OutputView(lottoGames);
        outputView.printWinnerSummary();
        outputView.printRateOfReturn();
    }

}
