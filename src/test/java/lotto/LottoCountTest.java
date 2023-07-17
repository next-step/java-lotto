package lotto;

import lotto.domain.LottoCount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoCountTest {

    @DisplayName("로또의 개수가 음수라면 예외가 발생한다")
    @Test
    void 로또_개수_검증_실패() {
        int manualCount = 10;
        int randomCount = -1;

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new LottoCount(manualCount, randomCount))
                .withMessage("금액이 부족합니다. 로또 한 개 가격 : 1,000 수동 로또 개수 : 10개");
    }

}
