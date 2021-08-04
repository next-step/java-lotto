package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoApplication {
    public static void main(String[] args) {
        // 구매 금액 입력
        InputView inputView = new InputView();
        Money money = inputView.inputMoney();

        LottoTickets lottoTickets = new LottoTickets(money, new RandomLottoNumbers());

        // 구매 티켓 출력
        OutputView outputView = new OutputView();
        outputView.printPurchase(lottoTickets);

        // 당첨번호 입력
        List<Integer> inputWinNumbers = inputView.inputWinNumbers();
        LottoNumbers winNumbers = () -> inputWinNumbers;

        // 당첨 통계
        outputView.printWinStats(lottoTickets.getWinStats(winNumbers));
    }
}
