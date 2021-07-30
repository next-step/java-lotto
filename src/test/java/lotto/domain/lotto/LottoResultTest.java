package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import lotto.common.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("로또 결과")
class LottoResultTest {

    public static Stream<Arguments> matchLottoCounts() {
        return Stream.of(
            Arguments.of(
                new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new NormalLotto(Arrays.asList(1, 2, 3, 10, 11, 12)),
                new HashMap<Integer, Integer>() {{
                    put(3, 1);
                    put(4, 0);
                    put(5, 0);
                    put(6, 0);
                }}
            ),
            Arguments.of(
                new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new NormalLotto(Arrays.asList(1, 2, 3, 4, 11, 12)),
                new HashMap<Integer, Integer>() {{
                    put(3, 0);
                    put(4, 1);
                    put(5, 0);
                    put(6, 0);
                }}
            ),
            Arguments.of(
                new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new NormalLotto(Arrays.asList(1, 2, 3, 4, 5, 12)),
                new HashMap<Integer, Integer>() {{
                    put(3, 0);
                    put(4, 0);
                    put(5, 1);
                    put(6, 0);
                }}
            ),
            Arguments.of(
                new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new NormalLotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new HashMap<Integer, Integer>() {{
                    put(3, 0);
                    put(4, 0);
                    put(5, 0);
                    put(6, 1);
                }}
            ));
    }

    @DisplayName("[성공] 당첨 로또 적중 수")
    @ParameterizedTest
    @MethodSource("matchLottoCounts")
    public void getMatchLottoCounts(WinningLotto winningLotto, NormalLotto normalLotto, Map<Integer, Integer> expected) {
        // given
        LottoResult lottoResult = new LottoResult(Collections.singletonList(normalLotto), winningLotto);

        // when
        Map<Integer, Integer> matchLottoCounts = lottoResult.getMatchLottoCounts();

        // then
        assertThat(matchLottoCounts).isEqualTo(expected);
    }

    public static Stream<Arguments> earningRateLotto() {
        return Stream.of(
            Arguments.of(
                new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new NormalLotto(Arrays.asList(1, 2, 3, 10, 11, 12)),
                Rank.valueOf(3).getWinningMoney() / (double) LottoFactory.calculateTotalAmount(1)
            ),
            Arguments.of(
                new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new NormalLotto(Arrays.asList(1, 2, 3, 4, 11, 12)),
                Rank.valueOf(4).getWinningMoney() / (double) LottoFactory.calculateTotalAmount(1)
            ),
            Arguments.of(
                new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new NormalLotto(Arrays.asList(1, 2, 3, 4, 5, 12)),
                Rank.valueOf(5).getWinningMoney() / (double) LottoFactory.calculateTotalAmount(1)
            ),
            Arguments.of(
                new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new NormalLotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                Rank.valueOf(6).getWinningMoney() / (double) LottoFactory.calculateTotalAmount(1)
            ));
    }

    @DisplayName("[성공] 수익율")
    @ParameterizedTest
    @MethodSource("earningRateLotto")
    public void calculateEarningRate(WinningLotto winningLotto, NormalLotto normalLotto, double expected) {
        // given
        LottoResult lottoResult = new LottoResult(Collections.singletonList(normalLotto), winningLotto);

        // when
        double earningRate = lottoResult.getEarningRate();

        // then
        assertThat(earningRate).isEqualTo(expected);
    }
}
