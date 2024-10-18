package lotto.model.enums;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static lotto.model.enums.Ranking.*;
import static org.assertj.core.api.Assertions.assertThat;


public class RankingTest {

    @Test
    void 랭킹의_수익률을_출력한다() {
        long first = FIRST.totalWinningAmount(2);
        long second = SECOND.totalWinningAmount(2);
        long third = THIRD.totalWinningAmount(2);
        long fourth = FOURTH.totalWinningAmount(2);
        long fifth = FIFTH.totalWinningAmount(2);
        long none = NONE.totalWinningAmount(2);
        assertThat(first).isEqualTo(4_000_000_000L);
        assertThat(second).isEqualTo(60_000_000L);
        assertThat(third).isEqualTo(3_000_000L);
        assertThat(fourth).isEqualTo(100_000L);
        assertThat(fifth).isEqualTo(10_000L);
        assertThat(none).isEqualTo(0L);
    }

    @ParameterizedTest(name = "로또1등({0}, {1})")
    @CsvSource(value = {
            "6,true",
            "6,false",
    })
    void 로또1등(int matchedCount, boolean isMatchedBonusNumber) {
        Ranking actual = Ranking.result(matchedCount,isMatchedBonusNumber);
        assertThat(actual).isEqualTo(FIRST);
    }

    @ParameterizedTest(name = "로또2등({0}, {1})")
    @CsvSource(value = {
            "5,true"
    })
    void 로또2등(int matchedCount, boolean isMatchedBonusNumber) {
        Ranking actual = Ranking.result(matchedCount,isMatchedBonusNumber);
        assertThat(actual).isEqualTo(Ranking.SECOND);
    }

    @ParameterizedTest(name = "로또3등({0}, {1})")
    @CsvSource(value = {
            "5,false"
    })
    void 로또3등(int matchedCount, boolean isMatchedBonusNumber) {
        Ranking actual = Ranking.result(matchedCount,isMatchedBonusNumber);
        assertThat(actual).isEqualTo(THIRD);
    }

    @ParameterizedTest(name = "로또4등({0}, {1})")
    @CsvSource(value = {
            "4,false",
            "4,true"
    })
    void 로또4등(int matchedCount, boolean isMatchedBonusNumber) {
        Ranking actual = Ranking.result(matchedCount,isMatchedBonusNumber);
        assertThat(actual).isEqualTo(Ranking.FOURTH);
    }

    @ParameterizedTest(name = "로또5등({0}, {1})")
    @CsvSource(value = {
            "3,false",
            "3,true"
    })
    void 로또5등(int matchedCount, boolean isMatchedBonusNumber) {
        Ranking actual = Ranking.result(matchedCount,isMatchedBonusNumber);
        assertThat(actual).isEqualTo(Ranking.FIFTH);
    }

    @ParameterizedTest(name = "로또등수없음({0}, {1})")
    @CsvSource(value = {
            "2,false", "2,true",
            "1,false", "1,true",
            "0,false", "0,true",
    })
    void 로또등수없음(int matchedCount, boolean isMatchedBonusNumber) {
        Ranking actual = Ranking.result(matchedCount,isMatchedBonusNumber);
        assertThat(actual).isEqualTo(Ranking.NONE);
    }

}