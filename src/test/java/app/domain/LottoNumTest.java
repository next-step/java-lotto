package app.domain;

import app.domain.lotto.LottoNum;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoNumTest {

    @DisplayName("로또번호는 1~45 사이 숫자만 가능하다.")
    @Test
    void boundaryTest() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> LottoNum.of(-1)
        ).withMessageContaining("범위");
    }

    @DisplayName("캐쉬 적용하기")
    @Test
    void cacheTest() {
        LottoNum num1 = LottoNum.of(30);

        assertThat(num1).isEqualTo(LottoNum.of(30));
    }

}