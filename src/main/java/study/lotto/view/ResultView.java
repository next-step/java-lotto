package study.lotto.view;

import study.lotto.domain.*;

import java.math.BigDecimal;
import java.util.stream.Collectors;

public class ResultView {
    private static final String PURCHASE_MESSAGE = "%d개를 구매했습니다.\n";
    private static final String WINNING_PRIZE_RESULT_MESSAGE = "%d개 일치 (%s원)- %d개\n";
    private static final String PROFIT_RATE_MESSAGE = "총 수익률은 %,.2f입니다.%s\n";


    private String additionalMessage(BigDecimal rate) {
        if (rate.compareTo(BigDecimal.ONE) < 0) {
            return "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
        }
        return "";
    }

    public void purchasedLottos(PurchasedLottos purchasedLottos) {
        System.out.printf(PURCHASE_MESSAGE,purchasedLottos.count());
        for (LottoNumbers lottoNumbers : purchasedLottos.values()) {
            System.out.println(lottoNumbers.lottoNumbers().stream().map(LottoNumber::value).collect(Collectors.toList()));
        }
    }

    public void winningResult(WinningResult winningResult, BigDecimal profitRate) {
        for (WinningPrize winningPrize : winningResult.value().keySet()) {
            System.out.printf(WINNING_PRIZE_RESULT_MESSAGE,
                    winningPrize.matchCount(),
                    winningPrize.prize(),
                    winningResult.value().get(winningPrize));
        }
        System.out.printf(PROFIT_RATE_MESSAGE, profitRate, additionalMessage(profitRate));
    }

}
