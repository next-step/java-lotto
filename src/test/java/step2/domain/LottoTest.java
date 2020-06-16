package step2.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoTest {

    private static Stream<Arguments> validLottoNumberTestCase() {
        return Stream.of(
            Arguments.of(Arrays.asList(1, 1, 3, 4, 5, 6)),
            Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 99)),
            Arguments.of(Arrays.asList(0, 2, 3, 4, 5, 6))
        );
    }

    @ParameterizedTest
    @MethodSource("validLottoNumberTestCase")
    void validLottoNumberTest(List<Integer> lottoNumber) {
        //when&then
        assertThatThrownBy(() -> new Lotto(lottoNumber)).isInstanceOf(IllegalArgumentException.class);
    }
}