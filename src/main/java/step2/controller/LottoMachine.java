package step2.controller;

import step2.domain.*;
import step2.view.InputView;
import step2.view.ResultView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoMachine {
    private static final String TOO_MANY_MANUAL_COUNT_ERROR = "%s개 이하로 입력해주세요.";
    private static ResultView resultView;
    private static LottoMachine lottoMachine;

    private LottoMachine() {
        this.resultView = new ResultView();
    }

    public void operate(InputView inputView) {
        Money money = new Money(inputView.getMoney());
        Lottos lottos = createLottos(inputView, money);

        LottoResult result = makeLottoResult(inputView, lottos);
        resultView.showResult(result, money);
    }

    public Lottos createLottos(InputView inputView, Money money) {
        int lottoCount = money.getLottoCount();
        int manualLottoCount = inputView.getManualLottoCount();
        validateManualLottoCount(lottoCount, manualLottoCount);

        int autoLottoCount = lottoCount - manualLottoCount;

        List<Lotto> wholeLottos = new ArrayList<>();
        wholeLottos.addAll(LottoProvider.createLottos(inputView.getManualLottos(manualLottoCount)));
        wholeLottos.addAll(LottoProvider.createLottos(autoLottoCount));

        Lottos lottos = new Lottos(wholeLottos);
        resultView.showLottos(lottos, lottoCount);

        return lottos;
    }

    private void validateManualLottoCount(int lottoCount, int manualLottoCount) {
        if(lottoCount < manualLottoCount) {
            throw new IllegalArgumentException(String.format(TOO_MANY_MANUAL_COUNT_ERROR, lottoCount));
        }
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
