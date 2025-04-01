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
        WinningNumbers winningNumbers = new WinningNumbers(InputView.readWinningNumbers("지난 주 당첨 번호를 입력해 주세요."));
        Summary summary = winningNumbers.summarize(lottoTicket);
        Rewards rewards = summary.rewards();
        ResultView.printRewards(rewards);
    }
}
