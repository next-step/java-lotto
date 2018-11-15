package lotto;

import java.util.List;

public class LottoGame {

    public static void main(String[] args) {
        LottoSystem lottoSystem = new LottoSystem();

        int lottoCost = InputView.inputCost();
        int lottoCount = lottoSystem.calcLottoCount(lottoCost);

        List<Lotto> lottos = lottoSystem.makeLottoList(lottoSystem.lottoNumbersSetting(), lottoCount);

        ResultView.showLottoCount(lottoCount);
        ResultView.showLottos(lottos);
        ResultView.moveLine();

        WinningLotto winningLotto = new WinningLotto(lottos);
        winningLotto.winNCheckNumber(InputView.inputPickNumbers());
        ResultView.moveLine();

        ResultView.showStatistics(Rank.makeWinResult(), Rank.makeWinPrice(),
                Profit.profitRate(Profit.totalPrice(Rank.makeWinResult(), Rank.makeWinPrice()), lottoCost));
    }

}
