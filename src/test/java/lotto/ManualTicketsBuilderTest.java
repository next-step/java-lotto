package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import lotto.domains.Purchase;
import lotto.domains.Tickets;
import lotto.exceptions.InvalidNumberException;
import lotto.exceptions.NumberOutOfBoundsException;
import lotto.exceptions.TicketsOutOfBoundsException;

public class ManualTicketsBuilderTest {

    @DisplayName("빈 문자열 또는 null 값이면 에러 발생")
    @Test
    void create_EmptyOrNull_ExceptionThrown() {
        Purchase purchase = new Purchase("12000");

        assertThatExceptionOfType(InvalidNumberException.class).isThrownBy(() -> {
            new ManualTicketsBuilder(purchase, "");
        });
        assertThatExceptionOfType(InvalidNumberException.class).isThrownBy(() -> {
            new ManualTicketsBuilder(purchase, null);
        });

    }

    @DisplayName("숫자 범위가 0 ~ 구매한 로또 수 사이가 아니면 에러 발생")
    @ParameterizedTest(name = "구입 금액: {0}, {1}개 선택은 불가능")
    @CsvSource(value = {"1000,-1", "12345,13"})
    void create_OutOfBounds_ExceptionThrown(String cash, String text) {
        assertThatExceptionOfType(NumberOutOfBoundsException.class).isThrownBy(() -> {
            new ManualTicketsBuilder(new Purchase(cash), text);
        });
    }

    @DisplayName("수동으로 구매 개수와 입력한 티켓 수가 맞지 않으면 에러 발생")
    @Test
    void create_IncorrectTickets_ExceptionThrown() {
        assertThatExceptionOfType(TicketsOutOfBoundsException.class).isThrownBy(() -> {
            new ManualTicketsBuilder(new Purchase("3000"), "2").build();
        });
    }

    @DisplayName("수동으로 티켓 생성")
    @Test
    void manualTicketing() {
        Tickets tickets = new ManualTicketsBuilder(new Purchase("3000"), "2")
            .newTickets(() -> new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)))
            .build();

        assertThat(tickets.size()).isEqualTo(2);
    }

}
