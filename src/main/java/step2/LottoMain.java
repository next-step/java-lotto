package step2;

import step2.domain.LottoResult;
import step2.domain.LottoTickets;
import step2.util.LottoUtil;
import step2.view.InputView;
import step2.view.ResultView;

import java.util.List;

public class LottoMain {

    public static void main(String[] args) {

        InputView inputView = new InputView();
        int paidAmount = inputView.receiveInputNumber();

        LottoTickets lottoTickets = new LottoTickets(LottoUtil.getNumOfTickets(paidAmount));

        ResultView resultView = new ResultView();
        resultView.printAllLottoNumbers(lottoTickets);

        String winningNumbers = inputView.receiveInputString();
        List<Integer> numbers = LottoUtil.splitStringToNumbers(winningNumbers);

        LottoResult lottoResult = new LottoResult();
        lottoResult.calculateLottoResult(lottoTickets.getLottoNumbers(), numbers, paidAmount);

        resultView.printWinningResult(lottoResult);
    }
}
