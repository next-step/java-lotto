package step3;

import step3.view.InputView;
import step3.view.ResultView;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        LottoSeller seller = new LottoSeller();

        InputView priceInputView= InputView.addQuestion("구매금액을 입력해 주세요.");
        int price = priceInputView.inputPrice();

        List<LottoTicket> lottoTicketList = seller.buyLotto(price);
        ResultView resultView = new ResultView(lottoTicketList);

        InputView winningNumbersInputView = InputView.addQuestion("지난 주 당첨 번호를 입력해 주세요.");
        List<Integer> winningCountList = seller.requestLottoChecking(winningNumbersInputView.inputWinnerNumbers(), lottoTicketList);

        resultView.printResult(new Statistics(winningCountList));

    }
}
