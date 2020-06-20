package step3;

import step3.view.InputView;
import step3.view.ResultView;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        LottoSeller seller = new LottoSeller();

        InputView priceInputView= InputView.addQuestion("구매금액을 입력해 주세요.");
        int price = priceInputView.inputPrice();

        List<LottoTicket> lottoTicketList = seller.sellLotto(price);
        ResultView resultView = new ResultView(lottoTicketList);

        InputView winningNumbersInputView = InputView.addQuestion("지난 주 당첨 번호를 입력해 주세요.");
        String stringWinningNumbers = winningNumbersInputView.inputWinnerNumbers();
        InputView bonusView = InputView.addQuestion("보너스 볼을 입력해 주세요.");
        int bonusNumber = bonusView.inputPrice();

        LottoWinningNumbers winningNumbers = new LottoWinningNumbers(stringWinningNumbers, bonusNumber);
        Statistics statistics = new Statistics(winningNumbers.checkLottoWinning(lottoTicketList));

        resultView.printResult(statistics);

    }
}
