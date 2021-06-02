package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoManager {
    private InputView inputView;
    private ResultView resultView;

    public LottoManager(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        LottoManager manager = new LottoManager(inputView,resultView);

        manager.playLotto();
    }

    private void playLotto() {
        int money = inputView.takeMoney();

        LottoNumberFactoryImpl factory = new LottoNumberFactoryImpl(new RandomStrategy());
        Lottos lottos = new Lottos(factory,money);

        resultView.showLottoGames(lottos);

        List<Integer> lottoNumbers = inputView.takeLottoNumbers();
        Integer bonuseNumber = inputView.takeBonusNumber();
        factory.setGenerateStrategy(new CustomStrategy(lottoNumbers));

        resultView.showLottoStatics(lottos.calculateStatics(new WinLotto(new Lotto(factory),bonuseNumber)));
    }
}
