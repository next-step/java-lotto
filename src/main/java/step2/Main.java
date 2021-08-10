package step2;

import step2.controller.LottoStore;
import step2.lotto.client.Client;
import step2.lotto.LottoNumber;
import step2.lotto.result.ResultStatistic;
import step2.view.InputView;
import step2.view.ResultView;

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

        ResultStatistic resultStatistic = client.calculateResultStatistic(winningNumber);
        resultView.printResultStatistic(resultStatistic);
    }

    private static LottoNumber getWinningNumber(InputView inputView) {
        int[] winningNumberInput = inputView.receiveLastWeekWinningNumber();
        inputView.close();

        List<Integer> winningNumberList = Arrays.stream(winningNumberInput)
                .boxed().collect(Collectors.toList());

        return new LottoNumber(winningNumberList);
    }

}
