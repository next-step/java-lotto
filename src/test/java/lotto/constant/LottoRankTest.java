package lotto.constant;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * LottoRank 열거형의 값 확인 및 기능 테스트
 */
public class LottoRankTest {

    @ParameterizedTest
    @CsvSource(value = {"6,false,FIRST", "5,true,SECOND", "5,false,THIRD", "4,true,FOURTH", "3,true,FIFTH", "0,true,OUT_OF_RANK"})
    @DisplayName("번호일치 갯수 및 보너스 번호를 기준으로 등수 확인")
    void getRank_by_countOfMatch_with_bonusNumber(int countOfMatch, boolean bonus, LottoRank rank) {
        assertThat(LottoRank.valueOf(countOfMatch, bonus)).isEqualTo(rank);
    }

    @ParameterizedTest
    @CsvSource(value = {"FIRST,2000000000", "SECOND,30000000", "THIRD,1500000", "FOURTH,50000", "FIFTH,5000", "OUT_OF_RANK,0"})
    @DisplayName("순위에 따른 상금 확인이")
    void winningMoney(LottoRank rank, int winningMoney) {
        assertThat(rank.getWinningMoney()).isEqualTo(winningMoney);
    }

    @ParameterizedTest
    @CsvSource(value = {"FIRST,6", "SECOND,5", "THIRD,5", "FOURTH,4", "FIFTH,3", "OUT_OF_RANK,0"})
    @DisplayName("순위에 부합하는 번호일치 개수 확인")
    void countOfMath(LottoRank rank, int countOfMatch) {
        assertThat(rank.getCountOfMatch()).isEqualTo(countOfMatch);
    }
}
