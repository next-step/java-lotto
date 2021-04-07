package lotto.domain;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoMachine {

    private static InputView inputView = new InputView();
    private static OutputView outputView = new OutputView();

    private LottoNumbers lottoNumbers;

    private static final Number threeNumber = new Number(3);
    private static final Number fourNumber = new Number(4);
    private static final Number fiveNumber = new Number(5);
    private static final Number sixNumber = new Number(6);

    private Number threeWinnerCnt = new Number(0);
    private Number fourWinnerCnt = new Number(0);
    private Number fiveWinnerCnt = new Number(0);
    private Number sixWinnerCnt = new Number(0);

    private Money expense;

    public LottoMachine(final LottoNumbers lottoNumbers,Money expense) {
        this.lottoNumbers = lottoNumbers;
        this.expense = expense;
    }

    public void startLottoGame() {
        printLotto();
    }

    public OutputData showResult(LottoNumber lottoNumber) {

        WinLottoNumber winLottoNumber = new WinLottoNumber(lottoNumber);

        for (int i = 0; i < this.lottoNumbers.lottoNumbers().size(); i++) {
            int resultCount = winLottoNumber.checkDuplicationLotto(this.lottoNumbers.lottoNumbers().get(i));
            plusCount(resultCount);
        }

        OutputData result = new OutputData(threeWinnerCnt, fourWinnerCnt, fiveWinnerCnt, sixWinnerCnt, expense);
        result.calculateRate();
        return result;
    }

    private void plusCount(int resultCount) {
        if (resultCount == threeNumber.number()) {
            threeWinnerCnt = new Number(threeWinnerCnt.number() + 1);
        }

        if (resultCount == fourNumber.number()) {
            fourWinnerCnt = new Number(fourWinnerCnt.number() + 1);
        }

        if (resultCount == fiveNumber.number()) {
            fiveWinnerCnt = new Number(fiveWinnerCnt.number() + 1);
        }

        if (resultCount == sixNumber.number()) {
            sixWinnerCnt = new Number(sixWinnerCnt.number() + 1);
        }
    }


    private void printLotto() {
        for (LottoNumber lottoNumber : lottoNumbers.lottoNumbers()) {
            outputView.printPurchasedLotto(lottoNumber);
        }
    }

}
