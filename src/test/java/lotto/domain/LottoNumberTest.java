package lotto.domain;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoNumberTest {

    @DisplayName("로또에 사용되는 번호는 1부터 45 사이의 숫자여야 한다.")
    @ValueSource(ints = {-1, -5, -100, 0, 46, 100, 1000})
    @ParameterizedTest
    void lottoNumberRangeTest(int number) {
        assertThatIllegalArgumentException().isThrownBy(() -> LottoNumber.of(number));
    }

    @DisplayName("로또 번호 생성 성공")
    @MethodSource("successCase")
    @ParameterizedTest
    void success(int number) {
        assertDoesNotThrow(() -> {
            LottoNumber lottoNumber = LottoNumber.of(number);
            assertEquals(number, lottoNumber.value());
        });
    }

    @SuppressWarnings("unused")
    private static Stream<Arguments> successCase() {
        return Stream.iterate(1, i -> i + 1)
                     .limit(45)
                     .map(Arguments::of);
    }
}
