package lotto.step2.controller;

import lotto.step2.domain.Lotteries;
import lotto.step2.domain.LotteryCompany;
import lotto.step2.domain.LotteryStore;
import lotto.step2.view.InputView;

import static lotto.step2.view.InputView.printInputOrderPrice;
import static lotto.step2.view.ResultView.*;

public class LottoController {

    public static void main(String[] args) {

        // 복권가게에 로또 주문
        int orderPrice = printInputOrderPrice();
        LotteryStore store = new LotteryStore(orderPrice);

        // 로또 주문 개수 출력
        printOrderCount(store.getOrderCount());

        // 로또 번호 출력
        Lotteries lotteries = store.getLotteries();
        printOrderLottoNumber(lotteries);

        // 복권회사에 당첨번호 입력
        LotteryCompany company = new LotteryCompany(InputView.printWinningNumber(), lotteries);

        // 당첨 통계 출력
        printWinnerStatics(company);

        // 총 수익률 출력
        printRateOfReturn(company, orderPrice);
    }

}
