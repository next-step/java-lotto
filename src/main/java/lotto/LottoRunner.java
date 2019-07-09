package lotto;

import lotto.domain.Lotto;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoRunner {
    public static void main(String[] args) {
        Lotto lotto = new Lotto(InputView.promptInt("구입금액을 입력해 주세요."));
        ResultView.printTickets(lotto.generate());
        ResultView.printResult(lotto.start(
                InputView.promptString("지난 주 당첨 번호를 입력해주세요."),
                InputView.promptInt("보너스 볼을 입력해 주세요.")
        ));
    }
}
