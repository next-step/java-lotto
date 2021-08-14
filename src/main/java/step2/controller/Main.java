package step2.controller;

import step2.model.*;
import step2.view.InputView;
import step2.view.ResultView;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        String input = inputView.ask("구입금액을 입력해 주세요.");

        PurchaseAmount amount = new PurchaseAmount(input);
        int lottoCount = amount.getLottoCount();
        System.out.println(lottoCount + "개를 구매했습니다.");

        LottoGroup lottoGroup = new LottoGroup(lottoCount);
        List<List<Integer>> lottoResult = lottoGroup.getLottoResult();

        ResultView view = new ResultView();
        view.showLotto(lottoResult);

        input = inputView.ask("지난 주 당첨 번호를 입력해 주세요.");
        String bonusNumber = inputView.ask("보너스 볼을 입력해 주세요.");

        Bonus bonus = new Bonus(bonusNumber);
        WinningNumber winningNumber = new WinningNumber(input);
        Winning winning = new Winning(winningNumber, bonus);

        WinningResult winningResult = new WinningResult();
        Map<Rank, Integer> result = winningResult.getResult(lottoGroup, winning);
        String winningRate = winningResult.getWinningRate(amount, result);
        view.showResult(result, winningRate);

    }
}
