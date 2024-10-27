package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

public class LotteryBuyerTest {
    @Test
    void 구매금액과_수동로또번호에_맞게_로또_생성() {
        // given
        int purchaseAmount = 14000;
        List<Lottery> manualLottoNumbersList = List.of(
                new Lottery(Set.of(1, 2, 3, 4, 5, 6)),
                new Lottery(Set.of(7, 8, 9, 10, 11, 12))
        );
        LotteryBuyer lotteryBuyer = LotteryBuyer.of(purchaseAmount, manualLottoNumbersList.size());

        // when
        Lotteries lotteries = lotteryBuyer.purchaseLotteries(manualLottoNumbersList);

        // then
        Assertions.assertThat(lotteries.size()).isEqualTo(14);
    }

    @Test
    void 구매금액이_1000_보다_낮으면_예외_발생() {
        // given
        int purchaseAmount = 999;
        int manualLotteryCount = 1;

        // when, then
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> LotteryBuyer.of(purchaseAmount, manualLotteryCount))
                .withMessage("구입금액은 1000 이상이어야 합니다");
    }

    @Test
    void 수동구매_수량의_가격이_구입금액을_초과하면_예외_발생() {
        // given
        int purchaseAmount = 2000;
        int manualLotteryCount = 3;

        // when, then
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> LotteryBuyer.of(purchaseAmount, manualLotteryCount))
                .withMessage("수동 구매 수량의 가격이 구입금액을 초과했습니다");
    }
}
