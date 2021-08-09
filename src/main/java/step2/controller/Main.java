package step2.controller;

import step2.model.Lotto;
import step2.view.InputView;
import step2.view.ResultView;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        InputView user = new InputView();
        String input = user.ask("구입금액을 입력해 주세요.");
        int amount = user.getPurchaseAmount(input);
        int lottoCnt = user.getLottoCnt(input);
        System.out.println(lottoCnt + "개를 구매했습니다.");

        Lotto lotto = new Lotto();
        List<List<Integer>> lottoList = lotto.getLotto(lottoCnt);

        ResultView view = new ResultView();
        view.showLotto(lottoList);

        input = user.ask("지난 주 당첨 번호를 입력해 주세요.");
        List<Integer> winningNoList = user.getWinningNo(input);
        Map<Integer, Integer> result = lotto.checkWinning(lottoList, winningNoList);
        String winningRate = lotto.getWinningRate(amount, result);
        view.showResult(result, winningRate);

    }
}
