package lotto.factory;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import lotto.domain.UserLottoFactory;
import org.junit.jupiter.api.Test;

class UserLottoFactoryTest {
    @Test
    void 로또_구매_금액이_1000원_이하이면_예외처리() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> UserLottoFactory.getLottoQuantity(900))
            .withMessage("[ERROR] 구매 금액이 1000원 이상이어야 합니다.");
    }

    @Test
    void 로또_구매_개수_정상결과() {
        assertThat(UserLottoFactory.getLottoQuantity(14000))
            .isEqualTo(14);
    }
}
