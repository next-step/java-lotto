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
    private final Money money = new Money(10000);
    private final int NUMBER_OF_GAMES = money.numberOfGames();
    private final LottoNumberGenerator lottoNumberGenerator = new FixedLottoNumberGenerator();
    private Lotto lotto;

    @Test
    @DisplayName("로또 게임 구매 테스트")
    void When_Game_Then_LottoNumberList() {
        lotto = new Lotto(money, lottoNumberGenerator);

        //when
        List<LottoGame> games = lotto.games();

        //then
        assertThat(games.size()).isEqualTo(NUMBER_OF_GAMES);
    }

    @Test
    @DisplayName("수동 로또 입력 받기 테스트")
    void Given_ManualLottoGame_When_New_Then_InstanceCreated() {
        List<String> manualLottoGame = null;

        assertDoesNotThrow(() -> {
            lotto = new Lotto(money, manualLottoGame, lottoNumberGenerator);
        });
    }

    @Test
    @DisplayName("문자열 형식의 수동 로또 입력 받기")
    void Given_StringManualLottoNumbers_When_New_Then_IstanceCreated() {
        List<String> manualLottoNumbers = Arrays.asList(
                "1,2,3,4,5,6",
                "10,11,2,3,4,30"
        );

        assertDoesNotThrow(() -> {
            lotto = new Lotto(money, manualLottoNumbers, lottoNumberGenerator);
        });
    }


    @Test
    @DisplayName("로또 금액보다 수동 로또가 더 많으면 Exception")
    void Given_TooManyLottoGame_When_New_Then_Exception() {
        List<String> manualLottoGame = Arrays.asList(
                "1, 2, 3, 4, 5, 6",
                "1, 2, 3, 4, 5, 6"
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
        lotto = new Lotto(money, lottoNumberGenerator);

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

    @Test
    void Given_MoneyInstance_When_New_Then_NoException() {
        Money money = new Money(10000);

        assertDoesNotThrow(() -> {
            new Lotto(money, lottoNumberGenerator);
        });
    }
}
