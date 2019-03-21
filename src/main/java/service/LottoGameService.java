package service;

import application.LottoGame;
import application.LottoGameResult;
import domain.Calculator;
import domain.Winning;
import view.InputPriceView;
import view.InputWinningView;
import view.LottoView;
import view.OutputResultView;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class LottoGameService {

    private LottoGame game;
    private Calculator calculator;

    public LottoGameService(InputPriceView view, Calculator calculator) {
        game = new LottoGame(view.getPrice(), new Random());
        this.calculator = calculator;
    }

    public List<LottoView> getPurchasedLottos() {
        return game.getLottos();
    }

    public int getPurchaseCount() {
        return game.getSize();
    }

    public OutputResultView start(InputWinningView view) {
        List<Integer> result = game.run(new Winning(view.getWinning()));

        List<Integer> score = mergeScore(result);
        double profit = calculator.result(score, game.getPrice());

        return new OutputResultView(score, profit);
    }

    private List<Integer> mergeScore(List<Integer> result) {
        List<Integer> score = Arrays.asList(0, 0, 0, 0, 0, 0, 0);
        result.stream()
                .filter(matchCount -> LottoGameResult.isInRange(matchCount))
                .forEach(matchCount -> score.set(matchCount, plus(score, matchCount)));
        return score;
    }

    private int plus(List<Integer> score, Integer v) {
        return score.get(v) + 1;
    }
}
