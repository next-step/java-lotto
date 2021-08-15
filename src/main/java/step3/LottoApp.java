package step3;

import step3.domain.BonusBall;
import step3.domain.Customer;
import step3.domain.LottoInfo;
import step3.domain.WinningLottoNumbers;
import step3.view.InputView;
import step3.view.ResultView;

import java.util.List;

public class LottoApp {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        Customer customer = new Customer();
        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers();

        LottoInfo lottoInfo = new LottoInfo(inputView.requestInput());

        List<List<Integer>> issuedLottoList = customer.buyLotto(lottoInfo.getCount());
        resultView.printIssuedLottoList(issuedLottoList);
        List<Integer> winningLottoNumberList = winningLottoNumbers.checkValidInput(inputView.requestWinningLottoNumber());
        int bonusBallNumber = inputView.requestBonusBall();
        BonusBall.copareWithWinningLottoNumbers(bonusBallNumber, winningLottoNumberList);
        customer.compareWinningLottoNumbersAndIssuedLottoList(winningLottoNumberList, issuedLottoList, bonusBallNumber);

        resultView.printMatchedLottoRecord(customer.getResultRankMap());
        resultView.printResultPrice(customer.getResultPrize(), lottoInfo.getCount());


    }

}
