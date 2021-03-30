package lotto.view;

import lotto.domain.Statistics;
import lotto.dto.ResponseLottosDTO;
import lotto.dto.ResponseWinningDTO;

import java.util.Comparator;
import java.util.Map;

public class ResultView {

    public static void printPurchaseCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public static void printLottoNumber(ResponseLottosDTO responseLottosDTO) {
        System.out.println(responseLottosDTO.getLottoNumbers());
    }

    public static void printWinningStatistics(ResponseWinningDTO responseWinningDTO) {
        Map<Statistics, Integer> hit = responseWinningDTO.getHit();
        double yield = responseWinningDTO.getYield();

        hit.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey(Comparator.comparingLong(Statistics::getMoney)))
                .forEachOrdered(ResultView::printHitEntry);

        System.out.printf("총 수익률은 %.2f입니다.", yield);
    }

    private static void printHitEntry(Map.Entry<Statistics, Integer> hitEntrySet) {
        if (hitEntrySet.getKey() == Statistics.BONUS) {
            System.out.println(hitEntrySet.getKey().getMatchCount() + "개 일치, 보너스 볼 일치 (" + hitEntrySet.getKey().getMoney() + "원) - " + hitEntrySet.getValue() + "개");
            return;
        }
        System.out.println(hitEntrySet.getKey().getMatchCount() + "개 일치" + "(" + hitEntrySet.getKey().getMoney() + "원)- " + hitEntrySet.getValue() + "개");
    }
}
