package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.HashMap;
import java.util.List;

public class LottoController {
    public static void startLotto() {
        // 구매 금액 입력
        int money = InputView.inputMoney();

        // 로또 생성
        Lottos lottos = LottoShop.purchaseTicket(money);

        // 구매 개수 및 생성된 로또 출력
        ResultView.printPurchase(LottoShop.countPurchase(money));
        ResultView.printLottos(lottos.getLottos());

        // 당첨 번호 입력 및 당첨 번호와 로또 번호 비교
        HashMap<Integer, Integer> matchResult =
                LottoMatch.match(lottos, new Winning().createWinNumbers(InputView.inputWinNumber()));

        // 매칭 결과 및 계산한 수익률 출력
        Revenue revenue = new Revenue();
        ResultView.printResult(matchResult, revenue.calculateRevenue(money, revenue.getRevenueTotal(matchResult)));
    }
}
