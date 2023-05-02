package view;

import domain.Lotto;
import util.LottoSeller;
import domain.LottoResult;
import util.LottoManager;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LottoOutputView {
    public static void printLottoCount(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public static void printLottoList(List<Lotto> lottoList) {
        lottoList.forEach(System.out::println);
    }

    public static void printLottoResult(List<LottoResult> results) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        Arrays.stream(LottoResult.values())
                .filter(lottoResultType -> lottoResultType != LottoResult.NONE)
                .sorted(Comparator.comparingInt(LottoResult::matchCount))
                .forEach(lottoResultType -> {
                    System.out.println(lottoResultType.matchCount() + "개 일치 (" + lottoResultType.winningMoney() + "원) - " + results.stream()
                            .filter(result -> result == lottoResultType)
                            .count() + "개");
                });

        System.out.printf("총 수익률은 %.2f입니다.%n", LottoManager.calculateProfitRate(LottoSeller.LOTTO_PRICE * results.size(), LottoManager.sumOfLottoResult(results)));
    }
}
