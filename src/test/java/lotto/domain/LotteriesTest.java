package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

public class LotteriesTest {
    @Test
    void 구매금액에_맞게_로또번호_리스트_생성() {
        // given
        int purchaseAmount = 14000;
        List<Set<Integer>> manualLottoNumbersList = List.of(
                Set.of(1, 2, 3, 4, 5, 6),
                Set.of(7, 8, 9, 10, 11, 12)
        );

        // when
        Lotteries lottoList = Lotteries.purchase(purchaseAmount, manualLottoNumbersList);

        // then
        Assertions.assertThat(lottoList.size()).isEqualTo(14);
    }

    @Test
    void 구매금액이_1000_보다_낮으면_예외_발생() {
        // given
        int purchaseAmount = 999;
        List<Set<Integer>> manualLottoNumbersList = List.of(
                Set.of(1, 2, 3, 4, 5, 6),
                Set.of(7, 8, 9, 10, 11, 12)
        );

        // when, then
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Lotteries.purchase(purchaseAmount, manualLottoNumbersList))
                .withMessage("구입금액은 1000 이상이어야 합니다");
    }

    @Test
    void 수동구매_수량의_가격이_구입금액을_초과하면_예외_발생() {
        // given
        int purchaseAmount = 2000;
        List<Set<Integer>> manualLottoNumbersList = List.of(
                Set.of(1, 2, 3, 4, 5, 6),
                Set.of(7, 8, 9, 10, 11, 12),
                Set.of(7, 8, 9, 10, 11, 12)
        );

        // when, then
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Lotteries.purchase(purchaseAmount, manualLottoNumbersList))
                .withMessage("수동 구매 수량의 가격이 구입금액을 초과했습니다");
    }
}
