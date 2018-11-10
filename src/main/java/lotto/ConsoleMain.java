package lotto;

import java.util.List;

import lotto.domain.LottoMachine;
import lotto.domain.LottoResult;
import lotto.domain.LottoStore;
import lotto.domain.Lotto;
import lotto.view.InputView;
import lotto.view.ResultView;

public class ConsoleMain {

    public static void main(String[] args) {
        int money = InputView.inputTryNo("구입금액을 입력해 주세요.");
        
        LottoStore lottoStore = new LottoStore(new LottoMachine());
        List<Lotto> buyedLottos = lottoStore.buyTickets(money);
        
        ResultView.renderBuyedTickets(buyedLottos);
        
        String winningNumber = InputView.inputTryLine("지난 주 당첨 번호를 입력해 주세요.");
        int bonusNumber = InputView.inputTryNo("보너스 볼을 입력해 주세요.");
        LottoResult lottoResult = lottoStore.checkWinningLotto(winningNumber, bonusNumber, buyedLottos);
        
        ResultView.renderStats(lottoResult);
    }
}
