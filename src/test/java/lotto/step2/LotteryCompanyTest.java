package lotto.step2;

import lotto.step2.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LotteryCompanyTest {

    private Lotteries lotteries;

    @BeforeEach
    void init() {
        List<Integer> lottoNumbers1 = Arrays.asList(1, 2, 3, 4, 11, 12);
        List<Integer> lottoNumbers2 = Arrays.asList(1, 2, 3, 4, 14, 15);
        List<Integer> lottoNumbers3 = Arrays.asList(1, 2, 3, 4, 14, 17);
        Lotto lotto1 = new Lotto(new Numbers(lottoNumbers1));
        Lotto lotto2 = new Lotto(new Numbers(lottoNumbers2));
        Lotto lotto3 = new Lotto(new Numbers(lottoNumbers3));
        lotteries = new Lotteries(lotto1, lotto2, lotto3);
    }

    @Test
    @DisplayName("당첨 번호 입력받아 자르기")
    void winningNumber() {
        LotteryCompany company = new LotteryCompany("1, 2, 3, 4, 5, 6");
        assertThat(company.getWinningNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @ParameterizedTest
    @MethodSource("provideWinnerNumberCount")
    @DisplayName("당첨번호와 비교했을떄, 로또번호 중 n개(expected) 일치하는 로또 수(total)")
    void getTotalCountOfMatch(String provided, int expected, int total) {
        LotteryCompany company = new LotteryCompany(provided, lotteries);
        assertThat(company.getTotalCountOfMatch(expected)).isEqualTo(total);
    }

    private static Stream<Arguments> provideWinnerNumberCount() {
        return Stream.of(
                Arguments.of("1, 2, 44, 35, 37, 26", 2, 3),
                Arguments.of("1, 2, 3, 39, 37, 26", 3, 3),
                Arguments.of("1, 2, 3, 4, 37, 26", 4, 3),
                Arguments.of("1, 2, 3, 4, 11, 26", 5, 1),
                Arguments.of("1, 2, 3, 4, 11, 12", 6, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("provideWinnerNumberRate")
    @DisplayName("당첨번호와 비교 했을때, 주어진 금액에 대한 총 수익률 계산")
    void rate(String provided, double rate) {
        LotteryCompany company = new LotteryCompany(provided, lotteries);
        assertThat(company.getRateOfReturn(14000)).isEqualTo(rate);
    }

    private static Stream<Arguments> provideWinnerNumberRate() {
        return Stream.of(
                Arguments.of("1, 44, 45, 46, 11, 12", 0.35),
                Arguments.of("1, 2, 3, 39, 37, 26", 1.07),
                Arguments.of("1, 2, 3, 4, 37, 26", 10.71),
                Arguments.of("1, 2, 3, 4, 11, 26", 1071.42),
                Arguments.of("1, 2, 3, 4, 11, 12", 142857.14)
        );
    }

}