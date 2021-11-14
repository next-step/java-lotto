package lotto.step2.view;

import lotto.step2.domain.Lotteries;
import lotto.step2.domain.LotteryCompany;

import static lotto.step2.domain.LotteryCompany.*;

public final class ResultView {

    private ResultView() {
        throw new AssertionError();
    }

    public static void printOrderCount(int orderCount) {
        System.out.println(orderCount + "개를 구매했습니다.");
    }

    public static void printOrderLottoNumber(Lotteries lotteries) {
        lotteries.getLotteries().stream()
                .map(lotto -> lotto.getNumbers().getNumbers())
                .forEach(System.out::println);
        System.out.println();
    }

    public static void printWinnerStatics(LotteryCompany company) {
        System.out.println("당첨 통계");
        System.out.println("----------");
        for (int i = 3; i <= 6; i++) {
            System.out.println(i + "개 일치("
                    + company.getPrizeMoney().get(i) + "원) - "
                    + company.getTotalCountOfMatch(i));
        }
    }

    public static void printRateOfReturn(LotteryCompany company, int orderPrice) {
        System.out.println("총 수익률은 " + company.getRateOfReturn(orderPrice) + "입니다.");
    }

}
