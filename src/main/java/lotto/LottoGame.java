package lotto;

import lotto.domain.Amount;
import lotto.domain.LottoBundle;
import lotto.domain.LottoMachine;
import lotto.domain.winning.WinningBall;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGame {
    public static void main(String[] args) {
        final LottoMachine lottoMachine = new LottoMachine();

        // 단순히 얼마인지를 가지고있는건 로또게임 당사자의 책임이라 생각해서 로또기계 안으로 생성로직을 넣지 않았습니다.
        final Amount amount = new Amount(InputView.purchaseAmount());

        final LottoBundle lottoBundle = lottoMachine.makeLottos(amount, InputView.manualLotto());

        OutputView.printLottoCount(lottoBundle);
        OutputView.printLottoNumber(lottoBundle);

        final WinningBall winningBall = lottoMachine.winningBall(InputView.winningNumbers(), InputView.bonusBall());
        OutputView.printWinningStat(lottoMachine.winningStat(lottoBundle, winningBall), amount);
    }
}
