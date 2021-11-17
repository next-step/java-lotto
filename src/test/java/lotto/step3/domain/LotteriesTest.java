package lotto.step3.domain;

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

class LotteriesTest {

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
    @DisplayName("주어진 orderCount 수만큼 로또가 생성되어 컬렉션에 담긴다")
    void createLotteries() {
        Lotteries lotteries = new Lotteries(10);
        assertThat(lotteries.getLotteries()).size().isEqualTo(10);
    }

    @ParameterizedTest
    @MethodSource("provideWinnerNumberCount2")
    @DisplayName("당첨번호와 비교했을떄, 로또번호 중 n개(expected) 일치하는 로또 수(result)")
    void totalCountOfMatch(Lotto provided, int expected, int result) {
        assertThat(lotteries.totalCountOfMatch(provided,expected)).isEqualTo(result);
    }

    private static Stream<Arguments> provideWinnerNumberCount2() {
        return Stream.of(
                Arguments.of(new Lotto(Arrays.asList(1, 2, 44, 35, 37, 26)), 2, 3),
                Arguments.of(new Lotto(Arrays.asList(1, 2, 3, 39, 37, 26)), 3, 3),
                Arguments.of(new Lotto(Arrays.asList(1, 2, 3, 4, 37, 26)), 4, 3),
                Arguments.of(new Lotto(Arrays.asList(1, 2, 3, 4, 11, 26)), 5, 1),
                Arguments.of(new Lotto(Arrays.asList(1, 2, 3, 4, 11, 12)), 6, 1)
        );
    }

}