package step2.controller;

import step2.model.Lotto;
import step2.model.PurchaseAmount;
import step2.model.WinningNumber;
import step2.model.WinningResult;
import step2.view.InputView;
import step2.view.ResultView;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        String input = inputView.ask("구입금액을 입력해 주세요.");

        PurchaseAmount user = new PurchaseAmount();
        int amount = user.getPurchaseAmount(input);
        int lottoCount = user.getLottoCount(input);
        System.out.println(lottoCount + "개를 구매했습니다.");

        Lotto lotto = new Lotto();
        List<List<Integer>> lottoList = lotto.getLotto(lottoCount);

        ResultView view = new ResultView();
        view.showLotto(lottoList);

        input = inputView.ask("지난 주 당첨 번호를 입력해 주세요.");

        WinningNumber winningNumber = new WinningNumber();
        List<Integer> winningNumbers = winningNumber.getWinningNumbers(input);

        WinningResult winningResult = new WinningResult();
        Map<Integer, Integer> result = winningResult.getWinningResult(lottoList, winningNumbers);
        String winningRate = winningResult.getWinningRate(amount, result);
        view.showResult(result, winningRate);

    }
}
