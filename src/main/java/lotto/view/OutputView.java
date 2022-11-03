package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import lotto.domain.Lotto;
import lotto.domain.LottoList;
import lotto.domain.LottoPlace;
import lotto.domain.LottoWinners;

public class OutputView {

    private OutputView() {
    }

    public static void printLottoList(LottoList lottoList) {
        printPriceCount(lottoList);
        printLottoList(lottoList.getLottoList());
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

    private static void printPriceCount(LottoList lottoList) {
        System.out.printf("수동으로 %d장, 자동으로 %d를 구매했습니다.\n", lottoList.getManualListCount()
            , lottoList.getAutoListCount());
    }

    public static void printLottoList(List<Lotto> lottoList) {
        lottoList.forEach(System.out::println);
    }
}
