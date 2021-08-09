package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class LottoNumberTest {
    @Test
    @DisplayName("LottoNumber 는 숫자값으로 equals 판단한다.")
    public void create() {
        LottoNumber lottoNumber = new LottoNumber(3);
        assertThat(lottoNumber).isEqualTo(new LottoNumber(3));
    }

    @ParameterizedTest
    @DisplayName("LottoNumber 가 1 ~ 45 사이의 자연수가 아닐 경우, IllegalArgumentException")
    @ValueSource(ints = {0, 46})
    public void numberRange(int illegalNumber) {
        assertThatThrownBy(() -> {
            new LottoNumber(illegalNumber);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}