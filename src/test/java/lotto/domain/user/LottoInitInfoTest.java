package lotto.domain.user;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LottoInitInfoTest {
    @Test
    void 구매금액이_1000원_이상이어야_한다() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new LottoInitInfo(900))
            .withMessage("[ERROR] 구매 금액이 1000원 이상이어야 합니다.");
    }
}
