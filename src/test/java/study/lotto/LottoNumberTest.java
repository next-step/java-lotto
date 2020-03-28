package study.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import study.lotto.domain.LottoNumber;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoNumberTest {
    @DisplayName("1부터 45까지의 숫자를 받을 수 있다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 23, 45})
    void defaultValue(int number) {
        assertThat(new LottoNumber(number).getNumber()).isEqualTo(number);
        assertThat(new LottoNumber(number)).isEqualTo(new LottoNumber(number));
    }

    @DisplayName("1미만 45초과의 숫자는 입력받을 수 없다.")
    @ParameterizedTest
    @ValueSource(ints = {0, -1, 46})
    void invalidValue(int number) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new LottoNumber(number);
                });
    }
}
