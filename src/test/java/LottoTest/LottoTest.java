package LottoTest;

import lotto.domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class LottoTest {
    private final int MONEY = 10000;
    private final int NUMBER_OF_GAMES = MONEY / LottoRule.price();
    private final LottoNumberGenerator lottoNumberGenerator = new FixedLottoNumberGenerator();
    private Lotto lotto;

    @Test
    @DisplayName("로또 게임 구매 테스트")
    void When_Game_Then_LottoNumberList() {
        lotto = new Lotto(MONEY, lottoNumberGenerator);

        //when
        List<LottoGame> games = lotto.games();

        //then
        assertThat(games.size()).isEqualTo(NUMBER_OF_GAMES);
    }

    @Test
    @DisplayName("수동 로또 입력 받기 테스트")
    void Given_ManualLottoGame_When_New_Then_InstanceCreated() {
        List<LottoGame> manualLottoGame = null;

        assertDoesNotThrow(() -> {
            lotto = new Lotto(MONEY, manualLottoGame, lottoNumberGenerator);
        });
    }

    @Test
    @DisplayName("수동 로또가 있을 때 lotto.games()가 알맞은 값을 리턴하는지 테스트")
    void Given_ManualLottoGame_When_Game_Then_NumberOfGame() {
        List<LottoGame> manualLottoGame = Arrays.asList(new LottoGame("1, 2, 3, 4, 5, 6"));

        lotto = new Lotto(MONEY, manualLottoGame, lottoNumberGenerator);

        //when
        List<LottoGame> games = lotto.games();

        //then
        assertThat(games.size()).isEqualTo(NUMBER_OF_GAMES);
    }

    @Test
    @DisplayName("로또 금액보다 수동 로또가 더 많으면 Exception")
    void Given_TooManyLottoGame_When_New_Then_Exception() {
        List<LottoGame> manualLottoGame = Arrays.asList(
                new LottoGame("1, 2, 3, 4, 5, 6"),
                new LottoGame("1, 2, 3, 4, 5, 6")
        );


        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> lotto = new Lotto(1000, manualLottoGame, lottoNumberGenerator));
    }

    @Test
    @DisplayName("구매금액이 1장 가격보다 작을 때 Exception 발생 테스트")
    void Given_LowPrice_When_New_Then_Exception() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Lotto(LottoRule.price() - 1, lottoNumberGenerator));
    }

    @ParameterizedTest
    @DisplayName("우승자 계산 테스트")
    @MethodSource("provideResultTestInput")
    void When_Result(List<Integer> givenWinningNumber, int bonusNumber, Rank expectedRank) {
        //given
        WinningNumber winningNumber = new WinningNumber(new LottoGame(givenWinningNumber), bonusNumber);
        lotto = new Lotto(MONEY, lottoNumberGenerator);

        //when
        Winners winners = lotto.winners(winningNumber);

        //then
        assertThat(winners.wins(expectedRank)).isEqualTo(NUMBER_OF_GAMES);
    }

    private static Stream<Arguments> provideResultTestInput() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), 7, Rank.FIRST),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 8), 6, Rank.SECOND),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 8), 9, Rank.THIRD),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 11, 8), 9, Rank.FORTH),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 11, 8), 6, Rank.FORTH),
                Arguments.of(Arrays.asList(1, 2, 3, 12, 11, 8), 9, Rank.FIFTH),
                Arguments.of(Arrays.asList(1, 2, 3, 12, 11, 8), 6, Rank.FIFTH)
        );
    }
}
