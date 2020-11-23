package step2;

import step2.controller.LottoController;
import step2.view.InputView;
import step2.view.ResultView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LottoMain {
    private InputView inputView;
    private ResultView resultView;
    private LottoController lottoController;

    public LottoMain() {
        this.inputView = new InputView();
        this.resultView = new ResultView();
        this.lottoController = new LottoController();
    }

    public void run() {
        int fee = inputView.getFee();
        List<Object[]> lottos = lottoController.buyLotto(fee);
        resultView.showLottos(lottos);


    }
}
