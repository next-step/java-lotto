package ui;

import domain.LottoResult;

import java.util.List;

public class ResultView {
    private static final String BUYING_AMOUNT_IS = "개를 구매했습니다.";

    public static void printBuyingLottos(List<List<Integer>> lottoNumbers) {
        System.out.print(lottoNumbers.size());
        System.out.println(BUYING_AMOUNT_IS);

        lottoNumbers.stream().forEach(System.out::println);
    }

    public static void printLottoResult(LottoResult lottoResult) {
        System.out.println("당첨 통계\n---------");
        System.out.print("3개 일치 (5000원)- ");
        System.out.println(lottoResult.getFourthPrizeCount());
        System.out.print("4개 일치 (50000원)- ");
        System.out.println(lottoResult.getThirdPrizeCount());
        System.out.print("5개 일치 (1500000원)- ");
        System.out.println(lottoResult.getSecondPrizeCount());
        System.out.print("6개 일치 (2000000000원)- ");
        System.out.println(lottoResult.getFirstPrizeCount());
        System.out.printf("총 수익률은 %f입니다.", lottoResult.getProfitRates());
    }
}
