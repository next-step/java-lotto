package lotto;

import lotto.controller.LottoGames;
import lotto.view.LottoInput;
import lotto.view.StandardInputView;
import lotto.view.StandardOutputView;

public class LottoMain {
    public static void main(String[] args) {
        LottoInput input = new StandardInputView();
        LottoGames games = new LottoGames(input.getPurchacePrice());
        StandardOutputView outputView = new StandardOutputView();
        outputView.printBoughtLotto(games);
        int[] winner = input.getWinnerNumber();
        int bonusNumber = input.getBonusNumber();
        outputView.printStat(games, winner, bonusNumber);
    }
}
