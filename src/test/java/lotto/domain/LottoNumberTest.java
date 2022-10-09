package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoNumberTest {
    @DisplayName("일치하는 번호 갯수를 리턴한다.")
    @ParameterizedTest
    @MethodSource("matchCountSet")
    void matchCount(LottoNumber lottoNumber, LottoNumber other, int expected) {
        assertThat(lottoNumber.matchCount(other)).isEqualTo(expected);
    }

    private static Stream<Arguments> matchCountSet() {
        return Stream.of(
            Arguments.arguments(new LottoNumber(List.of(1, 2, 3, 4, 5, 6)), new LottoNumber(List.of(1, 2, 3, 4, 5, 6)), 6),
            Arguments.arguments(new LottoNumber(List.of(1, 2, 3, 4, 5, 6)), new LottoNumber(List.of(7, 8, 9, 10, 11, 12)), 0),
            Arguments.arguments(new LottoNumber(List.of(1, 2, 3, 4, 5, 6)), new LottoNumber(Collections.emptyList()), 0),
            Arguments.arguments(new LottoNumber(List.of(1, 2, 3, 4, 5, 6)), new LottoNumber(List.of(1, 2, 6, 7, 8, 9)), 3)
        );
    }
}
