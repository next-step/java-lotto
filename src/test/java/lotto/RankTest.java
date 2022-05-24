package lotto;

import lotto.domain.Rank;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class RankTest {
    @ParameterizedTest
    @CsvSource(value = {"2/false/꽝", "3/false/오등", "4/false/사등", "5/false/삼등", "5/true/이등", "6/false/일등"}, delimiter = '/')
    void 타입찾기(int numberOfSame, boolean isSameBonusNumber, Rank type) {
        Rank winningsType = Rank.selectType(numberOfSame, isSameBonusNumber);
        assertThat(winningsType).isEqualTo(type);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 7})
    void Rank_번호유효성체크(int number) {
        assertThatThrownBy(() -> {
            Rank.selectType(number, true);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}

