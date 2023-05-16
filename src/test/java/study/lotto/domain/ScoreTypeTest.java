package study.lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class ScoreTypeTest {


    @ParameterizedTest
    @CsvSource(value = {
            "6, SIX",
            "5, FIVE",
            "4, FOUR",
            "3, THREE",
            "2, TWO",
            "1, ONE"
    })
    void 스코어_타입_테스트(int matchCount, ScoreType result) {
        ScoreType scoreType = ScoreType.of(matchCount);
        assertThat(scoreType == result);
    }

    @Test
    void 보너스_스코어_타입() {
        ScoreType scoreType = ScoreType.ofBonus();
        assertThat(scoreType == ScoreType.BONUS);
    }
}
