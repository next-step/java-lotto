package step3;


import step3.controller.LottoStore;
import step3.lotto.BonusNumber;
import step3.lotto.LottoNumber;
import step3.lotto.TotalLottoNumber;
import step3.lotto.client.Client;
import step3.lotto.result.ResultStatistic;
import step3.view.InputView;
import step3.view.ResultView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        inputView.print("구입금액을 입력해 주세요.");
        int money = inputView.receiveInput();

        Client client = new Client(money);
        LottoStore lottoStore = new LottoStore(resultView);
        lottoStore.sellTo(client);

        inputView.print("지난 주 당첨 번호를 입력해 주세요.");
        LottoNumber winningNumber = getWinningNumber(inputView);
        inputView.print("보너스 볼을 입력해 주세요.");
        BonusNumber bonusNumber = getBonusNumber(inputView);
        TotalLottoNumber totalLottoNumber = new TotalLottoNumber(winningNumber, bonusNumber);
        ResultStatistic resultStatistic = client.calculateResultStatistic(totalLottoNumber);
        resultView.printResultStatistic(resultStatistic);
    }

    private static LottoNumber getWinningNumber(InputView inputView) {
        int[] winningNumberInput = inputView.receiveLastWeekWinningNumber();

        List<Integer> winningNumberList = Arrays.stream(winningNumberInput)
                .boxed().collect(Collectors.toList());

        return new LottoNumber(winningNumberList);
    }

    private static BonusNumber getBonusNumber(InputView inputView) {
        int bonusNumber = inputView.receiveBonusNumber();
        return new BonusNumber(bonusNumber);
    }

}
