package step3;

import step3.domain.BonusBall;
import step3.domain.Customer;
import step3.domain.WinningLottoNumbers;
import step3.view.InputView;

import java.util.ArrayList;

public class LottoApp {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        Customer customer = new Customer();
        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers();

        int numOfLotto = inputView.requestInput();
        ArrayList<ArrayList<Integer>> issuedLottoList = customer.buyLotto(numOfLotto);
        ArrayList<Integer> winningLottoNumberList = winningLottoNumbers.checkValidInput(inputView.requestWinningLottoNumber());
        int bonusBallNumber = inputView.requestBonusBall();
        BonusBall.copareWithWinningLottoNumbers(bonusBallNumber, winningLottoNumberList);


    }

}
