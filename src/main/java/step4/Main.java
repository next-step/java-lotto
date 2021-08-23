package step4;


import step4.controller.LottoStore;
import step4.lotto.LottoNo;
import step4.lotto.LottoNumber;
import step4.lotto.TotalLottoNumber;
import step4.lotto.client.Client;
import step4.lotto.result.ResultStatistic;
import step4.view.InputView;
import step4.view.ResultView;

import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        int money = inputView.receiveInput();

        List<LottoNumber> manualLottoNumbers = receiveManualLottoNumbers(money, inputView);
        Client client = new Client(money, manualLottoNumbers);

        LottoStore lottoStore = new LottoStore(resultView);
        lottoStore.sellTo(client);

        LottoNumber winningNumber = getWinningNumber(inputView);
        TotalLottoNumber totalLottoNumber = getTotalLottoNumber(winningNumber, inputView);
        ResultStatistic resultStatistic = client.calculateResultStatistic(totalLottoNumber);
        resultView.printResultStatistic(resultStatistic);
    }

    private static TotalLottoNumber getTotalLottoNumber(LottoNumber winningNumber, InputView inputView) {
        LottoNo bonusNumber = inputView.receiveBonusNumber(winningNumber);
        return new TotalLottoNumber(winningNumber, bonusNumber);
    }

    private static List<LottoNumber> receiveManualLottoNumbers(long money, InputView inputView) {
        int manualLottoCount = inputView.receiveManualLottoCount(money);
        if (manualLottoCount == 0)
            return Collections.emptyList();

        return inputView.receiveManualLottoNumber(manualLottoCount);
    }

    private static LottoNumber getWinningNumber(InputView inputView) {
        return inputView.receiveLastWeekWinningNumber();
    }
}
