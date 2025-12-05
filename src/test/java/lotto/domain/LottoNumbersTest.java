package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
public class LottoNumbersTest {
    @Test
    public void 생성() {
        assertThat(new LottoNumbers(List.of(1, 2, 3, 4, 5, 6))).isEqualTo(new LottoNumbers(List.of(1, 2, 3, 4, 5, 6)));
    }

    @ParameterizedTest
    @MethodSource("provideLottoNumbers")
    public void 일치하는_숫자의_개수(List<Integer> numbers, int expected) {
        LottoNumbers lottoNumbers = new LottoNumbers(numbers);
        LottoNumbers otherLottoNumbers = new LottoNumbers(List.of(1, 2, 3, 4, 5, 6));

        assertThat(lottoNumbers.matches(otherLottoNumbers)).isEqualTo(expected);
    }


    static Stream<Arguments> provideLottoNumbers() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 6),
                Arguments.of(List.of(1, 2, 3, 4, 5, 7), 5),
                Arguments.of(List.of(1, 2, 3, 4, 8, 9), 4),
                Arguments.of(List.of(1, 2, 3, 10, 11, 12), 3)
        );
    }
}
