package Lotto.model;

import calculator.model.Operator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.EnumSet;

import static org.assertj.core.api.Assertions.*;

class RankTest {

    private static final int FIRST_MATCH_COUNT = 6;
    private static final int SECOND_MATCH_COUNT = 5;
    private static final int THIRD_MATCH_COUNT = 4;
    private static final int FOURTH_MATCH_COUNT = 3;
    private static final int NOT_RANK_MATCH_COUNT = 7;


    @Test
    @DisplayName("랭킹 대한 정상적인 값 처리")
    public void constructorSuccessTest() {
        assertThat(Rank.getRank(FIRST_MATCH_COUNT)).isEqualTo(Rank.FIRST);
        assertThat(Rank.getRank(SECOND_MATCH_COUNT)).isEqualTo(Rank.SECOND);
        assertThat(Rank.getRank(THIRD_MATCH_COUNT)).isEqualTo(Rank.THIRD);
        assertThat(Rank.getRank(FOURTH_MATCH_COUNT)).isEqualTo(Rank.FOURTH);
    }

    @ParameterizedTest
    @EnumSource(value = Rank.class, names = {"FIRST", "SECOND", "THIRD", "FOURTH"})
    @DisplayName("정상적으로 이름들이 있는지 확인")
    void constructorEnumTest(Rank rank) {
        assertThat(EnumSet.of(Rank.FIRST, Rank.SECOND, Rank.THIRD, Rank.FOURTH)).contains(rank);
    }

    @Test
    @DisplayName("랭킹이 아닌 값에 대한 에러처리")
    public void constructorErrorTest() {
        assertThatThrownBy(() -> Rank.getRank(NOT_RANK_MATCH_COUNT)).isInstanceOf(IllegalArgumentException.class);
    }

}