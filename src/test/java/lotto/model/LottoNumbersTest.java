package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;


class LottoNumbersTest {
    @Test
    @DisplayName("로또 번호는 중복될 수 없다")
    void testLottoNumbersShouldNotBeSameOne() {
        // Given
        List<LottoNumber> lottoNumbers = Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(2),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)
        );

        // When & Then
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumbers(lottoNumbers));
    }

    @Test
    @DisplayName("두 LottoNumbers 중 같은 LottoNumber 의 개수를 반환한다")
    void testCountSameLottoNumber() {
        // Given
        LottoNumbers lottoNumbersA = buildLottoNumbers(1, 2, 3, 4, 5, 6);
        LottoNumbers lottoNumbersB = buildLottoNumbers(1, 2, 3, 4, 35, 36);

        // When
        long count = lottoNumbersA.countSameLottoNumber(lottoNumbersB);

        // Then
        assertThat(count).isEqualTo(4);
    }

    @ParameterizedTest(name = "0~2개, 3개, 4개, 5개, 6개가 일치한 경우 {2}을 반환해야 한다")
    @MethodSource("rankSources")
    void testGetRank(LottoNumbers userNumbers, LottoNumbers winningNumbers, Rank expected) {
        // When
        Rank rank = userNumbers.getRank(winningNumbers);

        // Then
        assertThat(rank).isEqualTo(expected);
    }

    static Stream<Arguments> rankSources() {
        return Stream.of(
                Arguments.of(buildLottoNumbers(1, 2, 3, 4, 5, 6), buildLottoNumbers(1, 2, 33, 44, 35, 36), Rank.NOTHING),
                Arguments.of(buildLottoNumbers(1, 2, 3, 4, 5, 6), buildLottoNumbers(1, 2, 3, 44, 35, 36), Rank.FOURTH),
                Arguments.of(buildLottoNumbers(1, 2, 3, 4, 5, 6), buildLottoNumbers(1, 2, 3, 4, 35, 36), Rank.THIRD),
                Arguments.of(buildLottoNumbers(1, 2, 3, 4, 5, 6), buildLottoNumbers(1, 2, 3, 4, 5, 36), Rank.SECOND),
                Arguments.of(buildLottoNumbers(1, 2, 3, 4, 5, 6), buildLottoNumbers(1, 2, 3, 4, 5, 6), Rank.FIRST)
        );
    }

    private static LottoNumbers buildLottoNumbers(int... numbers) {
        return new LottoNumbers(
                Arrays.stream(numbers)
                        .mapToObj(LottoNumber::new)
                        .collect(Collectors.toList()));
    }
}