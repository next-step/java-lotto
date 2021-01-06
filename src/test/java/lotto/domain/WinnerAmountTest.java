package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class WinnerAmountTest {

    @ParameterizedTest
    @CsvSource(value = {"0=0=꽝",
            "3=5000=3개 일치",
            "4=50000=4개 일치",
            "5=1500000=5개 일치",
            "6=2000000000=6개 일치",
            },delimiter = '=')
    @DisplayName("당첨개수에 따른 결과값")
    void matchCheck(String match, String prize, String message) {
        WinnerAmount winnerAmount = WinnerAmount.matchCheck(parseInt(match));
        assertThat(winnerAmount.getPrize()).isEqualTo(parseInt(prize));
        assertThat(winnerAmount.getMessage()).isEqualTo(message);
    }

    @Test
    @DisplayName("2등 당첨 확인")
    void secondPlace() {
        WinnerAmount winnerAmount = WinnerAmount.SECOND;
        assertThat(winnerAmount.getPrize()).isEqualTo(parseInt("30000000"));
        assertThat(winnerAmount.getMessage()).isEqualTo("5개 일치 보너스 볼 일치");
    }

    private int parseInt(String value) {
        return Integer.parseInt(value);
    }
}