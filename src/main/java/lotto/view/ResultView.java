package lotto.view;

import lotto.domain.LottoGame;
import lotto.domain.LottoGames;
import lotto.domain.LottoStatics;

import java.io.PrintStream;

public class ResultView {
    PrintStream view = new PrintStream(System.out);

    public void enter() {
        view.println("");
    }

    public void println(Object obj) {
        view.println(obj);
    }

    public void showLottoGames(LottoGames lottoGames) {
        for (LottoGame game : lottoGames) {
            println(game);
        }
        enter();
    }

    public void showLottoStatics(LottoStatics statics) {
        println(statics);
    }
}
