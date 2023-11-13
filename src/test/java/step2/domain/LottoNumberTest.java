package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoNumberTest {

    @Test
    @DisplayName("로또넘버 생성 테스트")
    void create() {
        LottoNumber lottoNumber = LottoNumber.of(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, 46})
    @DisplayName("로또넘버는의 입력이 1~45사이의 숫자가 아닌 경우 예외를 발생한다.")
    void validate(int input) {
        assertThatIllegalArgumentException().isThrownBy(()->LottoNumber.of(input));
    }

    @DisplayName("로또넘버는의 입력이 1~45사이의 숫자인 경우 로또넘버를 반환한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 45})
    void validate2(int input) {
        assertThat(LottoNumber.of(input).number()).isEqualTo(input);
    }

}
