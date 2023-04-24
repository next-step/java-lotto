package lotto;

import lotto.domain.Amount;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.Lottos;
import lotto.domain.strategy.AutomaticStrategy;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGame {
    public static void main(String[] args) {
        final LottoMachine lottoMachine = new LottoMachine();

        // 단순히 얼마인지를 가지고있는건 로또게임 당사자의 책임이라 생각해서 로또기계 안으로 생성로직을 넣지 않았습니다.
        final Amount amount = new Amount(InputView.purchaseAmount());
        final Lottos lottos = lottoMachine.makeLottos(amount, new AutomaticStrategy());

        OutputView.printLottoCount(lottoMachine.calculateUnitCount(amount));
        OutputView.printLottoNumber(lottoMachine.lottoNumbersDto(lottos));

        final String winningNumbers = InputView.winningNumbers();
        final Lotto winningLotto = lottoMachine.winningLotto(winningNumbers);

        final int bonusBallNumber = InputView.bonusBall();

        OutputView.printWinningStat(lottoMachine.winningStat(lottos, winningLotto), amount);
    }
}
