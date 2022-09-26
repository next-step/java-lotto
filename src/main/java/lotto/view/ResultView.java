package lotto.view;

public class ResultView {

    public static void printLottoResult(LottoResult result) {
        System.out.println(result.quantity() + "개를 구매했습니다.");
        result.lottos().forEach(System.out::println);
        System.out.println();
    }

    public static void printLottoStatistics(LottoStatistics lottoStatistics) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println("총 수익률은 " + lottoStatistics.benefit() + "입니다.");
    }
}
