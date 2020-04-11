package lotto.domain.lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {

    @DisplayName("로또 번호를 생성 할 수 있다")
    @Test
    public void lottoNumberCreateTest() {
        LottoNumber numberOne = LottoNumber.of(1);
        LottoNumber anotherOne = LottoNumber.of(1);

        assertThat(numberOne).isEqualTo(anotherOne);
    }

    @DisplayName("로또 번호는 1과 45사이의 값만 허용된다")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    public void lottoNumberValidationTest(int source) {
        assertThatThrownBy(() -> LottoNumber.of(source))
                .isInstanceOf(LottoNumberRangeException.class)
                .hasMessageContaining("로또 번호는 1~45 사이의 수만 가능합니다.");
    }

    @DisplayName("로또 번호 리스트중 일치하는 번호가 있는지 확인한다.")
    @Test
    public void lottoNumbersMatchTest() {
        LottoNumber lottoNumber = LottoNumber.of(1);
        boolean matches = lottoNumber.matches(Arrays.asList(1, 2, 3, 4, 5, 6));

        Assertions.assertThat(matches).isEqualTo(true);
    }

}
