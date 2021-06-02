package study.lotto.view;

import study.lotto.domain.*;

import java.math.BigDecimal;
import java.util.stream.Collectors;

public class ResultView {
    private static final String PURCHASE_MESSAGE = "%d개를 구매했습니다.\n";
    private static final String WINNING_PRIZE_RESULT_MESSAGE = "%d개 일치%s(%s원)- %d개\n";
    private static final String PROFIT_RATE_MESSAGE = "총 수익률은 %,.2f입니다.(기준이 1이기 때문에 결과적으로 %s라는 의미임)\n";


    private String checkBenefit(BigDecimal rate) {
        if (rate.compareTo(BigDecimal.ONE) < 0) {
            return "손해";
        }
        if (rate.compareTo(BigDecimal.ONE) > 0) {
            return "이득";
        }
        return "본전";
    }

    public void purchasedLottos(PurchasedLottos purchasedLottos) {
        System.out.printf(PURCHASE_MESSAGE,purchasedLottos.count());
        for (Lotto lotto : purchasedLottos.values()) {
            System.out.println(lotto.lotto().stream().map(LottoNumber::value).collect(Collectors.toList()));
        }
    }

    public void winningResult(WinningResult winningResult, BigDecimal profitRate) {
        for (LottoRank lottoRank : winningResult.value().keySet()) {
            System.out.printf(WINNING_PRIZE_RESULT_MESSAGE,
                    lottoRank.matchCount(),
                    secondPrizeMessage(lottoRank),
                    lottoRank.prize(),
                    winningResult.value().get(lottoRank));
        }
        System.out.printf(PROFIT_RATE_MESSAGE, profitRate, checkBenefit(profitRate));
    }

    private String secondPrizeMessage(LottoRank lottoRank) {
        if (lottoRank.equals(LottoRank.SECOND)) {
            return ", 보너스볼 일치";
        }
        return " ";
    }

}
