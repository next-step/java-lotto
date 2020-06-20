package lotto;

import lotto.controller.LottoGames;
import lotto.model.LottoResult;
import lotto.view.LottoInput;
import lotto.view.StandardInputView;
import lotto.view.StandardOutputView;

public class LottoMain {
    public static void main(String[] args) {
        LottoInput input = new StandardInputView();
        StandardOutputView outputView = new StandardOutputView();
        LottoGames games = new LottoGames.LottoGamesBuilder(input.getPurchasePrice())
                .manualLines(input.getManualLottoLines())
                .build(outputView);
        LottoResult result = new LottoResult(input.getWinnerLine(), input.getBonusNumber());
        outputView.printStat(games, result);
    }
}
