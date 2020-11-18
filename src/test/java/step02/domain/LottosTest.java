package step02.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LottosTest {
    @DisplayName("생성자 테스트")
    @Test
    public void test_Lottos_Constructor() {
        List<Lotto> lottos = new ArrayList<>(
                Arrays.asList(
                        Lotto.of(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6))),
                        Lotto.of(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6))),
                        Lotto.of(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)))
                )
        );
        assertThat(Lottos.of(lottos)).isEqualTo(Lottos.of(lottos));
    }

    private static Stream<Arguments> provideLottosStatisticResult() {
        return Stream.of(
                Arguments.of(
                        Lottos.of(
                                Arrays.asList(
                                        Lotto.of(Arrays.asList(8, 21, 23, 41, 42, 43)),
                                        Lotto.of(Arrays.asList(3, 5, 11, 16, 32, 38)),
                                        Lotto.of(Arrays.asList(7, 11, 16, 35, 36, 44)),
                                        Lotto.of(Arrays.asList(1, 8, 11, 31, 41, 42)),
                                        Lotto.of(Arrays.asList(13, 14, 16, 38, 42, 45)),
                                        Lotto.of(Arrays.asList(7, 11, 30, 40, 42, 43)),
                                        Lotto.of(Arrays.asList(2, 13, 22, 32, 38, 45)),
                                        Lotto.of(Arrays.asList(23, 25, 33, 36, 39, 41)),
                                        Lotto.of(Arrays.asList(1, 3, 5, 14, 22, 45)),
                                        Lotto.of(Arrays.asList(5, 9, 38, 41, 43, 44)),
                                        Lotto.of(Arrays.asList(2, 8, 9, 18, 19, 21)),
                                        Lotto.of(Arrays.asList(13, 14, 18, 21, 23, 35)),
                                        Lotto.of(Arrays.asList(17, 21, 29, 37, 42, 45)),
                                        Lotto.of(Arrays.asList(3, 8, 27, 30, 35, 44))
                                )
                        ), new ArrayList<>(
                                Arrays.asList(
                                    NumberCount.of(0, 7),
                                    NumberCount.of(1, 5),
                                    NumberCount.of(2, 1),
                                    NumberCount.of(3, 1)
                                )
                        )
                )
        );
    }

    @DisplayName("Lottos 의 통계결과를 리턴")
    @ParameterizedTest
    @MethodSource("provideLottosStatisticResult")
    public void test_statisticWinning(Lottos lottos, List<NumberCount> numbersCount) {
        Lotto winningNumbers = Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lottos.statisticWinning(winningNumbers))
                .isEqualTo(NumberCountCollections.of(numbersCount));
    }


}
