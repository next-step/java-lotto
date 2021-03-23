package lotto.view;

import lotto.domain.Statistics;
import lotto.dto.ResponseLottosDTO;
import lotto.dto.ResponsePurchaseCountDTO;
import lotto.dto.ResponseWinningDTO;

import java.util.Map;

public class ResultView {

    public static void printPurchaseCount(ResponsePurchaseCountDTO responsePurchaseCountDTO) {
        System.out.println(responsePurchaseCountDTO.getPurchaseCount() + "개를 구매했습니다.");
    }

    public static void printLottoNumber(ResponseLottosDTO responseLottosDTO) {
        System.out.println(responseLottosDTO.getLottoNumbers());
    }

    public static void printWinningStatistics(ResponseWinningDTO responseWinningDTO) {
        Map<Statistics, Integer> hit = responseWinningDTO.getHit();
        double yield = responseWinningDTO.getYield();

        hit.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey((a, b) -> a.getMatchCount() - b.getMatchCount()))
                .forEachOrdered(hitEntrySet -> {
                    System.out.println(hitEntrySet.getKey().getMatchCount() + "개 일치" + "(" + hitEntrySet.getKey().getMoney() + "원)- " + hitEntrySet.getValue() + "개");
                });

        System.out.printf("총 수익률은 %.2f입니다.", yield);
    }
}
