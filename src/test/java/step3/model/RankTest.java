package step3.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Enum 제작한 Rank에 대한 테스트 수행")
class RankTest {

    @ParameterizedTest
    @CsvSource(value = {"1,true,MISS", "2,true,MISS", "3,true,FIFTH"
            , "4,true,FOURTH", "5,false,THIRD", "5,true,SECOND"
            , "6,true,FIRST", "1, false, MISS", "2,false, MISS"
            , "3,false,FIFTH", "4,false,FOURTH", "6,false,FIRST"
    })
    @DisplayName("입력된 값에 따라서 실제 등수 판정을 정확히 하는지 테스트")
    void check_enum_Rank_Test(int countOfMatch, boolean matchBonus, Rank expected) {
        assertThat(Rank.valueOf(countOfMatch, matchBonus)).isEqualTo(expected);
    }
}