package lotto.domain;

import lotto.exception.LottoNumbersCountException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @ParameterizedTest
    @DisplayName("6개의 번호가 아니라면 LottoNumbersCountException")
    @MethodSource
    void createLottoExceptionTest(List<LottoNumber> numbers) {
        assertThatThrownBy(() -> Lotto.from(numbers)).isInstanceOf(LottoNumbersCountException.class);
    }

    static Stream<Arguments> createLottoExceptionTest() {
        return Stream.of(
                Arguments.of(
                        Collections.emptyList()
                ),
                Arguments.of(
                        Collections.singletonList(
                                LottoNumber.from(1)
                        )
                ),
                Arguments.of(
                        Arrays.asList(
                                LottoNumber.from(1),
                                LottoNumber.from(2),
                                LottoNumber.from(3),
                                LottoNumber.from(4),
                                LottoNumber.from(5),
                                LottoNumber.from(6),
                                LottoNumber.from(7)
                        )
                )
        );
    }
}