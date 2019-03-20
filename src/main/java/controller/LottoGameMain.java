package controller;

import domain.Lotto;
import domain.LottoGame;
import domain.LottoResult;
import view.InputView;
import view.ResultView;

import java.util.List;

public class LottoGameMain {

    public static void main(String args[]) {
        int lottoCount = InputView.getLottoCountFromInputMoney();
        LottoGame lottoGame = new LottoGame(lottoCount);

        for (Lotto lotto:lottoGame.getLottos()){
            System.out.println(lotto.toString());
        }
        

        Lotto winner = InputView.getWinnerNoByString();

        List<LottoResult> result = lottoGame.calculateMatch(lottoGame.getLottos(), winner);

        ResultView.printProfitStatics(result);
        ResultView.printProfitRate(result, lottoCount * 1000);
    }
}
