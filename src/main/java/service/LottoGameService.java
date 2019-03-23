package service;

import application.LottoGame;
import domain.Calculator;
import domain.Winning;
import view.InputPriceView;
import view.InputWinningView;
import view.LottoView;
import view.OutputResultView;

import java.util.List;
import java.util.Random;

public class LottoGameService {

    private LottoGame game;
    private Calculator calculator;

    public LottoGameService(InputPriceView view, Calculator calculator) {
        game = new LottoGame(view.getPrice(), new Random());
        this.calculator = calculator;
    }

    public OutputResultView start(InputWinningView view) {
        List<Integer> score = game.run(new Winning(view));
        double profit = calculator.run(score, game.getPrice());

        return new OutputResultView(score, profit);
    }

    public List<LottoView> getPurchasedLottos() {
        return game.getLottos();
    }

    public int getPurchaseCount() {
        return game.getSize();
    }
}
