package lotto.domain;

import lotto.exception.OutOfRangeException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoNumberTest {
    @ValueSource(ints = {
            1, 45
    })
    @ParameterizedTest
    public void lottoNumberTest_생성자(int number) {
        assertThat(new LottoNumber(number).intValue())
                .isEqualTo(number);
    }

    @ValueSource(ints = {
            0, 46
    })
    @ParameterizedTest
    public void lottoNumberTest_생성자_유효성에러(int number) {
        assertThatThrownBy(() -> {
            lottoNumberTest_생성자(number);
        }).isInstanceOf(OutOfRangeException.class);
    }
}