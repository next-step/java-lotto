package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static lotto.domain.LottoNumber.LOTTO_NUMBER_NOT_BETWEEN_1_AND_45_MESSAGE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoNumberTest {

    @DisplayName("로또번호는 1-45 사이의 숫자로 만들어진다.")
    @ParameterizedTest
    @ValueSource(ints = {11, 22, 33})
        //given
    void lotto_number_create(final int number) {
        //when, then
        assertThat(new LottoNumber(number).getNumber()).isEqualTo(number);
    }

    @DisplayName("로또번호 숫자가 1-45 범위를 벗어나면 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
        //given
    void not_number_between_1_and_45(final int number) {
        //when, then
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumber(number))
                .withMessageMatching(LOTTO_NUMBER_NOT_BETWEEN_1_AND_45_MESSAGE);
    }
}
