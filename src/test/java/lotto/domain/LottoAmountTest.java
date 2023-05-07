package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Test;

public class LottoAmountTest {

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
