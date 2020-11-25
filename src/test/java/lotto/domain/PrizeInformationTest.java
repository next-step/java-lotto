package lotto.domain;

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
}
