package lotto;

import java.util.List;
import java.util.Map;

import lotto.domain.LottoMchine;
import lotto.domain.LottoStore;
import lotto.domain.LottoTicket;
import lotto.view.InputView;
import lotto.view.ResultView;

public class ConsoleMain {

    public static void main(String[] args) {
        int money = InputView.inputTryNo("구입금액을 입력해 주세요.");
        
        LottoMchine lottoMchine = new LottoMchine();
        LottoStore lottoStore = new LottoStore(lottoMchine);
        
        List<LottoTicket> tikets = lottoStore.buy(money);
        
        ResultView.renderBuyedTikets(tikets);
        
        String winningNumber = InputView.inputTryLine("지난 주 당첨 번호를 입력해 주세요.");
        Map<Integer, Integer> stats = lottoMchine.check(winningNumber, tikets);
        
        ResultView.renderStats(stats, money);
    }
}
