package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Test;

public class LottoAmountTest {

    @Test
    void 수동구매금액초과() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> LottoAmount.of(0).remainderAfterManualPurchase(10))
            .withMessageMatching("수동 구매에 필요한 금액이 부족합니다 : " + 10_000 + "원/" + 10 + "장");
    }

    @Test
    void 자동구매금액계산() {
        LottoAmount actual = LottoAmount.of(10_000);
        assertAll(
            () -> assertThat(actual.remainderAfterManualPurchase(0)).isEqualTo(10_000),
            () -> assertThat(actual.remainderAfterManualPurchase(5)).isEqualTo(5_000),
            () -> assertThat(actual.remainderAfterManualPurchase(10)).isEqualTo(0)
        );
    }

    @Test
    void 구매장수계산() {
        assertAll(
            () -> assertThat(LottoAmount.of(1000).count()).isEqualTo(1),
            () -> assertThat(LottoAmount.of(1999).count()).isEqualTo(1),
            () -> assertThat(LottoAmount.of(2000).count()).isEqualTo(2)
        );
    }

    @Test
    void 로또금액생성() {
        assertThat(LottoAmount.of(1000)).isEqualTo(LottoAmount.of(1000));
    }

}
