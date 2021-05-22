package lotto;

import lotto.domain.LottoTickets;
import lotto.domain.WinningNumbers;
import lotto.ui.InputView;
import lotto.ui.OutputView;

public class Application {

    public static void main(String[] args) {

        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        //1. 구매금액 입력 및 로또티켓들 생성
        outputView.printAmountInputRequest();
        LottoTickets lottoTickets = new LottoTickets(inputView.receivePurchaseAmount());
        outputView.printLottoTickets(lottoTickets);

        //2. 당첨번호 입력 
        outputView.printWinningNumbersInputRequest();
        WinningNumbers winningNumbers = new WinningNumbers(inputView.receiveWinningNumbers());
        
        //3. 당첨통계 생성 및 출력
        outputView.printLottoResult(lottoTickets.matchingResultWith(winningNumbers));
    }
}
