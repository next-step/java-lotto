package step2.analyze;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PrizeTest {
    @ParameterizedTest
    @CsvSource(value = {
            "3:5000",
            "4:50000",
            "5:15000000",
            "6:2000000000"
    }, delimiter = ':')
    @DisplayName("맞는 개수에 대한 상금 조회")
    void getPrice(int matchCount, int prize) {
        assertThat(Prize.of(matchCount, false).getMoney()).isEqualTo(prize);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "3:false:KRW_5_000",
            "4:false:KRW_50_000",
            "5:false:KRW_1_500_000",
            "5:true:KRW_30_000_000",
            "6:false:KRW_2_000_000_000"
    }, delimiter = ':')
    @DisplayName("조건에 일치하는 prize 확인 테스트")
    void of(int matchCount, boolean hasBonus, String prize) {
        assertThat(Prize.of(matchCount, hasBonus)).isEqualTo(Prize.valueOf(prize));
    }
}