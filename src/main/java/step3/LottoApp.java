package step3;

import step3.domain.BonusBall;
import step3.domain.Customer;
import step3.domain.WinningLottoNumbers;
import step3.view.InputView;
import step3.view.ResultView;

import java.util.ArrayList;

public class LottoApp {
    private static final int chargeOfLotto = 1000;

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        Customer customer = new Customer();
        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers();

        int numOfLotto = inputView.requestInput();
        ArrayList<ArrayList<Integer>> issuedLottoList = customer.buyLotto(numOfLotto);
        resultView.printIssuedLottoList(issuedLottoList);
        ArrayList<Integer> winningLottoNumberList = winningLottoNumbers.checkValidInput(inputView.requestWinningLottoNumber());
        int bonusBallNumber = inputView.requestBonusBall();
        BonusBall.copareWithWinningLottoNumbers(bonusBallNumber, winningLottoNumberList);
        customer.compareWinningLottoNumbersAndIssuedLottoList(winningLottoNumberList, issuedLottoList, bonusBallNumber);

        resultView.printMatchedLottoRecord(customer.getResultRankMap());
        resultView.printResultPrice(customer.getResultPrize(), numOfLotto);


    }

}
