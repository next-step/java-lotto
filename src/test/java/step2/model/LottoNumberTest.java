package step2.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {

    @DisplayName("valueOf() 정적 생성자는 1 ~ 45까지 숫자 입력이 가능하다")
    @ValueSource(ints = {1, 45})
    @ParameterizedTest
    void valueOf_MinAndMaxNumber_LottoNumberInstance(int number) {
        LottoNumber lottoNumber = LottoNumber.valueOf(number);
        assertThat(lottoNumber).isInstanceOf(LottoNumber.class);
    }

    @DisplayName("valueOf() 정적 생성자는 1 ~ 45를 벗어나면 예외가 발생한다")
    @ValueSource(ints = {0, 46})
    @ParameterizedTest
    void valueOf_InvalidNumber_ExceptionThrown(int number) {
        assertThatThrownBy(() -> LottoNumber.valueOf(number))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
