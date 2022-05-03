package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoPrizesTest {
    @Test
    void LottoPrizes는_numbers없이_생성시_예외를_발생시킨다() {
        assertThatThrownBy(() -> {
            new LottoPrizes(null);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void LottoPrizes는_빈_numbers로_생성시_예외를_발생시킨다() {
        assertThatThrownBy(() -> {
            new LottoPrizes(Collections.emptyList());
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void prizeAmount는_상금_금액을_반환한다() {
        assertThat(new LottoPrizes(List.of(LottoPrize.FOURTH, LottoPrize.FOURTH)).prizeAmount().getValue())
                .isEqualTo(LottoPrize.FOURTH.getAmount().getValue() * 2);
    }

    @Test
    void purchaseAmount는_구매_금액을_반환한다() {
        assertThat(new LottoPrizes(List.of(LottoPrize.FOURTH, LottoPrize.FOURTH)).purchaseAmount().getValue())
                .isEqualTo(LottoVendingMachine.PRICE * 2);
    }
}
