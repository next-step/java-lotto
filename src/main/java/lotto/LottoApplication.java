package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoApplication {
    public static void main(String[] args) {
        // 구매 금액 입력
        InputView inputView = new InputView();
        Money money = inputView.inputMoney();

        // 수동 구매 개수 입력
        int manualCount = inputView.inputManualCount();

        // 수동 구매 번호 입력
        List<LottoTicket> manualLottoTickets = inputView.inputManualLottoTickets(manualCount);

        // 랜덤 로또 티켓 생성
        List<LottoTicket> randomLottoTickets = new ArrayList<>();
        for(int i=0; i< money.countLotto() - manualCount; i++){
            randomLottoTickets.add(new RandomLottoNumbers().generateNumbers());
        }
        LottoTickets lottoTickets = new LottoTickets(money, randomLottoTickets, manualLottoTickets);

        // 구매 티켓 출력
        OutputView outputView = new OutputView();
        outputView.printPurchase(lottoTickets, manualCount);

        // 당첨번호 입력
        List<Integer> winNumbers = inputView.inputWinNumbers();

        // 2등 보너스볼 입력
        int bonusNumber = inputView.inputBonusNumber();
        WinLotto winLotto = new WinLotto(winNumbers, bonusNumber);

        // 당첨 통계
        outputView.printWinStats(lottoTickets.getWinStats(winLotto, money));
    }
}
