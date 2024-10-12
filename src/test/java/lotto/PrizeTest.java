package lotto;

import lotto.constant.Prize;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class PrizeTest {

    @Test
    void 개수에_따른_등수_확인_4등이내() {
        int matchCount = 4;
        Prize prize = Prize.valueOf(matchCount);
        assertThat(prize).isEqualTo(Prize.FOURTH);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    void 개수에_따른_등수_확인_등수이외(int matchCount) {
        Prize prize = Prize.valueOf(matchCount);
        assertThat(prize).isEqualTo(null);
    }
}
