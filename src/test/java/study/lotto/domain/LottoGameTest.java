package study.lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {
    private LottoIssuer lottoIssuer;

    @BeforeEach
    void setUp() {
        lottoIssuer =
                () -> new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("입력한 금액만큼의 로또티켓을 생성한다.")
    @ParameterizedTest
    @CsvSource({"14000,14", "3900,3", "200,0"})
    void buy(int amount, int expect) {
        assertThat(
                new LottoGame(amount, lottoIssuer).getLottos().size())
                .isEqualTo(expect);
    }

    @DisplayName("당첨번호와 3개 이상 일치하면 당첨된것이다.")
    @Test
    void winning() {
        LottoWinningNumber lottoWinningNumber =
                new LottoWinningNumber(Arrays.asList(1, 2, 3, 4, 5, 6), 45);
        LottoGame lottoGame = new LottoGame(1000, lottoIssuer);
        LottoResult lottoResult = lottoGame.result(lottoWinningNumber);
        assertThat(lottoResult.getWinningLottos(LottoRank.FIRST).size())
                .isEqualTo(1);
    }

    @DisplayName("당첨번호와 3개 이상 일치하면 당첨된것이다.")
    @ParameterizedTest
    @MethodSource("provideWinning")
    void winning(LottoWinningNumber winningNumber, LottoRank lottoRanks,
                 int winnerCount) {
        LottoIssuer lottoIssuer =
                () -> new Lotto(Arrays.asList(1, 2, 3, 4, 5, 45));
        LottoGame lottoGame = new LottoGame(1000, lottoIssuer);
        LottoResult lottoResult = lottoGame.result(winningNumber);
        assertThat(lottoResult.getWinningLottos(lottoRanks).size())
                .isEqualTo(winnerCount);
    }

    private static Stream<Arguments> provideWinning() {
        return Stream.of(
                Arguments.of(new LottoWinningNumber(
                                Arrays.asList(1, 2, 3, 4, 5, 6), 45), LottoRank.SECOND,
                        1),
                Arguments.of(new LottoWinningNumber(
                                Arrays.asList(1, 2, 3, 4, 5, 6), 44), LottoRank.THIRD,
                        1),
                Arguments.of(new LottoWinningNumber(
                                Arrays.asList(2, 3, 4, 5, 6, 7), 45),
                        LottoRank.FOURTH,
                        1),
                Arguments.of(new LottoWinningNumber(
                                Arrays.asList(3, 4, 5, 6, 7, 8), 45),
                        LottoRank.FIFTH, 1)
        );
    }
}
