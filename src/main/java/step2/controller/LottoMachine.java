package step2.controller;

import step2.domain.*;
import step2.view.InputView;
import step2.view.ResultView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoMachine {
    private static ResultView resultView;
    private static LottoMachine lottoMachine;

    private LottoMachine() {
        this.resultView = new ResultView();
    }

    public void operate(InputView inputView) {
        Money money = new Money(inputView.getMoney());

        Lottos lottos = createLottos(money);
        resultView.showLottos(lottos, money.getLottoCount());

        LottoResult result = makeLottoResult(inputView, lottos);
        resultView.showResult(result, money);
    }

    public Lottos createLottos(Money money) {
        int lottoCount = money.getLottoCount();

        Lottos lottos = LottoProvider.createLottos(lottoCount);
        return lottos;
    }

    public Lotto createWinningLotto(List<Integer> inputNumbers) {
        return LottoProvider.createLotto(inputNumbers);
    }

    public LottoResult makeLottoResult(InputView inputView, Lottos lottos) {
        Lotto winningLotto = createWinningLotto(inputView.getWinningNumbers());

        Map<LottoTier, Integer> resultMap = new HashMap<>();

        for(LottoTier lottoTier : LottoTier.values()) {
            resultMap.put(lottoTier, lottos.getLottoCountByTier(lottoTier, winningLotto));
        }
        return new LottoResult(resultMap);
    }

    public static LottoMachine getInstance() {
        if(lottoMachine == null) {
            lottoMachine = new LottoMachine();
        }
        return lottoMachine;
    }
}
