package lotto.view;

import lotto.dto.LottosDto;
import lotto.dto.StatisticsDto;

public class ResultView {
    private ResultView() {}

    private static void println(Object str) {
        System.out.println(str);
    }

    public static void printNumOfLottos(int numOfLottos) {
        println(numOfLottos + "개를 구매했습니다.");
    }

    public static void printLottos(LottosDto lottos) {
        println(lottos);
    }

    public static void printStatistics(StatisticsDto statisticsDto) {
        println(statisticsDto.toStatistics());
    }
}
