package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {

    @DisplayName("로또 번호는 1에서 45까지 입력이 가능하다")
    @Test
    void valueOf_ValidNumber_LottoNumberInstance() {
        IntStream.rangeClosed(1, 45).forEach(i -> {
            LottoNumber lottoNumber = LottoNumber.valueOf(i);
            assertThat(lottoNumber).isInstanceOf(LottoNumber.class);
        });
    }

    @DisplayName("로또 번호 범위를 벗어나면 예외가 발생한다")
    @Test
    void valueOf_InvalidNumber_ExceptionThrown() {
        assertThatThrownBy(() ->  LottoNumber.valueOf(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호가 올바르지 않습니다.");

        assertThatThrownBy(() ->  LottoNumber.valueOf(46))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호가 올바르지 않습니다.");
    }
}
