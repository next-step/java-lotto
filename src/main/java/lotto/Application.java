package lotto;

import lotto.core.LottoController;
import lotto.domain.LottoTickets;
import lotto.domain.Money;
import lotto.domain.WinningNumbers;

public class Application {

    public static void main(String[] args) {
        LottoController controller = new LottoController();

        //1. 구매금액 입력
        Money purchaseAmount = controller.getPurchaseAmount();

        //2. 수동
//        LottoTickets tickets = controller.getManualTickets(purchaseAmount);
        LottoTickets tickets = controller.getTickets(purchaseAmount);
        tickets.combineWith(controller.getTickets(purchaseAmount));
        LottoTickets lottoTickets = controller.getTickets(purchaseAmount);

        //2. 당첨번호 입력 +  보너스 번호 입력
        WinningNumbers winningNumbers = controller.getWinningNumbers();

        //3. 당첨통계 생성 및 출력
        controller.getLottoResult(lottoTickets, winningNumbers);
    }
}
