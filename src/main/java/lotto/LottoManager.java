package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoNumberFactoryImpl;
import lotto.domain.Lottos;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.Arrays;
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

        LottoNumberFactoryImpl factory = new LottoNumberFactoryImpl();
        Lottos lottos = new Lottos(factory,money);

        resultView.showLottoGames(lottos);

        List<Integer> lottoNumbers = inputView.takeLottoNumbers();

        resultView.showLottoStatics(lottos.calculateStatics(Lottos.createLotto(factory,lottoNumbers)));
    }
}
