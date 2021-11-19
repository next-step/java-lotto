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
    @DisplayName("랜덤값이 아닌 로또번호를 지정해서 테스트")
    void init() {
        List<Integer> lottoNumbers1 = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> lottoNumbers2 = Arrays.asList(7, 8, 9, 10, 11, 12);
        List<Integer> lottoNumbers3 = Arrays.asList(7, 8, 9, 10, 11, 14);
        List<Integer> lottoNumbers4 = Arrays.asList(13, 14, 15, 16, 17, 18);
        lotteries = new Lotteries(Arrays.asList(new Lotto(lottoNumbers1),
                new Lotto(lottoNumbers2), new Lotto(lottoNumbers3), new Lotto(lottoNumbers4)));
    }

    @Test
    @DisplayName("주어진 orderCount 수만큼 로또가 생성되어 컬렉션에 담긴다")
    void createLotteries() {
        Lotteries lotteries = new Lotteries(14);
        assertThat(lotteries.getLotteries()).size().isEqualTo(14);
    }

    @ParameterizedTest
    @MethodSource("provideWinnerNumberCount1")
    @DisplayName("당첨번호와 비교했을떄, 로또번호 중 n개(expected) 일치하는 로또 수(result)")
    void totalCountOfMatch(Lotto provided, int expected, int result) {
        assertThat(lotteries.totalCountOfMatch(provided, expected)).isEqualTo(result);
    }

    private static Stream<Arguments> provideWinnerNumberCount1() {
        return Stream.of(
                Arguments.of(new Lotto(Arrays.asList(1, 2, 3, 43, 44, 45)), 3, 1),
                Arguments.of(new Lotto(Arrays.asList(1, 2, 3, 4, 44, 45)), 4, 1),
                Arguments.of(new Lotto(Arrays.asList(7, 8, 9, 10, 11, 45)), 5, 2),
                Arguments.of(new Lotto(Arrays.asList(7, 8, 9, 10, 11, 15)), 5, 2),
                Arguments.of(new Lotto(Arrays.asList(13, 14, 15, 16, 17, 18)), 6, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("provideWinnerNumberCount2")
    @DisplayName("총 로또 중에서 2등이 몇명나왔냐?(5개가 매칭되고 보너스볼이 맞아야한다.")
    void totalSecondPrizeWinner(Lotto provided, int expected, int result) {
        assertThat(lotteries.totalSecondPrizeWinners(provided, expected)).isEqualTo(result);
    }

    private static Stream<Arguments> provideWinnerNumberCount2() {
        return Stream.of(
                Arguments.of(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 45)), 1, 1),
                Arguments.of(new Lotto(Arrays.asList(7, 8, 9, 10, 11, 13)), 11, 2),
                Arguments.of(new Lotto(Arrays.asList(7, 8, 9, 10, 11, 45)), 45, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("provideWinnerNumberCount3")
    @DisplayName("총 로또 중에서 2등이 한명이라도 나왔냐?")
    void isSecondPrizeWinner(Lotto provided, int expected, boolean result) {
        assertThat(lotteries.isSecondPrizeWinners(provided, expected)).isEqualTo(result);
    }

    private static Stream<Arguments> provideWinnerNumberCount3() {
        return Stream.of(
                Arguments.of(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 45)), 1, true),
                Arguments.of(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 45)), 45, false),
                Arguments.of(new Lotto(Arrays.asList(7, 8, 9, 10, 11, 13)), 11, true),
                Arguments.of(new Lotto(Arrays.asList(7, 8, 9, 10, 11, 45)), 45, false)
        );
    }

    @ParameterizedTest
    @MethodSource("provideWinnerNumberCount4")
    @DisplayName("총 로또중에서, 우승 수익을 합한 메서드")
    void totalPrizeMoney(Lotto provided, int bonusBall, int result) {
        assertThat(lotteries.totalPrizeMoney(provided, bonusBall)).isEqualTo(result);
    }

    private static Stream<Arguments> provideWinnerNumberCount4() {
        return Stream.of(
                Arguments.of(new Lotto(Arrays.asList(1, 2, 3, 43, 44, 45)), 0, 5000),
                Arguments.of(new Lotto(Arrays.asList(1, 2, 3, 4, 44, 45)), 0, 50000),
                Arguments.of(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 13)), 11, 1500000),
                Arguments.of(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 13)), 5, 30000000),
                Arguments.of(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), 6, 2000000000),
                Arguments.of(new Lotto(Arrays.asList(7, 8, 9, 43, 44, 45)), 6, 10000),
                Arguments.of(new Lotto(Arrays.asList(7, 8, 9, 10, 12, 14)), 12, 31500000)
        );
    }

}