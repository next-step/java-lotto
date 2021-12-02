package lotto;

import lotto.domain.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TicketTest {

    @Test
    void 로또_길이_검사() {
        Lotto ticket = new Lotto();
        Assertions.assertThat(ticket.getNumbers().size()).isEqualTo(6);
    }

    @Test
    void 로또_번호_매칭() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            numbers.add(i);
        }
        Lotto ticket1 = new Lotto(numbers);
        Lotto ticket2 = new Lotto(numbers);

        Assertions.assertThat(ticket1.matchCount(ticket2)).isEqualTo(6);
    }
}
