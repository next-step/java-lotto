package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

public class LotteriesTest {
    @Test
    void 수동로또번호와_자동로또개수에_맞게_로또_생성() {
        // given
        List<Lottery> manualLottoNumbersList = List.of(
                new Lottery(Set.of(1, 2, 3, 4, 5, 6)),
                new Lottery(Set.of(7, 8, 9, 10, 11, 12))
        );
        int autoLotteryCount = 12;

        // when
        Lotteries lotteries = new Lotteries(manualLottoNumbersList, autoLotteryCount);

        // then
        Assertions.assertThat(lotteries.size()).isEqualTo(14);
    }
}
