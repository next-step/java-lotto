package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoPrizesTest {
    @ParameterizedTest
    @NullAndEmptySource
    void LottoPrizes는_lottoPrizes없이_생성시_예외를_발생시킨다(List<LottoPrize> lottoPrizes) {
        assertThatThrownBy(() -> {
            new LottoPrizes(lottoPrizes);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void prizeAmount는_상금_금액을_반환한다() {
        assertThat(new LottoPrizes(List.of(LottoPrize.FOURTH, LottoPrize.FOURTH)).prizeAmount().getAmount())
                .isEqualTo(LottoPrize.FOURTH.getAmount() * 2);
    }

    @Test
    void purchaseAmount는_구매_금액을_반환한다() {
        assertThat(new LottoPrizes(List.of(LottoPrize.FOURTH, LottoPrize.FOURTH)).purchaseAmount().getAmount())
                .isEqualTo(LottoVendingMachine.PRICE * 2);
    }

    @Test
    void toEarningRate는_EarningRate를_생성_가능하다() {
        LottoPrizes lottoPrizes = new LottoPrizes(List.of(LottoPrize.FOURTH, LottoPrize.FOURTH));

        assertThat(lottoPrizes.toEarningRate().getEarningRate())
                .isEqualTo((double) lottoPrizes.prizeAmount().getAmount() / lottoPrizes.purchaseAmount().getAmount());
    }
}
