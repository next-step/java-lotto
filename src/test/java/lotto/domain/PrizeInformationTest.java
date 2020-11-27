package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class PrizeInformationTest {

    @ParameterizedTest
    @CsvSource(value = {"3:false:5000", "4:false:50000", "5:false:1500000",
                        "5:true:30000000", "6:false:2000000000"}, delimiter = ':')
    public void prizeInformationTest(int count, boolean isBousball, int expectWinningMoney) {
        //Given & When
        PrizeInformation information = PrizeInformation.findByPrizePrice(new MatchStatus(count, isBousball));

        //Then
        assertThat(information).isNotNull();
        assertThat(information.getPrizePrice()).isEqualTo(expectWinningMoney);
    }

    @DisplayName("당첨번호 일치 갯수가 5개가 아닌 갯수에서 보너스볼이 나왔을 때의 테스트 ")
    @ParameterizedTest
    @CsvSource(value = {"3:true:5000", "4:true:50000", "5:false:1500000",
            "5:true:30000000", "6:true:2000000000"}, delimiter = ':')
    public void notAllowedBonusball(int count, boolean isBousball, int expectWinningMoney){

        //Given & When
        PrizeInformation information = PrizeInformation.findByPrizePrice(new MatchStatus(count, isBousball));

        //Then
        assertThat(information.getPrizePrice()).isEqualTo(expectWinningMoney);
    }
}
