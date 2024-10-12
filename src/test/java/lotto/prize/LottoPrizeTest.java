package lotto.prize;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoPrizeTest {

    @DisplayName("맞춘 로또 번호에 해당하는 당첨금을 조회할 수 있다.")
    @ParameterizedTest
    @CsvSource({"3,5000", "4,50000", "5,1500000", "6,2000000000"})
    void getLottoPrize(int matchedCount, int prize) {

        assertThat(LottoPrize.getPrizeAmount(matchedCount)).isEqualTo(prize);
    }
}