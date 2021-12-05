package lotto;

import lotto.domain.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.domain.LottoNumber.BOUND_END;
import static lotto.domain.LottoNumber.BOUND_START;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LottoNumberTest {

    @Test
    @DisplayName("bound 보다 큰 숫자 exception test")
    void checkBoundTest() {
        int boundNumber = 46;
        assertThatThrownBy(() -> {
            LottoNumber.ofInt(boundNumber);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(BOUND_END + "보다 큰 숫자가 입력될 수 없습니다.");

        int boundNumber1 = 0;
        assertThatThrownBy(() -> {
            LottoNumber.ofInt(boundNumber1);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(BOUND_START + "보다 작은 숫자가 입력될 수 없습니다.");
    }

    @Test
    @DisplayName("LottoNumber ofInt 로 인스턴스가 잘 만들어졌는지 Test")
    void numberTest() {
        assertThat(LottoNumber.ofInt(10)).isEqualTo(LottoNumber.ofInt(10));
    }

    @Test
    @DisplayName("LottoNumber ofString 로 인스턴스가 잘 만들어졌는지 Test")
    void ofStringTest() {
        assertThat(LottoNumber.ofString("10")).isEqualTo(LottoNumber.ofInt(10));
    }

    @Test
    @DisplayName("1부터 45까지의 LottoNumber의 cache가 잘 만들어졌는지 test ")
    void cacheTest() {
        assertTrue(LottoNumber.ofInt(1)==LottoNumber.ofInt(1));
    }
}
