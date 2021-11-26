package lotto.model.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @ParameterizedTest
    @CsvSource(value = {"0,0", "1,0", "2,0", "3,5000", "4,50000", "5,1500000", "6,2000000000"})
    @DisplayName("보너스 없을 때 맞춘 수에 맞는 Rank 가져오는지 확인")
    void rankValueOfNoBonusTest(int countOfMatch, long winningMoney){
        Rank rank = Rank.valueOf(countOfMatch,false);
        assertThat(rank.getWinningMoney()).isEqualTo(winningMoney);
    }

    @Test
    @DisplayName("보너스 맞추었을 때 Rank 잘 가져오는지 테스트")
    void rankValueOfWithBonusTest(){
        Rank rank = Rank.valueOf(5,true);
        assertThat(rank.getWinningMoney()).isEqualTo(30000000);
    }
}