package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;


class LottoNumberTest {

    @Test
    @DisplayName("lotto 생성 테스트")
    void createTest() {
        LottoNumber lottoNumber = new LottoNumber(1);
        assertThat(lottoNumber.value()).isEqualTo(1);
    }


    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    @DisplayName("lotto 는 1~45까지만 가능")
    void lottoNumberBetween1And45(int num) {
        assertThatExceptionOfType(IllegalArgumentException.class)
        .isThrownBy(() -> {new LottoNumber(num);});
    }
}