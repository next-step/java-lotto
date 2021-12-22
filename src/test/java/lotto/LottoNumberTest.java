package lotto;

import lotto.lotto.lottonumber.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {

    @Test
    @DisplayName("LottoNumber 객체를 생성한다")
    void shouldCreateSameObject() {
        LottoNumber lottoNumber = LottoNumber.from("1");
        assertThat(lottoNumber).isEqualTo(LottoNumber.from("1"));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    @DisplayName("로또 번호가 1 이상 45 이하가 아니면 LottoNumber 객체를 생성할 수 없다")
    void shouldThrowWhenInputNotInRange(int input) {
        assertThatThrownBy(() -> LottoNumber.from(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 1 이상 45 이하여야 합니다.");
    }
}