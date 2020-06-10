package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumbersTest {

    @DisplayName("같은 번호를 가진 LottoNumbers 객체들은 같다")
    @ParameterizedTest
    @MethodSource("source_equals_sameNumbers_shouldTrue")
    public void equals_sameNumbers_shouldTrue(Set<Integer> a, Set<Integer> b) {
        LottoNumbers lottoNumbers1 = new LottoNumbers(a);
        LottoNumbers lottoNumbers2 = new LottoNumbers(a);
        assertThat(lottoNumbers1.equals(lottoNumbers2)).isTrue();
    }

    public static Stream<Arguments> source_equals_sameNumbers_shouldTrue() {
        return Stream.of(
                Arguments.of(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)), new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6))),
                Arguments.of(new HashSet<>(Arrays.asList(23, 25, 27, 29, 31, 33)), new HashSet<>(Arrays.asList(23, 25, 27, 29, 31, 33))));
    }
}
