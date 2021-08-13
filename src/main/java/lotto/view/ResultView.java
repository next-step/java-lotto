package lotto.view;

import lotto.domain.LottoNumbers;
import lotto.domain.LottoStatus;
import lotto.domain.Result;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ResultView {

    public static void print(List<LottoNumbers> lottoTickets) {
        System.out.println(lottoTickets.size() + "개를 구매했습니다.");
        lottoTickets.forEach(System.out::println);
    }

    public static void print(Result result) {
        List<LottoStatus> lottoStatuses = Stream.of(LottoStatus.values()).filter(lottoStatus -> !Objects.equals(lottoStatus, LottoStatus.NOTHING))
                .collect(Collectors.toList());
        for (LottoStatus lottoStatus : lottoStatuses) {
            System.out.print(lottoStatus.getHitCount() + "개 일치 (" + lottoStatus.getWinningAmount() + ")");
            System.out.println("-" + result.findCount(lottoStatus) + "개");
        }
        printRatio(result);
    }

    private static void printRatio(Result result) {
        System.out.print("총 수익율은 " + result.calculateRatio() + "입니다.");
        if (result.isProfit()) {
            System.out.println("(기준이 1이기 때문에 결과적으로 이익)");
            return;
        }
        System.out.println("(기준이 1이기 때문에 결과적으로 손해)");
    }
}
