package lotto.domain.lotto;

import lotto.domain.WinningStatistics;
import lotto.domain.exception.InvalidMoneyException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("로또 일급컬렉션 테스트")
public class LottosTest {

    @DisplayName("로또 일급컬렉션 생성")
    @ParameterizedTest
    @CsvSource(value = {"10000:10", "14000:14", "100:0"}, delimiter = ':')
    public void makeLottosFromMoney(int money, int expectedLottoCount) {
        Lottos lottos = Lottos.withMoney(money);

        int lottoCount = lottos.getCount();

        assertThat(lottoCount).isEqualTo(expectedLottoCount);
    }

    @DisplayName("로또 구입시 0보다 작은 숫자 입력되면 에러")
    @Test
    public void invalidMoney() {
        assertThatThrownBy(() -> {
            Lottos.withMoney(-1);
        }).isInstanceOf(InvalidMoneyException.class)
                .hasMessageContaining("금액은 0보다 커야합니다.");
    }

    @DisplayName("로또 당첨통게")
    @ParameterizedTest
    @MethodSource("getLottos")
    public void getWinningStatistics(Lottos lottos, List<Integer> expectedLottoCount) {
        WinningStatistics statistics = lottos.getWinningStatistics(Arrays.asList(1, 2, 3, 4, 5, 6));

        for (int winningCount = 0; winningCount <= 6; winningCount++) {
            assertThat(statistics.getWinningLottoCount(winningCount)).isEqualTo(expectedLottoCount.get(winningCount));
        }
    }

    static Stream<Arguments> getLottos() {
        return Stream.of(
                arguments(
                        Lottos.of(Arrays.asList(
                                Lotto.ofNumbers(Arrays.asList(8, 21, 23, 41, 42, 43)),
                                Lotto.ofNumbers(Arrays.asList(3, 5, 11, 16, 32, 38)),
                                Lotto.ofNumbers(Arrays.asList(7, 11, 16, 35, 36, 44)),
                                Lotto.ofNumbers(Arrays.asList(1, 8, 11, 31, 41, 42)),
                                Lotto.ofNumbers(Arrays.asList(13, 14, 16, 38, 42, 45)),
                                Lotto.ofNumbers(Arrays.asList(7, 11, 30, 40, 42, 43)),
                                Lotto.ofNumbers(Arrays.asList(2, 13, 22, 32, 38, 45)),
                                Lotto.ofNumbers(Arrays.asList(23, 25, 33, 36, 39, 41)),
                                Lotto.ofNumbers(Arrays.asList(1, 3, 5, 14, 22, 45)),
                                Lotto.ofNumbers(Arrays.asList(5, 9, 38, 41, 43, 44)),
                                Lotto.ofNumbers(Arrays.asList(2, 8, 9, 18, 19, 21)),
                                Lotto.ofNumbers(Arrays.asList(13, 14, 18, 21, 23, 35)),
                                Lotto.ofNumbers(Arrays.asList(17, 21, 29, 37, 42, 45)),
                                Lotto.ofNumbers(Arrays.asList(3, 8, 27, 30, 35, 44))
                        )),
                        Arrays.asList(7, 5, 1, 1, 0, 0, 0)
                )
        );
    }

}