package step02.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class WinningCountersTest {
    List<WinningCounter> numbersCount;

    @BeforeEach
    public void setup() {
        numbersCount = Arrays.asList(
                WinningCounter.of(0, 7),
                WinningCounter.of(1, 5),
                WinningCounter.of(2, 1),
                WinningCounter.of(3, 1)
        );
    }

    @DisplayName("winningCounterCollections 생성자 테스트")
    @Test
    public void test_winningCounterCollections_Constructor() {
        assertThat(WinningCounters.of(numbersCount))
                .isEqualTo(WinningCounters.of(numbersCount));
    }

    private static Stream<Arguments> provideLottoRewardContainResult() {
        return Stream.of(
                Arguments.of(3, 1),
                Arguments.of(4, 0),
                Arguments.of(5, 0),
                Arguments.of(6, 0)
        );
    }

    @DisplayName("lottoReward winning 수에 대응하는 count 를 리턴한다.")
    @ParameterizedTest
    @MethodSource("provideLottoRewardContainResult")
    public void test_getCount(int winningNumber, int expect) {
        WinningCounters winningCounters = WinningCounters.of(numbersCount);
        assertThat(winningCounters.getCount(winningNumber))
                .isEqualTo(expect);
    }

}
