package lotto.domain.lotto;

import static lotto.common.Rank.FIFTH;
import static lotto.common.Rank.FIRST;
import static lotto.common.Rank.FOURTH;
import static lotto.common.Rank.THIRD;
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
                new WinningLotto(LottoNumbers.create(Arrays.asList(1, 2, 3, 4, 5, 6)), 10),
                new NormalLotto(LottoNumbers.create(Arrays.asList(1, 2, 3, 10, 11, 12))),
                new HashMap<Rank, Integer>() {{
                    Arrays.stream(Rank.values()).forEach(r -> put(r, 0));
                    put(FIFTH, 1);
                }}
            ),
            Arguments.of(
                new WinningLotto(LottoNumbers.create(Arrays.asList(1, 2, 3, 4, 5, 6)), 10),
                new NormalLotto(LottoNumbers.create(Arrays.asList(1, 2, 3, 4, 11, 12))),
                new HashMap<Rank, Integer>() {{
                    Arrays.stream(Rank.values()).forEach(r -> put(r, 0));
                    put(FOURTH, 1);
                }}
            ),
            Arguments.of(
                new WinningLotto(LottoNumbers.create(Arrays.asList(1, 2, 3, 4, 5, 6)), 10),
                new NormalLotto(LottoNumbers.create(Arrays.asList(1, 2, 3, 4, 5, 12))),
                new HashMap<Rank, Integer>() {{
                    Arrays.stream(Rank.values()).forEach(r -> put(r, 0));
                    put(THIRD, 1);
                }}
            ),
            Arguments.of(
                new WinningLotto(LottoNumbers.create(Arrays.asList(1, 2, 3, 4, 5, 6)), 10),
                new NormalLotto(LottoNumbers.create(Arrays.asList(1, 2, 3, 4, 5, 6))),
                new HashMap<Rank, Integer>() {{
                    Arrays.stream(Rank.values()).forEach(r -> put(r, 0));
                    put(FIRST, 1);
                }}
            ));
    }

    @DisplayName("[성공] 당첨 로또 적중 수")
    @ParameterizedTest
    @MethodSource("matchLottoCounts")
    public void getMatchLottoCounts(WinningLotto winningLotto, NormalLotto normalLotto, Map<Rank, Integer> expected) {
        // given
        LottoResult lottoResult = new LottoResult(Collections.singletonList(normalLotto), winningLotto);

        // when
        Map<Rank, Integer> winningLottoCounts = lottoResult.getWinningLottoCounts();

        // then
        assertThat(winningLottoCounts).isEqualTo(expected);
    }

    public static Stream<Arguments> earningRateLotto() {
        return Stream.of(
            Arguments.of(
                new WinningLotto(LottoNumbers.create(Arrays.asList(1, 2, 3, 4, 5, 6)), 10),
                new NormalLotto(LottoNumbers.create(Arrays.asList(1, 2, 3, 10, 11, 12))),
                Rank.FIFTH.getWinningMoney() / (double) LottoFactory.calculateTotalAmount(1)
            ),
            Arguments.of(
                new WinningLotto(LottoNumbers.create(Arrays.asList(1, 2, 3, 4, 5, 6)), 10),
                new NormalLotto(LottoNumbers.create(Arrays.asList(1, 2, 3, 4, 11, 12))),
                Rank.FOURTH.getWinningMoney() / (double) LottoFactory.calculateTotalAmount(1)
            ),
            Arguments.of(
                new WinningLotto(LottoNumbers.create(Arrays.asList(1, 2, 3, 4, 5, 6)), 10),
                new NormalLotto(LottoNumbers.create(Arrays.asList(1, 2, 3, 4, 5, 12))),
                Rank.THIRD.getWinningMoney() / (double) LottoFactory.calculateTotalAmount(1)
            ),
            Arguments.of(
                new WinningLotto(LottoNumbers.create(Arrays.asList(1, 2, 3, 4, 5, 6)), 10),
                new NormalLotto(LottoNumbers.create(Arrays.asList(1, 2, 3, 4, 5, 10))),
                Rank.SECOND.getWinningMoney() / (double) LottoFactory.calculateTotalAmount(1)
            ),
            Arguments.of(
                new WinningLotto(LottoNumbers.create(Arrays.asList(1, 2, 3, 4, 5, 6)), 10),
                new NormalLotto(LottoNumbers.create(Arrays.asList(1, 2, 3, 4, 5, 6))),
                Rank.FIRST.getWinningMoney() / (double) LottoFactory.calculateTotalAmount(1)
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
