package lotto.step2.view;

import lotto.step2.domain.LotteryCompany;
import lotto.step2.domain.Lotto;

import java.util.List;

public final class ResultView {

    private ResultView() {
        throw new AssertionError();
    }

    public static void printOrderCount(int totalCount) {
        System.out.println(totalCount + "개를 구매했습니다.");
    }

    public static void printOrderLottoNumber(List<Lotto> lotteries) {
        lotteries.stream()
                .map(lotto -> lotto.getLottoNumber().getNumber())
                .forEach(System.out::println);
    }

    public static void printWinnerStatics(LotteryCompany company) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("----------");
        System.out.println("3개 일치(500원) - " + company.getActualCountOfMatch(3));
        System.out.println("4개 일치(50000원) - " + company.getActualCountOfMatch(4));
        System.out.println("5개 일치(15000000원) - " + company.getActualCountOfMatch(5));
        System.out.println("6개 일치(2000000000000원) - " + company.getActualCountOfMatch(6));
    }

}
