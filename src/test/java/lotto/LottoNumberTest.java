package lotto;

import lotto.domain.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.domain.LottoNumber.BOUND_END;
import static lotto.domain.LottoNumber.BOUND_START;
import static org.assertj.core.api.Assertions.*;

public class LottoNumberTest {

    @Test
    @DisplayName("45")
    void checkBoundTest() {
        int boundNumber = 46;
        assertThatThrownBy(() -> {
            new LottoNumber(boundNumber);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(BOUND_END + "보다 큰 숫자가 입력될 수 없습니다.");

        int boundNumber1 = 0;
        assertThatThrownBy(() -> {
            new LottoNumber(boundNumber1);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(BOUND_START + "보다 작은 숫자가 입력될 수 없습니다.");
    }

    @Test
    @DisplayName("LottoNumber 클래스 equal 테스트")
    void numberTest() {
        assertThat(new LottoNumber(10)).isEqualTo(new LottoNumber(10));
    }
}
