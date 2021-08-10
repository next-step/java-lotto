package step2;

import step2.domain.LottoMachine;
import step2.util.Calculator;
import step2.util.LastWinningLottoNumberChecker;
import step2.view.InputView;
import step2.view.ResultView;

import java.util.ArrayList;

public class LottoApp {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        int numOfLotto = inputView.requestInput();

        LottoMachine lottoMachine = new LottoMachine();
        ArrayList<ArrayList> issuedLottolist = lottoMachine.run(numOfLotto);
        resultView.printIssuedLottoList(issuedLottolist);

        String lastWinningLottoNum = inputView.requestWinningLottoNumber();

        LastWinningLottoNumberChecker lastWinningLottoNumberChecker;
        lastWinningLottoNumberChecker = new LastWinningLottoNumberChecker(lastWinningLottoNum);
        ArrayList<Integer> lastWinningLottoNumberArray = lastWinningLottoNumberChecker.getLottoWinningNumberArray();

        Calculator calculator = new Calculator(issuedLottolist, lastWinningLottoNumberArray);
        calculator.run();
        int[] lottoResultArray = calculator.getLottoResultArray();
        resultView.printMatchedLottoRecord(lottoResultArray, numOfLotto);
    }
}
