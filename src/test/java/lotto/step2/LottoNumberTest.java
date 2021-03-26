package lotto.step2;

import lotto.step2.domain.LottoNumber;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {

    @ParameterizedTest(name = "illegalArgumentExceptionTest")
    @ValueSource(strings = {"0","46"})
    public void illegalArgumentExceptionTest(String input) {
        assertThatThrownBy(() -> new LottoNumber(input) )
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "creationTest")
    @MethodSource("arrayProvider")
    public void creationTest(String input, LottoNumber lottoNumber) {
        assertThat(new LottoNumber(input)).isEqualTo(lottoNumber);
    }

    static Stream<Arguments> arrayProvider() {
        return Stream.of(
                Arguments.of("1",(Object) new LottoNumber(1)),
                Arguments.of("45",(Object) new LottoNumber(45)),
                Arguments.of("23",(Object) new LottoNumber(23))
        );
    }
}
