package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import lotto.domains.Purchase;

public class AutomaticTicketingTest {

    private AutomaticTicketing automaticTicketing = new AutomaticTicketing(
        () -> new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));

    @DisplayName("로또 번호 6개를 생성한다.")
    @ParameterizedTest(name = "출력: \"{1}\"")
    @ValueSource(strings = {"[1, 2, 3, 4, 5, 6]"})
    void newTicket(String expected) {
        assertThat(automaticTicketing.newTicket().toString()).isEqualTo(expected);
    }

    @DisplayName("로또 N개를 생성한다.")
    @ParameterizedTest(name = "입력: \"{0}\", 출력: \"{1}\"")
    @CsvSource(value = {"1000:1", "3000:3"}, delimiter = ':')
    void newTickets(String cash, int expected) {
        Purchase purchase = new Purchase(cash);
        assertThat(automaticTicketing.newTickets(purchase).size()).isEqualTo(expected);
    }

}
