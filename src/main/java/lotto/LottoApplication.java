package lotto;

import lotto.domain.InputConverter;
import lotto.domain.Lotto;
import lotto.domain.Store;
import lotto.domain.WinningStatistics;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        String budget = inputView.askBudget();

        Store store = new Store();
        List<Lotto> lottoBundle = store.purchase(budget);

        ResultView resultView = new ResultView();
        resultView.showMyLotto(lottoBundle);

        String strList = inputView.askLastLottoNumber();

        InputConverter inputConverter = new InputConverter();
        WinningStatistics winningStatistics = new WinningStatistics(inputConverter.convertNumberToList(strList));

        List<Integer> result = winningStatistics.compareWithTargetNumber(lottoBundle);
        System.out.println(result);

    }

}
