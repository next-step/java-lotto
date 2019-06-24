package lotto;

import java.util.List;

public class LottoMain {

    private static final int LOTTO_ONE_GAME_PRICE = 1000;

    public static void main(String[] arg) {
        int inputLottoGamePrice = InputView.inputLotteGames();
        LottoGamesExecute lottoGamesExecute = new LottoGamesExecute();
        List<Lotto> lottos = lottoGamesExecute.extractLottoNumbers(createLottoGameCount(inputLottoGamePrice));
        OutputView.printPurchaseLottoNumber(lottos);

        String inputLastWeekLottoNumber = InputView.inputLastWeekLottoNumber();
        LottoGames lottoGames = lottoGamesExecute.lottoGameResult(inputLastWeekLottoNumber);
        OutputView.printWinnerSummary(lottoGames);
        OutputView.printRateOfReturn(inputLottoGamePrice);
    }

    private static int createLottoGameCount(int inputLottoGames) {
        return inputLottoGames / LOTTO_ONE_GAME_PRICE;
    }

}
