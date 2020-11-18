package lotto.view;

import lotto.dto.result.LottosDto;
import lotto.dto.result.NumOfLottosDto;
import lotto.dto.result.StatisticsDto;
import lotto.view.printable.LottosPrintable;
import lotto.view.printable.NumOfLottosPrintable;
import lotto.view.printable.StatisticsPrintable;

public class ResultView {
    private ResultView() {}

    public static void printNumOfLottos(NumOfLottosDto numOfLottosDto) {
        new NumOfLottosPrintable(numOfLottosDto).print();
    }

    public static void printLottos(LottosDto lottosDto) {
        new LottosPrintable(lottosDto).print();
    }

    public static void printStatistics(StatisticsDto statisticsDto) {
        new StatisticsPrintable(statisticsDto).print();
    }
}
