package LottoTest;

import lotto.LottoGame;
import lotto.LottoGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class LottoGameTest {
    @Test
    void Given_LottoNumber_When_New_Then_InstanceCreated() {
        //given
        List<Integer> givenLottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        //when
        LottoGame lottoGame = new LottoGame(givenLottoNumbers);

        //then
        assertThat(lottoGame).isEqualTo(new LottoGame(givenLottoNumbers));
    }

    @Test
    void Given_LottoGenerator_When_New_Then_InstanceCreate() {
        LottoGenerator fixedLottoGenerator = new FixedLottoGenerator();

        //when
        LottoGame lottoGame = new LottoGame(fixedLottoGenerator);

        //then
        assertThat(lottoGame).isEqualTo(new LottoGame(fixedLottoGenerator.generate()));
    }

    @ParameterizedTest
    @MethodSource("provideWinningNumbers")
    void Given_WinningNumbers_When_Match_Then_NumberOfMatchedNumbers(List<Integer> winningNumbers, int expected) {
        LottoGenerator fixedLottoGenerator = new FixedLottoGenerator();
        LottoGame lottoGame = new LottoGame(fixedLottoGenerator);

        //when
        int winners = lottoGame.matches(winningNumbers);

        //then
        assertThat(winners).isEqualTo(expected);
    }

    private static Stream<Arguments> provideWinningNumbers() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), 6),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 7), 5),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 8, 7), 4),
                Arguments.of(Arrays.asList(1, 2, 3, 9, 8, 7), 3),
                Arguments.of(Arrays.asList(1, 2, 10, 9, 8, 7), 2),
                Arguments.of(Arrays.asList(1, 11, 10, 9, 8, 7), 1),
                Arguments.of(Arrays.asList(12, 11, 10, 9, 8, 7), 0)
        );
    }
}
