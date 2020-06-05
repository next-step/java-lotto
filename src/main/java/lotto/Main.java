package lotto;

import lotto.domain.*;
import lotto.view.LottoView;
import lotto.view.ResultView;
import lotto.view.TextView;

import java.util.List;
import java.util.Map;

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

        lottoView.printAskBonusNumber();

        int bonusNumber = numberInputScanner.getNumber();

        Map<Prize, List<Lotto>> winningList = buyer.checkLotto(winningNumbers, bonusNumber);

        ProfitStatistics profitStatistics = new ProfitStatistics(winningList, money);

        resultView.view(new ResultDTO(winningList, profitStatistics.getProfitRatio()));

    }

}
