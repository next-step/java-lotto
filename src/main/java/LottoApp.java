import step2.domain.LottoMachine;
import step2.util.Calculator;
import step2.view.InputView;
import step2.view.ResultView;

import java.util.ArrayList;

public class LottoApp {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        int numOfLotto = inputView.requestInput();
        String lastWinningLottoNum = inputView.requestWinningLottoNumber();

        LottoMachine lottoMachine = new LottoMachine(numOfLotto, lastWinningLottoNum);
        ArrayList<ArrayList> issuedLottolist = lottoMachine.run();
        ArrayList<Integer> lastWinningLottoNumberArray = lottoMachine.getLastWinningLottoNumberArray();

        Calculator calculator = new Calculator(issuedLottolist, lastWinningLottoNumberArray);
        calculator.run();
        int[] lottoResultArray = calculator.getLottoResultArray();
        resultView.printMatchedLottoRecord(lottoResultArray, numOfLotto);
    }
}
