package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {

    @DisplayName("1~45 사이의 숫자로 로또 번호를 만들 수 있다. (1, 45 → 성공)")
    @ParameterizedTest
    @ValueSource(ints = {1, 45})
    public void test_1(int number) {
        assertThatCode(() -> new LottoNumber(number))
                .doesNotThrowAnyException();
    }

    @DisplayName("1~45 밖의 숫자는 예외 (0, 46 → 실패)")
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    public void test_2(int number) {
        assertThatThrownBy(() -> new LottoNumber(number))
                .isInstanceOf(RuntimeException.class);
    }

    @DisplayName("같은 숫자면 같은 로또 번호다. (3 과 3 → 같음, 3 과 4 → 다름)")
    @Test
    public void test_3() {
        assertThat(new LottoNumber(3)).isEqualTo(new LottoNumber(3));
        assertThat(new LottoNumber(3)).hasSameHashCodeAs(new LottoNumber(3));
        assertThat(new LottoNumber(3)).isNotEqualTo(new LottoNumber(4));
    }

    @DisplayName("숫자 그대로 출력된다. (7 → \"7\")")
    @Test
    public void test_4() {
        assertThat(new LottoNumber(7)).hasToString("7");
    }
}
