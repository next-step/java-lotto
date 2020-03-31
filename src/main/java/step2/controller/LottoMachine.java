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

        int lottoCount = money.getLottoCount();
        Lottos lottos = createLottos(lottoCount);
        resultView.showLottos(lottos, lottoCount);

        LottoResult result = makeLottoResult(inputView, lottos);
        resultView.showResult(result, money);
    }

    public Lottos createLottos(int lottoCount) {
        return LottoProvider.createLottos(lottoCount);
    }

    public WinningLotto createWinningLotto(List<Integer> inputNumbers, int bonusNumber) {
        return LottoProvider.createWinningLotto(inputNumbers, bonusNumber);
    }

    public LottoResult makeLottoResult(InputView inputView, Lottos lottos) {
        WinningLotto winningLotto = createWinningLotto(inputView.getWinningNumbers(), inputView.getBonusNumber());

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
