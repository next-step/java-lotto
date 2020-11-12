package lotto.controller.strategy;

import lotto.domain.Lotto;
import lotto.domain.LottoFactory;
import lotto.view.InputView;

/**
 * FIXME: 이런건 테스트를 어떻게 해야할지 감이 안잡힌다.
 * 도와주세요!!
 */
public class InputStrategy implements GenerateStrategy {
    private InputStrategy() {}

    public static InputStrategy getInstance() {
        return SingletonHelper.instance;
    }

    @Override
    public Lotto generateLotto() {
        String lottoStr = InputView.askLottoStr();
        return LottoFactory.createLotto(lottoStr);
    }

    private static class SingletonHelper {
        private static final InputStrategy instance = new InputStrategy();
    }
}
