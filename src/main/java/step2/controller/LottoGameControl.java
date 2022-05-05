package step2.controller;

import step2.domain.LottoWinners;
import step2.domain.Lottos;
import step2.domain.RandomPick;
import step2.service.LottoGameService;
import step2.view.InputView;
import step2.view.ResultView;

import java.util.List;

public class LottoGameControl {
    private final InputView inputView;
    private final ResultView resultView;

    public LottoGameControl() {
        this(new InputView(), new ResultView());
    }

    public LottoGameControl(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void start() {
        int money = inputView.inputMoney();
        Lottos lottos = new Lottos(money, new RandomPick());
        resultView.lottoCount(lottos.size());
        for (int i = 0; i < lottos.size(); i++) {
            resultView.displayLottoNumber(lottos.numbers(i));
        }

        LottoGameService lottoGameService =
                new LottoGameService(inputView.lottoNumbers(), inputView.bonusBall());
        LottoWinners winners = lottoGameService.match(lottos);
        double rate = lottoGameService.moneyProfitRate(money, winners);

        resultView.display(winners, rate);
    }
}
