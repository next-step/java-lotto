package lotto.domains;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import lotto.ManualTicketsBuilder;
import lotto.exceptions.CashOutOfBoundsException;
import lotto.exceptions.InvalidNumberException;
import lotto.exceptions.NumberOutOfBoundsException;

public class PurchaseTest {

    @DisplayName("로또를 구매한다.")
    @ParameterizedTest(name = "금액: \"{0}\", 티켓: \"{1}\"")
    @CsvSource(value = {"1000,1", "12345,12"})
    void totalTickets(String input, int expected) {
        Purchase purchase = new Purchase(input);
        assertThat(purchase.ticketsAmount()).isEqualTo(expected);
    }

    @DisplayName("숫자가 아닌 문자열은 티켓 구매를 실패한다.")
    @ParameterizedTest
    @ValueSource(strings = {"", "a"})
    void createPurchase_InvalidNumber_ExceptionThrown(String input) {
        assertThatExceptionOfType(InvalidNumberException.class).isThrownBy(() -> {
            new Purchase(input);
        });
    }

    @DisplayName("구입 가능 범위를 벗어나 티켓 구매를 실패한다.")
    @ParameterizedTest
    @ValueSource(strings = {"999", "1000001"})
    void createPurchase_NumberOutOfBounds_ExceptionThrown(String input) {
        assertThatExceptionOfType(CashOutOfBoundsException.class).isThrownBy(() -> {
            new Purchase(input);
        });
    }

    @DisplayName("수동 로또 개수 범위가 0 ~ 구매한 로또 수 사이가 아니면 에러 발생")
    @ParameterizedTest(name = "구입 금액: {0}, {1}개 선택은 불가능")
    @CsvSource(value = {"1000,-1", "12345,13"})
    void selectManualAmount_OutOfBounds_ExceptionThrown(String cash, int amount) {
        Purchase purchase = new Purchase(cash);
        assertThatExceptionOfType(NumberOutOfBoundsException.class).isThrownBy(() -> {
            purchase.selectManualAmount(amount);
        });
    }

    @DisplayName("수동 로또 1 + 자동 로또 2 = 전체 로또 3")
    @Test
    void amount() {
        Purchase purchase = new Purchase("3000");
        purchase.selectManualAmount(1);
        Tickets tickets = new Tickets(Collections.singletonList(new Ticket("1,2,3,4,5,6")));

        assertThat(purchase.skipManualTickets()).isFalse();
        assertThat(purchase.isNotSameAsManualAmount(tickets)).isFalse();
        assertThat(purchase.automatedAmount()).isEqualTo(2);
    }

}
