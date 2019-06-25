package lotto;

import java.util.List;

public class LottoMain {

    public static void main(String[] arg) {
        int inputLottoGamePrice = InputView.inputLotteGames();
        LottoGamesExecute lottoGamesExecute = new LottoGamesExecute();
        List<Lotto> lottos = lottoGamesExecute.extractLottoNumbers(createLottoGameCount(inputLottoGamePrice));
        OutputView.printPurchaseLottoNumber(lottos);

        String inputLastWeekLottoNumber = InputView.inputLastWeekLottoNumber();
        String inputLastWeekBonusNumber = InputView.inputLastWeekBonusNumber();
        LottoGames lottoGames = lottoGamesExecute.lottoGameResult(inputLastWeekLottoNumber, inputLastWeekBonusNumber);
        OutputView.printWinnerSummary(lottoGames);
        OutputView.printRateOfReturn(inputLottoGamePrice);
    }

    static int createLottoGameCount(int inputLottoGames) {
        int lottoOneGamePrice = NumberEnum.LOTTO_ONE_GAME_PRICE.value();
        if (inputLottoGames % lottoOneGamePrice > 0) {
            throw new IllegalStateException("로또 금액은 1000원 단위로 구매 하셔야 합니다.");
        }
        return inputLottoGames / lottoOneGamePrice;
    }

}
