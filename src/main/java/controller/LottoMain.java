package controller;


import domain.LottoGame;
import domain.LottoResults;
import domain.Lottos;
import strategy.RandomNumberGenerator;
import util.SplitUtil;
import view.InputView;
import view.ResultView;

public class LottoMain {

    public static final String DELIMETER = ",";

    public static void main(String[] args) {
        int buyPrice = InputView.inputBuyPrice();

        LottoGame lottoGame = new LottoGame(buyPrice);

        ResultView.viewBuyAmount(lottoGame.getBuyAmount());
        Lottos lottos = lottoGame.issue(new RandomNumberGenerator());
        ResultView.viewIssuedLotto(lottos);

        String winningNumbers = InputView.inputWinningNumber();
        LottoResults prizes = lottos.getPrizes(SplitUtil.splitToNumber(winningNumbers, DELIMETER));

        ResultView.viewPrize(prizes);
        ResultView.viewWinningRate(buyPrice, prizes);
    }
}
