package study.lotto.domain;

import study.lotto.service.Lottos;
import study.lotto.view.dto.RequestMoney;
import study.lotto.view.dto.RequestWinningNumber;

import java.util.List;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * Lotto 결과에 대한 통계 클래스
 */
public class LottoResult {

    private final RequestWinningNumber winningNumber;
    private final RequestMoney money;
    private final Lottos lottos;

    public LottoResult(RequestMoney requestMoney, final RequestWinningNumber winningNumber, final Lottos lottos) {
        this.money = requestMoney;
        this.winningNumber = winningNumber;
        this.lottos = lottos;
    }

    public int count(final LottoMatch lottoMatch) {
        List<Lotto> lotteries = lottos.getLotteries();

        return lotteries.stream()
                .collect(
                        groupingBy(lotto -> lotto.match(winningNumber), counting())
                )
                .getOrDefault(lottoMatch, 0L)
                .intValue();
    }

    public double winningRate() {
        List<Lotto> lotteries = lottos.getLotteries();
        int money = this.money.getMoney();

        long sum = lotteries.stream()
                .map(lotto -> lotto.winningReward(winningNumber))
                .mapToLong(Long::longValue)
                .sum();
        // 1.0 * 당첨 합계 / 구매 금액
        return 1.0 * sum / money;
    }

}
