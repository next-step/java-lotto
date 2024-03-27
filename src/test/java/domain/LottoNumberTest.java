package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {

    @DisplayName("1~45 사이의 숫자로만 생성이 가능하다.")
    @Test
    void test01() {
        assertThatThrownBy(() -> new LottoNumber(46))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1~45 사이의 숫자만 가능합니다.");
    }

    @DisplayName("1~45 사이 랜덤한 값을 구한다.")
    @Test
    void test02() {
        LottoNumber random = LottoNumber.random(new Random() {
            @Override
            public int nextInt(int bound) {
                return 44;
            }
        });

        assertThat(random).isEqualTo(new LottoNumber(45));
    }
}
