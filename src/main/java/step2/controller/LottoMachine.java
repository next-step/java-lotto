package step2.controller;

import step2.domain.*;
import step2.view.InputView;
import step2.view.OutputView;

import java.util.HashMap;
import java.util.Map;

public class LottoMachine {
    private static final int LOTTO_PRICE = 1000;
    private static InputView inputView;
    private static OutputView outputView;
    private static LottoMachine lottoMachine;

    public LottoMachine() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void play() {
        int money = inputView.getMoney();
        int count = calculateLottoCount(money);

        Lottos lottos = LottoGenerator.generateLottos(count);
        outputView.printLottos(lottos, count);

        Lotto winningLotto = LottoGenerator.generateLotto(inputView.getWinningNumbers());

        LottoResult result = makeLottoResult(lottos, winningLotto);
        outputView.printResult(result, money);
    }

    private LottoResult makeLottoResult(Lottos lottos, Lotto winningLotto) {
        Map<LottoTier, Integer> resultMap = new HashMap<>();

        for(LottoTier lottoTier : LottoTier.values()) {
            resultMap.put(lottoTier, lottos.getLottoCountByTier(lottoTier, winningLotto));
        }

        return new LottoResult(resultMap);
    }

    public int calculateLottoCount(int inputMoney) {
        return inputMoney / LOTTO_PRICE;
    }
}
