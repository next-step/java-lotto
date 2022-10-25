package step2.lotto;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketsTest {

    @Test
    void 천원의_배수만큼_로또를_생성한다() {
        int numberOfTickets = 1;
        int lottoPrice = 1000;
        int totalPrice = lottoPrice * numberOfTickets;
        NumbersGenerator numbersGenerator = new NumbersGenerator.Fake(Set.of(1, 2, 3, 4, 5, 6));

        LottoTickets lottoTickets = new LottoTicketsFactory(totalPrice, numbersGenerator).lottoTickets();

        assertThat(lottoTickets.numberOfTickets()).isOne();
    }

    @Test
    void 순위들을_생성할_수_있다() {
        int numberOfTickets = 1;
        int lottoPrice = 1000;
        int totalPrice = lottoPrice * numberOfTickets;
        NumbersGenerator numbersGenerator = new NumbersGenerator.Fake(Set.of(1, 2, 3, 4, 5, 6));

        LottoTickets lottoTickets = new LottoTicketsFactory(totalPrice, numbersGenerator).lottoTickets();

        Set<Integer> winningNumbers = Set.of(1, 2, 3, 4, 5, 6);
        assertThat(lottoTickets.ranks(winningNumbers)).isEqualTo(new Ranks(List.of(Rank.FIRST)));
    }
}
