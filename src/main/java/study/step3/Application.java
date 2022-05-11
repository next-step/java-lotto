package study.step3;

import study.step3.domain.LottoMachine;
import study.step3.domain.LottoTickets;
import study.step3.domain.LottoWinners;
import study.step3.view.InputView;
import study.step3.view.ResultView;

public class Application {
    public static void main(String[] args) {
        // 구매 금액 입력
        InputView inputView = new InputView();
        int buyAmount = inputView.inputBuyAmount();

        // 로또 발급
        LottoTickets lottoTickets = LottoMachine.createLottoTickets(buyAmount);

        // 로또 번호 확인
        ResultView resultView = new ResultView(lottoTickets);
        resultView.printLottoTicketInfos();

        // 당첨 결과 확인
        String inputNumber = inputView.inputWinnerNumbers();
        int inputBonusNumber = inputView.inputBonusNumber();
        LottoWinners lottoWinners = LottoMachine.createWinners(inputNumber, inputBonusNumber);

        // 당첨 내역 출력
        resultView.printLottoRanksInfos(lottoWinners);
        resultView.printLottoYield(lottoTickets, lottoWinners);

    }
}
