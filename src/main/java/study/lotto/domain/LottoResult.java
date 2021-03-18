package study.lotto.domain;

import study.lotto.domain.type.LottoMatch;
import study.lotto.service.Lottos;
import study.lotto.view.dto.RequestWinningNumber;

import java.util.List;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * Lotto 결과에 대한 통계 클래스
 */
public class LottoResult {

    private final RequestWinningNumber winningNumber;
    private final LottoNumber bonusNumber;
    private final Lottos lottos;

    public LottoResult(final RequestWinningNumber winningNumber, final Lottos lottos, final LottoNumber bonusNumber) {
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
        this.lottos = lottos;
    }

    public long count(final LottoMatch lottoMatch) {
        List<Lotto> lotteries = lottos.getLottoList();

        return lotteries.stream()
                .collect(
                        groupingBy(lotto -> lotto.match(winningNumber, bonusNumber), counting())
                )
                .getOrDefault(lottoMatch, 0L);
    }

    public double winningRate() {
        List<Lotto> lotteries = lottos.getLottoList();
        int money = lottos.paidMoney();

        long sum = lotteries.stream()
                .mapToLong(lotto -> lotto.winningReward(winningNumber, bonusNumber))
                .sum();
        // 1.0 * 당첨 합계 / 구매 금액
        return 1.0 * sum / money;
    }

}
