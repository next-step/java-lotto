package lotto.model;

import lotto.view.ResultView;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Game {
    private static final String BUY_EXCEPTION_MESSAGE = "로또 구매 가격은 장당 1000원입니다.";
    private List<Lotto> lottoList;

    private Game() {
    }

    public static Game buyingLotto(int prise) {
        Game game = new Game();
        int lottoCount = game.checkPrise(prise);

        game.lottoList = IntStream.range(0, lottoCount)
                .mapToObj(count -> Lotto.draw())
                .peek(ResultView::printLotto)
                .collect(Collectors.toList());

        return game;
    }

    public Prize result(Lotto beforeLotto) {
        return Prize.counting(beforeLotto, this.lottoList);
    }

    public List<Lotto> getLottoList() {
        return this.lottoList;
    }

    private int checkPrise(int prise) {
        int lottoCount = prise / 1000;
        if (prise < 1000 || prise % 1000 != 0) {
            throw new IllegalArgumentException(BUY_EXCEPTION_MESSAGE);
        }
        return lottoCount;
    }
}
