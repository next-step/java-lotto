package lotto.domain.lotto;

import static lotto.common.Properties.LOTTO_PRICE;
import static lotto.common.Properties.LOTTO_PRIZE_MONEYS;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
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
                new HashMap<Long, Integer>() {{
                    put(3L, 1);
                    put(4L, 0);
                    put(5L, 0);
                    put(6L, 0);
                }}
            ),
            Arguments.of(
                new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new NormalLotto(Arrays.asList(1, 2, 3, 4, 11, 12)),
                new HashMap<Long, Integer>() {{
                    put(3L, 0);
                    put(4L, 1);
                    put(5L, 0);
                    put(6L, 0);
                }}
            ),
            Arguments.of(
                new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new NormalLotto(Arrays.asList(1, 2, 3, 4, 5, 12)),
                new HashMap<Long, Integer>() {{
                    put(3L, 0);
                    put(4L, 0);
                    put(5L, 1);
                    put(6L, 0);
                }}
            ),
            Arguments.of(
                new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new NormalLotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new HashMap<Long, Integer>() {{
                    put(3L, 0);
                    put(4L, 0);
                    put(5L, 0);
                    put(6L, 1);
                }}
            ));
    }

    @DisplayName("[성공] 당첨 로또 적중 수")
    @ParameterizedTest
    @MethodSource("matchLottoCounts")
    public void getMatchLottoCounts(WinningLotto winningLotto, NormalLotto normalLotto, Map<Long, Integer> expected) {
        // given
        LottoResult lottoResult = new LottoResult(Collections.singletonList(normalLotto), winningLotto);

        // when
        Map<Long, Integer> matchLottoCounts = lottoResult.getMatchLottoCounts();

        // then
        assertThat(matchLottoCounts).isEqualTo(expected);
    }

    public static Stream<Arguments> earningRateLotto() {
        return Stream.of(
            Arguments.of(
                new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new NormalLotto(Arrays.asList(1, 2, 3, 10, 11, 12)),
                LOTTO_PRIZE_MONEYS.get(3L) / (double) (LOTTO_PRICE * 1)
            ),
            Arguments.of(
                new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new NormalLotto(Arrays.asList(1, 2, 3, 4, 11, 12)),
                LOTTO_PRIZE_MONEYS.get(4L) / (double) (LOTTO_PRICE * 1)
            ),
            Arguments.of(
                new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new NormalLotto(Arrays.asList(1, 2, 3, 4, 5, 12)),
                LOTTO_PRIZE_MONEYS.get(5L) / (double) (LOTTO_PRICE * 1)
            ),
            Arguments.of(
                new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new NormalLotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                LOTTO_PRIZE_MONEYS.get(6L) / (double) (LOTTO_PRICE * 1)
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
