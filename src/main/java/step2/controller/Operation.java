package step2.controller;

import step2.view.InputView;
import step2.view.ResultView;

import java.util.List;

public class Operation {
    public static void start() {
        int count = InputView.input();
        List<List> lottos = IssueLotto.issueLottos(count);
        ResultView.view(lottos); // 생성된 로또 번호 view
        String number = InputView.inputNumber(); // 당첨번호
        int[] result = WinnerStatistics.result(lottos, number); // 당첨결과
        float revenue = MakeRevenue.create(lottos.size(), result); // 수익률
        ResultView.result(result, revenue);

    }
}
