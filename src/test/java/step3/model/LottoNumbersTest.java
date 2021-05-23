package step3.model;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import step3.constant.Rank;

public class LottoNumbersTest {

    @Test
    @DisplayName("6개 이상의 숫자를 담을 시 IllegalArgumentException 발생")
    void validationTest() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new LottoNumbers(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7)));
        });

        assertThat(exception.getMessage()).isEqualTo("6개의 숫자까지만 담을 수 있습니다.");
    }

    @ParameterizedTest
    @DisplayName("숫자 배열을 입력받아 일치하는 갯수 반환 테스트")
    @MethodSource("checkRank")
    void countWinningTest(LottoNumbers numbers, Rank rank) {
        LottoNumbers victoryNumber = LottoNumbers.of("1,2,3,4,5,6");
        assertThat(numbers.getRankWithVictoryNumber(victoryNumber)).isEqualTo(rank);

    }

    private static Stream<Arguments> checkRank() {
        return Stream.of(Arguments.of(LottoNumbers.of("1, 2, 3, 4, 5, 6"), Rank.FIRST),
                Arguments.of(LottoNumbers.of("1, 2, 3, 4, 5, 6"), Rank.FIRST),
                Arguments.of(LottoNumbers.of("2, 3, 4, 5, 6, 7"), Rank.SECOND),
                Arguments.of(LottoNumbers.of("3, 4, 5, 6, 7, 8"), Rank.THIRD),
                Arguments.of(LottoNumbers.of("4, 5, 6, 7, 8, 9"), Rank.FOURTH));
    }

}
