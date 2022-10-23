package step2.lotto;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketsTest {

    @Test
    void 천원의_배수만큼_로또를_생성한다() {
        int numberOfTickets = 1;
        int price = 1000 * numberOfTickets;
        NumbersGenerator numbersGenerator = new NumbersGenerator.Fake(Set.of(1, 2, 3, 4, 5, 6));
        LottoTickets lottoTickets = LottoTickets.of(price, numbersGenerator);

        assertThat(lottoTickets.numberOfTickets()).isOne();
    }
}
