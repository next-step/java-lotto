package lotto.domain;

import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoService {
    public void start() {
        Money money = new Money(InputView.read("구입금액을 입력해주세요."));
        LottoMachine lottoMachine = new LottoMachine();
        LottoTicket lottoTicket = lottoMachine.buyLotto(money);
        ResultView.printAmount(lottoTicket);
        ResultView.printLottoTicket(lottoTicket);
        String inputWinningNumbers = InputView.readWinningNumbers("지난 주 당첨 번호를 입력해 주세요.");
        int bonusNumber = InputView.readBonusNumber("보너스 볼을 입력해 주세요.");
        WinningNumbers winningNumbers = new WinningNumbers(inputWinningNumbers, bonusNumber);
        Summary summary = winningNumbers.summarize(lottoTicket);
        Rewards rewards = summary.rewards();
        ResultView.printRewards(rewards);
    }
}
