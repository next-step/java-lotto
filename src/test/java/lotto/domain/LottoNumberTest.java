package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoNumberTest {

    @DisplayName("로또번호 숫자를 11,22,33 으로 생성시 11,22,33 으로 리턴하는지")
    @ParameterizedTest
    @ValueSource(ints = {11, 22, 33})
        //given
    void lotto_number_create(final int number) {
        //when, then
        assertThat(new LottoNumber(number).getNumber()).isEqualTo(number);
    }

    @DisplayName("로또번호 숫자가 1-45 범위를 벗어날 때 에러나는지")
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
        //given
    void not_number_between_1_and_45(final int number) {
        //when, then
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumber(number));
    }
}
