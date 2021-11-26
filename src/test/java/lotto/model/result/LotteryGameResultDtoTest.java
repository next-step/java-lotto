package lotto.model.result;

import lotto.model.domain.Rank;
import lotto.model.result.LotteryGameResultDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LotteryGameResultDtoTest {

    LotteryGameResultDto resultDto;

    @BeforeEach
    void setup() {
        resultDto = new LotteryGameResultDto(2000);
    }

    @ParameterizedTest
    @CsvSource(value = {"0,1,0,","0,3,2.5", "3,4,27.5"})
    @DisplayName("수익률 계산 테스트")
    void getProfitAndIsLossTest(int firstMatch, int secondMatch, double profit){
        resultDto.plusResultCount(Rank.valueOf(firstMatch, false));
        resultDto.plusResultCount(Rank.valueOf(secondMatch, false));
        assertThat(resultDto.getProfit()).isEqualTo(profit);
    }

    @ParameterizedTest
    @CsvSource(value = {"0,1,true","0,3,false", "3,4,15,false"})
    @DisplayName("손해 이익 계산 테스트")
    void isLossTest(int firstMatch, int secondMatch, boolean isLoss){
        resultDto.plusResultCount(Rank.valueOf(firstMatch, false));
        resultDto.plusResultCount(Rank.valueOf(secondMatch, false));
        assertThat(resultDto.isLoss()).isEqualTo(isLoss);
    }

    @ParameterizedTest
    @CsvSource(value = {"3, 4, 5, 6"})
    @DisplayName("일치하는 수에 따라 +1 되는 것 테스트")
    void addPlusTest(int match){
        long beforeCount = resultDto.getResults().get(Rank.valueOf(match, false));
        resultDto.plusResultCount(Rank.valueOf(match, false));
        long afterCount = resultDto.getResults().get(Rank.valueOf(match, false));
        assertThat(beforeCount + 1).isEqualTo(afterCount);
    }
}