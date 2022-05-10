package lotto;

import lotto.exception.WrongLottoMatchCountException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RankTest {
    @ParameterizedTest
    @CsvSource({
            "0,MISS",
            "1,MISS",
            "2,MISS",
            "3,FIFTH",
            "4,FOURTH",
            "5,THIRD",
            "6,FIRST"
    })
    @DisplayName("0~6 값을 입력 받으면 Rank enum을 반환한다.")
    void getEnumByCountOfMatch(int countOfMatch, Rank rank) {
        assertThat(Rank.valueOf(countOfMatch)).isEqualTo(rank);
    }

    @ParameterizedTest
    @DisplayName("0이하,7이상의 값이 입력되면 예외가 발생한다.")
    @ValueSource(ints = {-1, 7})
    void wrongNumberException(int expected) {
        assertThatThrownBy(() -> Rank.valueOf(expected))
                .isInstanceOf(WrongLottoMatchCountException.class);
    }
}
