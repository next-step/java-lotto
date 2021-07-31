package lotto;

import lotto.domain.*;
import lotto.domain.dto.WinningLottoRequest;
import lotto.exception.*;
import lotto.util.number.DivisionNumber;
import lotto.view.DosInputView;
import lotto.view.DosResultView;
import lotto.view.InputView;
import lotto.view.ResultView;
import stringaddcalculator.exception.InvalidFormulaException;

import java.util.List;

public final class LottoSolution {
    public static void main(String[] args) {
        LottoSolution lottoSolution = new LottoSolution(
                new DosInputView(), new DosResultView()
        );
        lottoSolution.run();
    }

    private final InputView inputView;
    private final ResultView resultView;

    public LottoSolution(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void run() {
        try {
            long money = inputView.inputMoney();
            LottoList lottoList = buyLotto(money);
            resultView.printLottoList(lottoList);

            WinningLotto winningLotto = inputWinningLottoNumbers();
            LottoStatistics lottoStatistics = lottoList.statistics(winningLotto);
            resultView.printLottoStatistics(lottoStatistics);
        } catch (Exception e) {
            resultView.printException(e);
        }
    }

    private LottoList buyLotto(long longMoney) {
        Money money = new Money(longMoney);
        DivisionNumber lottoSize = new DivisionNumber(money, Lotto.PRICE);
        return LottoList.generate(lottoSize);
    }

    private WinningLotto inputWinningLottoNumbers() {
        WinningLottoRequest winningLottoRequest = inputView.inputWinningLotto();

        String strWiningNumbers = winningLottoRequest.lottoNumbers();
        int bonusNumber = winningLottoRequest.bonusNumber();

        return new WinningLotto(
                Lotto.of(strWiningNumbers), LottoNumber.of(bonusNumber)
        );
    }
}
