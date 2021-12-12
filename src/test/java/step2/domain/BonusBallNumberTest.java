package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class BonusBallNumberTest {

    @ParameterizedTest
    @CsvSource(value = {"1, 1", "2, 2", "30, 30", "14, 14"})
    @DisplayName("보너스볼은 LottoNumber 객체를 반환한다")
    public void createObject(int input, int expected) {

        assertThat(new BonusBallNumber(input).getBonusBallNumber()).isEqualTo(new LottoNumber(expected));
    }

    @ParameterizedTest
    @MethodSource("createNumber")
    @DisplayName("보너스볼은 지난 당첨번호와 중복이면 예외를 던진다")
    public void duplicateException(int input, MatchedNumber matchedNumber) {

        assertThatThrownBy(() -> {
            BonusBallNumber bonusBallNumber = new BonusBallNumber(input);
            bonusBallNumber.notUniqueOrElseThrow(matchedNumber);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> createNumber() {
        return Stream.of(
                arguments(1, new MatchedNumber("1, 2, 3, 4, 5, 6")),
                arguments(10, new MatchedNumber("40, 2, 10, 4, 15, 20")),
                arguments(21, new MatchedNumber("10, 11, 18, 21, 19, 30")),
                arguments(33, new MatchedNumber("5, 10, 33, 19, 12, 45"))
        );
    }


}
