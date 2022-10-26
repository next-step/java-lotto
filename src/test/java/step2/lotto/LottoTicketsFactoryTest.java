package step2.lotto;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketsFactoryTest {

    @Test
    void 로또_티켓들을_생성할_수_있다() {
        int price = 1000;
        NumbersGenerator numbersGenerator = new NumbersGenerator.Fake(Set.of(1, 2, 3, 4, 5, 6));

        LottoTicketsFactory lottoTicketsFactory = new LottoTicketsFactory(price, numbersGenerator);

        List<LottoTicket> lottoTickets = List.of(LottoTicket.from(numbersGenerator));
        assertThat(lottoTicketsFactory.lottoTickets()).isEqualTo(new LottoTickets(lottoTickets, price));
    }

}
