package lotto;

import lotto.domain.Buyer;
import lotto.domain.ProfitStatistics;
import lotto.domain.ResultDTO;
import lotto.view.LottoView;
import lotto.view.ResultView;
import lotto.view.TextView;

import java.util.List;

public class Main {
    public static void main(String args[]) {

        NumberInputScanner numberInputScanner = new NumberInputScanner();
        StringInputScanner stringInputScanner = new StringInputScanner();

        ResultView resultView = new ResultView();
        LottoView lottoView = new LottoView();

        lottoView.printAskMoney();

        int money = numberInputScanner.getNumber();
        Buyer buyer = new Buyer(money);
        buyer.buyAutoLotto();

        lottoView.printLottoCount(buyer.getLottoCount());
        lottoView.printLottoListNumber(buyer.getLottoListNumbers());

        lottoView.printAskWinNumber();

        List<Integer> winningNumbers = stringInputScanner.getNumbers();

        buyer.checkLotto(winningNumbers);
        List<Integer> winningList = buyer.checkWin();

        ProfitStatistics profitStatistics = new ProfitStatistics(winningList, money);

        ResultDTO resultDTO = profitStatistics.analysis();
        resultView.view(resultDTO);

    }

}
