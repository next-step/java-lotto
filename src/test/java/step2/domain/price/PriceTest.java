package step2.domain.price;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class PriceTest {

    @ParameterizedTest
    @CsvSource(value = {
            "2:true : MISS  :0",
            "3:true : FIFTH :5000",
            "4:false: FORTH :50000",
            "5:false: THIRD :1500000",
            "5:true : SECOND:30000000",
            "6:false: FIRST :2000000000"}, delimiter = ':')
    @DisplayName("당첨 등수와 상금을 알 수 있다")
    void determineNumberMatch(int matchCount, boolean matchBonus, String expectedRank, int expectedPrize) {
        Price price = Price.price(matchCount, matchBonus);
        assertThat(price.getRank()).isEqualTo(expectedRank);
        assertThat(price.getPrize()).isEqualTo(expectedPrize);
    }

}
