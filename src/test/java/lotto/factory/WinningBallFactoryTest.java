package lotto.factory;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

import lotto.domain.LottoResult;
import org.junit.jupiter.api.Test;

class WinningBallFactoryTest {

    @Test
    void 보너스번호와_당첨번호_간_중복이_있을_때_예외처리() {
        String [] numbers = {"1", "2", "3", "4", "5", "6"};

        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> WinningBallFactory.of(numbers, "6"))
            .withMessage("[ERROR] 보너스 번호와 당첨 번호가 같습니다.");
    }
}
