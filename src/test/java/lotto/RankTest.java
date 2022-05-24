package lotto;

import lotto.domain.Rank;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class RankTest {
    @ParameterizedTest
    @CsvSource(value = {"3/false/오등", "5/false/삼등", "5/true/이등"}, delimiter = '/')
    void 타입찾기(int numberOfSame, boolean isSameBonusNumber, Rank type) {
        Rank winningsType = Rank.selectType(numberOfSame, isSameBonusNumber);
        assertThat(winningsType).isEqualTo(type);
    }
}

