package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    @DisplayName("로또 번호가 1보다 작으면 IllegalArgumentException")
    void lotto_number_less_than_1(int input) {
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumber(input));
    }

    @ParameterizedTest
    @ValueSource(ints = {46, 123, 70, 1000})
    @DisplayName("로또 번호가 45보다 크면 IllegalArgumentException")
    void lotto_number_greater_than_45(int input) {
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumber(input));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 15, 45})
    @DisplayName("로또 번호가 1에서 45사이면 정상")
    void lotto_number_between_1_and_45(int input) {
        assertThatNoException().isThrownBy(() -> new LottoNumber(input));
    }

}