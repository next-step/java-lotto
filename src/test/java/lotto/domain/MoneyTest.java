package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import lotto.common.ErrorCode;

import static org.assertj.core.api.Assertions.*;

public class MoneyTest {

    @ParameterizedTest
    @DisplayName("로또 티켓 구매 개수 테스트")
    @CsvSource(value = {"1000:1","1500:1", "10001: 10"}, delimiter = ':')
    void countLottoTicket_shouldBeDividedByLottoPrice(long inputMoney, int lottoTicketCount) {
        Money money = new Money(inputMoney);
        assertThat(money.countLottoTicket()).isEqualTo(lottoTicketCount);
    }

    @ParameterizedTest
    @DisplayName("금액 입력 테스트")
    @ValueSource(longs = {-1000,0, 500})
    void inputMoney_throwInvalidZeroNumberException(long inputMoney) {
        assertThatThrownBy(()-> new Money(inputMoney)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.INVALID_MONEY_RANGE.getErrorMessage());
    }

}
