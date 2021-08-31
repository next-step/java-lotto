package lottery_bonus;

import lottery_bonus.type.ProfitRateMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class ProfitRateMessageTest {

    @ParameterizedTest
    @CsvSource(value = {"1,BENEFIT","0,BREAK_EVEN", "-1,LOSS"})
    @DisplayName("수익률 평가 메세지 테스트")
    void equal(int criteria, ProfitRateMessage message) {
        assertThat(message.equal(criteria)).isEqualTo(message);
    }
}