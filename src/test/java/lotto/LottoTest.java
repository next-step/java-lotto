package lotto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    void generate() {
        Lotto lotto = new Lotto();
        List<Integer> lottoNumbers = lotto.getLottoNumbers();

        assertThat(lottoNumbers).hasSize(6);
        assertThat(lottoNumbers.stream().min(Integer::compareTo).get()).isGreaterThanOrEqualTo(1);
        assertThat(lottoNumbers.stream().max(Integer::compareTo).get()).isLessThanOrEqualTo(45);
        assertThat(lottoNumbers).doesNotHaveDuplicates();
    }

    @ParameterizedTest(name = "countEqualNumbers() - {2}")
    @MethodSource("lottoNumbersProvider")
    void countEqualNumbers(List<Integer> lottoNumbers, int expected, String testMessage) {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThat(lotto.countEqualNumbers(lottoNumbers)).isEqualTo(expected);
    }

    static Stream<Arguments> lottoNumbersProvider() {
        return Stream.of(
                Arguments.of(Arrays.asList(10, 11, 12, 13, 14, 15), 0, "0개 일치"),
                Arguments.of(Arrays.asList(1, 11, 12, 13, 14, 15), 1, "1개 일치"),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), 6, "6개 일치")
        );
    }

}
