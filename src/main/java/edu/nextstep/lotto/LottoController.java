package edu.nextstep.lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoController {
    private List lottoList;
    private Statistics statistics;
    private ArrayList winnerList;

    LottoController() {
        lottoList = new ArrayList();
        statistics = new Statistics();
    }

    public void setup() {
        ResultView.print("구입금액을 입력해 주세요");
        int money = InputView.inputMoney();
        int count = ResultView.lottoCount(money);

        for (int i = 0; i < count; i++) {
            Lotto lotto = new Lotto();
            ResultView.printLotto(lotto.makeLotto());
            lottoList.add(lotto);
        }

        ResultView.print("지난 주 당첨 번호를 입력해 주세요.");
        String[] winNumber = InputView.winNumber();

        ResultView.print("당첨 통계");
        ResultView.print("--------");
        Map<Integer, Integer> result = statistics.getResult(lottoList, winNumber);

        ResultView.rankView(result, statistics.info);

        ResultView.profitView(statistics.checkProfit(money, result));
    }

    public void setupTest(int money, String input) {
        int count = ResultView.lottoCount(money);

        for (int i = 0; i < count; i++) {
            Lotto lotto = new Lotto();
            ResultView.printLotto(lotto.makeLotto());
            lottoList.add(lotto);
        }

        String[] winNumber = input.split(", ");

        ResultView.print("당첨 통계");
        ResultView.print("--------");
        Map<Integer, Integer> result = statistics.getResult(lottoList, winNumber);

        ResultView.rankView(result, statistics.info);

        ResultView.profitView(statistics.checkProfit(money, result));
    }
}
