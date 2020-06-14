package lotto;

import lotto.controller.LottoGames;
import lotto.model.LottoLine;
import lotto.model.LottoResult;
import lotto.view.LottoInput;
import lotto.view.StandardInputView;
import lotto.view.StandardOutputView;

public class LottoMain {
    public static void main(String[] args) {
        LottoInput input = new StandardInputView();
        LottoGames games = new LottoGames(input.getPurchacePrice());
        StandardOutputView outputView = new StandardOutputView();
        outputView.printBoughtLotto(games);
        LottoResult result = new LottoResult(input.getWinnerLine(), input.getBonusNumber());
        outputView.printStat(games, result);
    }
}
