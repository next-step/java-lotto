package LottoTest;

import lotto.domain.LottoGame;
import lotto.domain.LottoGameResult;
import lotto.domain.LottoNumber;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

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
        LottoNumber fixedLottoNumber = new FixedLottoNumber();

        //when
        LottoGame lottoGame = new LottoGame(fixedLottoNumber);

        //then
        assertThat(lottoGame).isEqualTo(new LottoGame(fixedLottoNumber.numbers()));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 6, 7})
    void Given_Number_When_Contains_Then_Expected(int number) {
        //given
        List<Integer> givenLottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        LottoGame lottoGame = new LottoGame(givenLottoNumbers);
        boolean expected = givenLottoNumbers.contains(number);

        //when
        boolean containsNumber = lottoGame.contains(number);

        //then
        assertThat(containsNumber).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("provideWinningNumbers")
    void Given_WinningNumbers_When_Result_Then_NumberOfMatchedNumbers(List<Integer> winningNumbers, int expected) {
        LottoGame lottoGame = new LottoGame(new FixedLottoNumber());

        //when
        LottoGameResult lottoGameResult = lottoGame.result(winningNumbers);

        //then
        assertThat(lottoGameResult).isEqualTo(new LottoGameResult(expected));
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
