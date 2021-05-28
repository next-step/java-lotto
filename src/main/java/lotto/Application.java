package lotto;

import lotto.core.LottoController;
import lotto.domain.LottoTickets;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningNumbers;

public class Application {

    public static void main(String[] args) {
        LottoController controller = new LottoController();

        //1. 구매금액 입력
        PurchaseAmount purchaseAmount = controller.getPurchaseAmount();

        //2. 수동 + 자동 로또 생성
        LottoTickets lottoTickets = controller.getManualTickets(purchaseAmount);
        lottoTickets.combineWith(controller.getAutoTickets(purchaseAmount, lottoTickets.count()));

        //2. 당첨번호 입력 +  보너스 번호 입력
        WinningNumbers winningNumbers = controller.getWinningNumbers();

        //3. 당첨통계 생성 및 출력
        controller.getLottoResult(lottoTickets, winningNumbers);
    }
}
