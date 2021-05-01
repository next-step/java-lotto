package lotto.domain;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LottoResultTest {

    static Stream<Arguments> resultSource() {
        return Stream.of(arguments(
                new Lottos(
                        Lists.list(
                                new Lotto(LottoBalls.of(40, 41, 42, 43, 44, 45)), //Prize.ZERO
                                new Lotto(LottoBalls.of(40, 41, 42, 43, 44, 45)), //Prize.ZERO
                                new Lotto(LottoBalls.of(1, 2, 3, 4, 5, 6)), //Prize.THREE
                                new Lotto(LottoBalls.of(1, 2, 3, 13, 5, 6)), //Prize.FOUR
                                new Lotto(LottoBalls.of(1, 2, 13, 14, 15, 6)), //Prize.BONUS
                                new Lotto(LottoBalls.of(1, 2, 3, 13, 14, 26)), //Prize.FIVE
                                new Lotto(LottoBalls.of(1, 2, 3, 13, 14, 15)) //Prize.SIX
                        )
                ),
                new WinningLotto(LottoBalls.of(1, 2, 3, 13, 14, 15), LottoBall.valueOf(6)))
        );
    }

    @ParameterizedTest
    @DisplayName("로또 결과 생성 테스트")
    @MethodSource("resultSource")
    void create(Lottos lottos, WinningLotto winningLotto) {
        LottoResult lottoResult = LottoResult.of(lottos, winningLotto);

        assertThat(lottoResult).isNotNull();
    }

    @ParameterizedTest
    @DisplayName("로또 결과 개수 확인 테스트")
    @MethodSource("resultSource")
    void count(Lottos lottos, WinningLotto winningLotto) {

        LottoResult lottoResult = LottoResult.of(lottos, winningLotto);

        assertAll(
                () -> assertThat(lottoResult.counts(Prize.ZERO)).isEqualTo(2L),
                () -> assertThat(lottoResult.counts(Prize.THREE)).isEqualTo(1L),
                () -> assertThat(lottoResult.counts(Prize.FOUR)).isEqualTo(1L),
                () -> assertThat(lottoResult.counts(Prize.FIVE)).isEqualTo(1L),
                () -> assertThat(lottoResult.counts(Prize.BONUS)).isEqualTo(1L),
                () -> assertThat(lottoResult.counts(Prize.SIX)).isEqualTo(1L)
        );
    }

    @ParameterizedTest
    @DisplayName("로또 결과 수익 확인 테스트")
    @MethodSource("resultSource")
    void rate(Lottos lottos, WinningLotto winningLotto) {

        LottoResult lottoResult = LottoResult.of(lottos, winningLotto);

        assertThat(lottoResult.earningRate(BigDecimal.valueOf(7000))).isEqualTo(BigDecimal.valueOf(290222.14));
    }
}
