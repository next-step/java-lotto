package study.lotto.step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class LottoReaderTest {
    @ParameterizedTest(name = "[{index}/7] {displayName}")
    @MethodSource("lottoAndLottoResult")
    @DisplayName("로또 객체로부터 로또 결과 enum 반환")
    void LottoResult_from_Lotto(Lotto lotto, LottoResult expectedLottoResult) {
        // given
        LottoReader lottoReader = new LottoReader(List.of(1, 2, 3, 4, 5, 6));

        // when
        LottoResult lottoResult = lottoReader.resultOf(lotto);

        // then
        assertThat(lottoResult).isEqualTo(expectedLottoResult);
    }

    @Test
    @DisplayName("로또 리스트로부터 LottoResults 객체 반환")
    void LottoResult_list_from_Lotto_list() {
        // given
        LottoReader lottoReader = new LottoReader(List.of(1, 2, 3, 4, 5, 6));
        Lotto notMatchLotto = new Lotto(List.of(11, 12, 13, 14, 15, 16));
        Lotto oneMatchLotto = new Lotto(List.of(1, 12, 13, 14, 15, 16));

        List<Lotto> lottos = List.of(notMatchLotto, oneMatchLotto);

        // when
        LottoResults lottoResults = lottoReader.resultOf(lottos);

        // then
        LottoResults expectedLottoResults = new LottoResults(
                List.of(LottoResult.NOT_MATCH, LottoResult.MATCH_ONE_NUMBER)
        );
        assertThat(lottoResults).isEqualTo(expectedLottoResults);
    }

    @Test
    @DisplayName("로또 당첨 번호가 6개가 아닐 경우, IllegalArgumentException 예외 발생")
    void invalid_numbers_of_winning_then_throw_IllegalArgumentException() {
        // given
        List<Integer> illegalNumbersOfWinning = IntStream.rangeClosed(1, 7)
                .boxed()
                .collect(Collectors.toList());

        // when, then
        assertThatThrownBy(() -> new LottoReader(illegalNumbersOfWinning))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("당첨 번호 갯수는 6개입니다: " + illegalNumbersOfWinning.size());
    }

    @Test
    @DisplayName("당첨 번호가 범위(1 이상 45 이하의 정수)를 넘어서는 경우, IllegalArgumentException 예외 발생")
    void out_of_range_winning_number_then_throw_IllegalArgumentException() {
        // given
        int outOfRangeNumber = 46;
        List<Integer> numbersOfWinning = List.of(1, 2, 3, 4, 5, outOfRangeNumber);

        // when, then
        assertThatThrownBy(() -> new LottoReader(numbersOfWinning))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 당첨 번호는 1 이상 45 이하의 정수입니다: " + outOfRangeNumber);
    }

    private static Stream<Arguments> lottoAndLottoResult() {
        return Stream.of(
                Arguments.of(new Lotto(List.of(7, 8, 9, 10, 11, 12)), LottoResult.NOT_MATCH),
                Arguments.of(new Lotto(List.of(1, 8, 9, 10, 11, 12)), LottoResult.MATCH_ONE_NUMBER),
                Arguments.of(new Lotto(List.of(1, 2, 9, 10, 11, 12)), LottoResult.MATCH_TWO_NUMBERS),
                Arguments.of(new Lotto(List.of(1, 2, 3, 10, 11, 12)), LottoResult.MATCH_THREE_NUMBERS),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 11, 12)), LottoResult.MATCH_FOUR_NUMBERS),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 12)), LottoResult.MATCH_FIVE_NUMBERS),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), LottoResult.MATCH_SIX_NUMBERS)
        );
    }
}