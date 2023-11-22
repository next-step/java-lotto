package view;

import domain.Currency;
import domain.Lotto;
import domain.LottoPrize;
import repository.LottoGameResultRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ResultView {

    private ResultView() {
    }

    public static void printLottoCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public static void printLottoNumbers(List<Lotto> lottoTickets) {
        for (Lotto lottoTicket : lottoTickets) {
            System.out.println(lottoTicket.getLottoNumbers());
        }
        System.out.println();
    }

    public static void printLottoGameResult(LottoGameResultRepository lottoMatchResult, float rate, Optional<Currency> currency) {
        System.out.println("\n당첨 통계");
        System.out.println("---------");

        Map<LottoPrize, Integer> allResult = lottoMatchResult.getAllResult();
        for (Map.Entry<LottoPrize, Integer> result : allResult.entrySet()) {
            if (result.getKey().equals(LottoPrize.NO_MATCH)) {
                continue;
            }
            System.out.print(String.format("%d개 일치 ", result.getKey().getMatchCount()));
            if (result.getKey().equals(LottoPrize.SECOND)) {
                System.out.print(", 보너스볼 일치");
            }
            System.out.println(String.format(" (%d%s) - %d개"
                    , result.getKey().winningPrize()
                    , currency.get().getCurrencyType()
                    , result.getValue()
            ));
        }

        System.out.print(String.format("총 수익률은 %.2f 입니다.", rate));
        if (rate < 1) {
            System.out.println(" (기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }
    }
}
