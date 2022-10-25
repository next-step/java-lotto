package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import lotto.domain.Lotto;
import lotto.domain.LottoPlace;
import lotto.domain.LottoWinners;

public class OutputView {

    private OutputView() {
    }

    public static void printLottoList(List<Lotto> lottoList) {
        lottoList.forEach(System.out::println);
    }

    public static void printWinner(Map<LottoPlace, Long> winners) {
        Arrays.stream(LottoPlace.values())
            .filter(lottoPlace -> lottoPlace != LottoPlace.NONE_PLACE)
            .forEach(lottoPlace -> System.out.printf("%d개 일치 (%d원)- %d\n", lottoPlace.getCount()
                , lottoPlace.getPrize(), winners.getOrDefault(lottoPlace, 0L)));
    }

    public static void printYield(double yield) {
        System.out.printf("총 수익률은 %.2f입니다.", yield);
    }
}
