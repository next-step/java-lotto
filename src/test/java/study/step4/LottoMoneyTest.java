package study.step4;


import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import study.step4.domain.LottoMoney;
import study.step4.domain.LottoTicketCount;

public class LottoMoneyTest {

    @ParameterizedTest(name = "금액 유효성 테스트")
    @ValueSource(strings = {"900", "-1"})
    public void validMoney(int input) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new LottoMoney(input));
    }

    @ParameterizedTest(name = "복권 수동 구매 수에 따른 자동 구매 수 테스트")
    @CsvSource(value = {"1:9", "5:5", "10:0"}, delimiter = ':')
    void manual(int input, int expected) {
        // given
        LottoMoney lottoMoney = new LottoMoney(10000);
        // when & then
        assertThat(lottoMoney.buyableCount(new LottoTicketCount(input))).isEqualTo(expected);
    }
}
