package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by seungwoo.song on 2022-10-06
 */
class LottoStatisticTest {

    @Test
    void 통계정보() {
        LottoNumber bonusNumber = LottoNumber.of(7);
        Lotto beforeWinLotto = Lotto.ofInteger(List.of(1, 2, 3, 4, 5, 6));
        PurchaseInfo purchaseInfo = new PurchaseInfo(6000);

        List<Lotto> lottos = List.of(
                Lotto.ofInteger(List.of(1, 10, 11, 12, 13, 14)),
                Lotto.ofInteger(List.of(1, 2, 10, 11, 12, 13)),
                Lotto.ofInteger(List.of(1, 2, 3, 10, 11, 12)),
                Lotto.ofInteger(List.of(1, 2, 3, 4, 10, 11)),
                Lotto.ofInteger(List.of(1, 2, 3, 4, 5, 10)),
                Lotto.ofInteger(List.of(1, 2, 3, 4, 5, 7)),
                Lotto.ofInteger(List.of(1, 2, 3, 4, 5, 6)));

        LottoStatistic lottoStatistic = new LottoStatistic();

        lottoStatistic.analyze(lottos, beforeWinLotto, purchaseInfo, bonusNumber);

        int sum = Arrays.stream(LottoResult.values())
                .map(LottoResult::getMoney)
                .reduce(0, Integer::sum)
                .intValue();

        assertThat(lottoStatistic.getWinMoneyTotal()).isEqualTo(sum);
        assertThat(lottoStatistic.getLottoResultCounter().get(LottoResult.FIRST)).isEqualTo(1);
        assertThat(lottoStatistic.getRevenue()).isEqualTo(Double.valueOf(sum) / Double.valueOf(6000));
        assertThat(lottoStatistic.isLost()).isFalse();
    }

    @Test
    void 이등() {
        LottoNumber bonusNumber = LottoNumber.of(7);
        Lotto beforeWinLotto = Lotto.ofInteger(List.of(1, 2, 3, 4, 5, 6));
        PurchaseInfo purchaseInfo = new PurchaseInfo(3000);

        List<Lotto> lottos = List.of(
                Lotto.ofInteger(List.of(1, 2, 3, 4, 5, 7)));

        LottoStatistic lottoStatistic = new LottoStatistic();

        lottoStatistic.analyze(lottos, beforeWinLotto, purchaseInfo, bonusNumber);

        assertThat(lottoStatistic.getLottoResultCounter().get(LottoResult.SECOND)).isEqualTo(1);
    }
}