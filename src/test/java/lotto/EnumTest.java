package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.EnumMap;
import java.util.Map;
import lotto.WinningNumbers.Rank;
import org.junit.jupiter.api.Test;

public class EnumTest {

    @Test
    void 열거형맵순서() {
        assertThat(Rank.values()).containsExactly(Rank.FOURTH_GRADE, Rank.THIRD_GRADE, Rank.SECOND_GRADE, Rank.FIRST_GRADE);
    }

    @Test
    void 열거형맵() {
        Map<Rank, Integer> map = new EnumMap<>(Rank.class){{
            put(Rank.FIRST_GRADE, 0);
            put(Rank.SECOND_GRADE, 0);
            put(Rank.THIRD_GRADE, 0);
            put(Rank.FOURTH_GRADE, 0);
        }};

        assertThat(map.values()).containsExactly(0,0,0,0);
    }

}
