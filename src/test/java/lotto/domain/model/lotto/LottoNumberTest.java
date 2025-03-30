package lotto.domain.model.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {

    @DisplayName("로또 번호 생성 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 10, 45})
    void createLottoNumber(int number) {
        LottoNumber lottoNumber = new LottoNumber(number);

        assertThat(lottoNumber.toString()).isEqualTo(String.valueOf(number));
    }

    @DisplayName("로또 번호 범위 검증 테스트")
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void validateLottoNumberRange(int invalidNumber) {
        assertThatThrownBy(() -> new LottoNumber(invalidNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호는 1부터 45 사이의 숫자여야 합니다");
    }
} 
