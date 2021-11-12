package lotto.step2.controller;

import lotto.step2.view.InputView;
import lotto.step2.domain.LotteryStore;
import lotto.step2.view.ResultView;

public class LottoController {

    public static void main(String[] args) {

        // 로또 주문
        int orderPrice = InputView.inputOrderPrice();

        LotteryStore store = new LotteryStore(orderPrice);

        // 로또 주문 개수 출력
        ResultView.printOrderCount(store.getTotalCount());

        // 로또 번호 출력
        ResultView.printOrderLottoNumber(store.getLottos());

    }

}
