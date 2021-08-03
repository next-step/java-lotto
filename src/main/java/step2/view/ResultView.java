package step2.view;

import step2.domain.Lotto;
import step2.domain.LottoStatistics;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class ResultView {

    private static final String NUMBER_OF_COUNT_SUFFIX = "개를 구매했습니다.";

    public static void printCount(List<Lotto> lottos) {
        System.out.println(lottos.size() + NUMBER_OF_COUNT_SUFFIX);
    }

    public static void printLottos(List<Lotto> lottos) {
        lottos.forEach(System.out::println);
    }

    public static void printLottoStatistics(LottoStatistics lottoStatistics) {
        System.out.println("당첨 통계");
        System.out.println("-----------");
        printLottoStatistics(lottoStatistics.resultOfLottos());
        printLottoProfit(lottoStatistics.getProfit());
    }

    private static void printLottoProfit(BigDecimal profit) {
        System.out.println("총 수익률은 " + profit + "% 입니다.");
    }

    private static void printLottoStatistics(Map<Integer, Integer> resultOfLottos) {
        resultOfLottos.forEach((rank, count) -> {
            if (rank == 3) {
                System.out.println(rank + "개 일치 (5000원)- " + count);
            }
            if (rank == 4) {
                System.out.println(rank + "개 일치 (50000원)- " + count);
            }
            if (rank == 5) {
                System.out.println(rank + "개 일치 (1500000원)- " + count);
            }
            if (rank == 6) {
                System.out.println(rank + "개 일치 (2000000000원)- " + count);
            }
        });
    }


 /*   public void printResult(CarStadium carStadium) {
        carStadium.getAllCars().forEach(this::print);
        System.out.println();
    }

    private void print(Car car) {
        System.out.print(car.getName() + " : ");
        for (int i = 0; i < car.getMovedCount(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }*/
}
