package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Collections;
import java.util.List;

public class LottoApplication {
    public static void main(String[] args) {
        // 구매 금액 입력
        InputView inputView = new InputView();
        Money money = inputView.inputMoney();

        LottoTickets lottoTickets = new LottoTickets(money, Collections.singletonList(new RandomLottoNumbers().generateNumbers()));

        // 구매 티켓 출력
        OutputView outputView = new OutputView();
        outputView.printPurchase(lottoTickets);

        // 당첨번호 입력
        List<Integer> winNumbers = inputView.inputWinNumbers();

        // 2등 보너스볼 입력
        int bonusNumber = inputView.inputBonusNumber();
        WinLotto winLotto = new WinLotto(winNumbers, bonusNumber);

        // 당첨 통계
        outputView.printWinStats(lottoTickets.getWinStats(winLotto));
    }
}
