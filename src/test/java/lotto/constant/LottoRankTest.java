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
    @CsvSource(value = {"6,FIRST", "5,SECOND", "4,THIRD", "3,FOURTH", "0,OUT_OF_RANK"})
    @DisplayName("번호일치 갯수를 기준으로 등수 확인")
    void getRank_by_countOfMatch(int countOfMatch, LottoRank rank) {
        assertThat(LottoRank.valueOf(countOfMatch)).isEqualTo(rank);
    }

    @ParameterizedTest
    @CsvSource(value = {"FIRST,2000000000", "SECOND,1500000", "THIRD,50000", "FOURTH,5000", "OUT_OF_RANK,0"})
    @DisplayName("순위에 따른 상금 확인이")
    void winningMoney(LottoRank rank, int winningMoney) {
        assertThat(rank.getWinningMoney()).isEqualTo(winningMoney);
    }

    @ParameterizedTest
    @CsvSource(value = {"FIRST,6", "SECOND,5", "THIRD,4", "FOURTH,3", "OUT_OF_RANK,0"})
    @DisplayName("순위에 부합하는 번호일치 개수 확인")
    void countOfMath(LottoRank rank, int countOfMatch) {
        assertThat(rank.getCountOfMatch()).isEqualTo(countOfMatch);
    }
}
