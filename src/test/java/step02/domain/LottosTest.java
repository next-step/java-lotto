package step02.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step02.Mock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LottosTest {
    List<Lotto> lottos;

    @BeforeEach
    public void setup() {
        lottos = Mock.makeLottos();
    }

    @DisplayName("생성자 테스트")
    @Test
    public void test_Lottos_Constructor() {
        assertThat(Lottos.of(lottos)).isEqualTo(Lottos.of(lottos));
    }

    private static Stream<Arguments> provideLottosStatisticResult() {
        return Stream.of(
                Arguments.of(
                        Lottos.of(Mock.makeLottos()),
                        new ArrayList<>(
                                Arrays.asList(
                                        WinningCounter.of(0, 7),
                                        WinningCounter.of(1, 5),
                                        WinningCounter.of(2, 1),
                                        WinningCounter.of(3, 1)
                                )
                        )
                )
        );
    }

    @DisplayName("Lottos 의 통계결과를 리턴")
    @ParameterizedTest
    @MethodSource("provideLottosStatisticResult")
    public void test_statisticWinning(Lottos lottos, List<WinningCounter> numbersCount) {
        Lotto winningNumbers = Lotto.of(Mock.makeLotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        assertThat(lottos.statisticWinning(winningNumbers))
                .isEqualTo(WinningCounterCollections.of(numbersCount));
    }

    @DisplayName("로또의 개수를 리턴")
    @Test
    public void test_getCount() {
        assertThat(Lottos.of(lottos).getCount()).isEqualTo(14);
    }

}
