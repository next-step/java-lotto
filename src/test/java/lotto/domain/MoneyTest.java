package lotto.domain;

import lotto.common.WinningType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import lotto.common.ErrorCode;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MoneyTest {

    @ParameterizedTest
    @DisplayName("로또 티켓 구매 개수 테스트")
    @CsvSource(value = {"1000:1","1500:1", "10001: 10"}, delimiter = ':')
    void countLottoTicket_shouldBeDividedByLottoPrice(long inputMoney, int lottoTicketCount) {
        //로또 티켓 개수 = 지불 금액/로또 가격
        Money money = new Money(inputMoney);
        assertThat(money.countLottoTicket()).isEqualTo(lottoTicketCount);
    }

    @ParameterizedTest
    @DisplayName("금액 입력 테스트")
    @ValueSource(longs = {-1000,0, 500})
    void inputMoney_throwInvalidZeroNumberException(long inputMoney) {
        //금액은 로또 가격보다 커야한다.
        assertThatThrownBy(()-> new Money(inputMoney)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.INVALID_MONEY_RANGE.getErrorMessage());
    }

    @Test
    @DisplayName("수익률 계산 소수점 테스트")
    void calculateProfit_shouldFloor() {
        //소수점 둘째자리까지 표기되며 이후는 버림
        List<WinningType> plusWinningTypes = Arrays.asList(WinningType.FIFTH, WinningType.FIFTH, WinningType.SEVENTH);
        assertThat(new Money(3000).calculateProfit(10000)).isEqualTo(3.33);

        List<WinningType> MinusWinningTypes = Arrays.asList(WinningType.SIXTH, WinningType.SEVENTH, WinningType.EIGHTH);
        assertThat(new Money(3000).calculateProfit(0)).isEqualTo(0.00);
    }

}
