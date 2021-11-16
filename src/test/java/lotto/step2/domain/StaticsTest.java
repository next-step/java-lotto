package lotto.step2.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class StaticsTest {

    private Lotteries lotteries;

    @BeforeEach
    @DisplayName("지정 로또번호")
    void init() {
        List<Integer> lottoNumbers1 = Arrays.asList(1, 2, 3, 4, 11, 12);
        List<Integer> lottoNumbers2 = Arrays.asList(1, 2, 3, 4, 14, 15);
        List<Integer> lottoNumbers3 = Arrays.asList(1, 2, 3, 4, 14, 17);
        lotteries = new Lotteries(Arrays.asList(new Lotto(lottoNumbers1),
                new Lotto(lottoNumbers2), new Lotto(lottoNumbers3)));
    }

    @Test
    @DisplayName("당첨 번호 입력받아 자르기")
    void winningNumber() {
        Statics statics = new Statics("1, 2, 3, 4, 5, 6");
        assertThat(statics.getWinningNumbers().getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @ParameterizedTest
    @MethodSource("provideWinnerNumberCount2")
    @DisplayName("당첨번호와 비교했을떄, 로또번호 중 n개(expected) 일치하는 로또 수(result)")
    void totalCountOfMatch(String provided, int expected, int result) {
        Statics statics = new Statics(provided, lotteries);
        assertThat(statics.totalCountOfMatch(expected)).isEqualTo(result);
    }

    private static Stream<Arguments> provideWinnerNumberCount2() {
        return Stream.of(
                Arguments.of("1, 2, 44, 35, 37, 26", 2, 3),
                Arguments.of("1, 2, 3, 39, 37, 26", 3, 3),
                Arguments.of("1, 2, 3, 4, 37, 26", 4, 3),
                Arguments.of("1, 2, 3, 4, 11, 26", 5, 1),
                Arguments.of("1, 2, 3, 4, 11, 12", 6, 1)
        );
    }

}