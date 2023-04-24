package lotto;

import lotto.domain.Amount;
import lotto.domain.LottoMachine;
import lotto.domain.Lottos;
import lotto.domain.strategy.AutomaticStrategy;
import lotto.domain.winning.WinningBall;
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

        final WinningBall winningBall = new WinningBall(lottoMachine.winningLotto(InputView.winningNumbers()), lottoMachine.bonusBall(InputView.bonusBall()));
        OutputView.printWinningStat(lottoMachine.winningStat(lottos, winningBall), amount);
    }
}
