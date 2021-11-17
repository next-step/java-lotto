package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 27, 45})
    @DisplayName("로또번호는 1이상 45이하의 범위를 갖는다.")
    void 로또번호생성_성공(int number) {
        LottoNumber lottoNumber = new LottoNumber(number);
        assertThat(lottoNumber).isEqualTo(new LottoNumber(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    @DisplayName("로또번호는 1이상 45이하의 범위를 갖는다.")
    void 로또번호생성_실패(int number) {
        assertThatThrownBy(() -> {
            new LottoNumber(number);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
