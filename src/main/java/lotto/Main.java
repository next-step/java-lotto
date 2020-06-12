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
        ManualLottoNumbers manualLottoNumbers = new ManualLottoNumbers();

        ResultView resultView = new ResultView();
        LottoView lottoView = new LottoView();

        lottoView.printAskMoney();

        int money = numberInputScanner.getNumber();

        lottoView.printAskManualCount();
        int manualCount = numberInputScanner.getNumber();

        lottoView.printAskManualNumber();

        Buyer buyer = new Buyer(money, manualCount);
        buyer.buyLotto();

        lottoView.printLottoCount(buyer.getManualLottoCount(), buyer.getAutoLottoCount());
        lottoView.printLottoListNumber(buyer.getLottoListNumbers());

        lottoView.printAskWinNumber();

        List<LottoNo> winningNumbers = manualLottoNumbers.generateNumbers();

        lottoView.printAskBonusNumber();

        LottoNo bonusNumber = manualLottoNumbers.generateNumber();

        Map<Prize, Integer> winningList = buyer.checkLotto(winningNumbers, bonusNumber);

        ProfitStatistics profitStatistics = new ProfitStatistics(winningList, money);

        resultView.view(new ResultDTO(winningList, profitStatistics.getProfitRatio()));

    }

}
