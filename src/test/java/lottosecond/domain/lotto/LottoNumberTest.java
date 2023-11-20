package lottosecond.domain.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {

    @ParameterizedTest(name = "로또 번호가 1보다 작거나 45보다 큰 경우 IllegalArgumentException 을 발생합니다.")
    @ValueSource(ints = {0, 46})
    void invalidNumber(int number) {
        // given
        // when
        // then
        assertThatThrownBy(() -> LottoNumber.of(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 범위는 1 ~ 45 범위만 가능합니다.");
    }

    @Test
    @DisplayName("LottoNumber.of() 메서드를 통해 기존에 인스턴스가 없으면 새로 만들고 있으면 기존 인스턴스를 반환합니다.")
    void of() {
        // given
        LottoNumber first = LottoNumber.of(1);
        LottoNumber second = LottoNumber.of(1);
        // when
        // then
        assertThat(first).isEqualTo(second);
        assertThat(first).isSameAs(second);
    }
}