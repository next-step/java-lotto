package lotto.domain;

import lotto.exception.LottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {

    @DisplayName("로또의 숫자범위 1부터45를 벗어난는 경우")
    @ParameterizedTest
    @ValueSource(ints = {0, 46, 100, -5})
    void lottoNumberOutOfRange(int input) {
        assertThatThrownBy(() -> {
            LottoNumber lottoNumber = new LottoNumber(input);
        }).isInstanceOf(LottoException.class)
                .hasMessage("1부터 45사이의 숫자를 입력해주세요");
    }

}