package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoList;
import lotto.domain.LottoNumber;
import lotto.domain.LottoStatistics;
import lotto.exception.OutOfRangeException;
import lotto.util.Money;
import lotto.util.DivisionNumber;
import lotto.view.DosInputView;
import lotto.view.DosResultView;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.Arrays;
import java.util.stream.Collectors;

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

            Lotto prizeLotto = inputPrizeLottoNumbers();
            LottoStatistics lottoStatistics = lottoList.statistics(prizeLotto);
            resultView.printLottoStatistics(lottoStatistics);
        } catch (OutOfRangeException e) {
            resultView.printException(e);
        }
    }

    private LottoList buyLotto(long longMoney) {
        Money money = new Money(longMoney);
        DivisionNumber lottoSize = new DivisionNumber(money, Lotto.PRICE);
        return LottoList.newAuto(lottoSize);
    }

    private Lotto inputPrizeLottoNumbers() {
        String strPrizeNumbers = inputView.inputPrizeNumbers();
        return Lotto.parse(strPrizeNumbers);
    }
}
