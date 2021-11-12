package lotto.step2.controller;

import lotto.step2.domain.LotteryCompany;
import lotto.step2.domain.LotteryStore;
import lotto.step2.view.InputView;

import static lotto.step2.view.InputView.printInputOrderPrice;
import static lotto.step2.view.ResultView.*;

public class LottoController {

    private static LotteryCompany company;
    private static LotteryStore store;

    public static void main(String[] args) {

        // 복권가게에 로또 주문
        int orderPrice = printInputOrderPrice();
        store = new LotteryStore(orderPrice);

        // 로또 주문 개수 출력
        printOrderCount(store.getTotalCount());

        // 로또 번호 출력
        printOrderLottoNumber(store.getLotteries());

        // 복권회사에 당첨번호 입력
        company = new LotteryCompany(InputView.printWinningNumber(), store.getLotteries());

        // 통계출력
        printWinnerStatics(company);

    }

}
