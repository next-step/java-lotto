package step2.lotto;

import org.junit.jupiter.api.Test;

import java.util.Map;
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

    @Test
    void 로또의_수익률을_구할_수_있다() {
        int numberOfTickets = 1;
        int lottoPrice = 1000;
        int totalPrice = lottoPrice * numberOfTickets;
        NumbersGenerator numbersGenerator = new NumbersGenerator.Fake(Set.of(1, 2, 3, 4, 5, 6));
        LottoTickets lottoTickets = LottoTickets.of(totalPrice, numbersGenerator);

        Set<Integer> winningNumbers = Set.of(1, 2, 3, 4, 5, 6);
        double firstPrizeAmount = 2_000_000_000;
        assertThat(lottoTickets.yield(winningNumbers)).isEqualTo(String.format("%.2f", firstPrizeAmount / totalPrice));
    }

    @Test
    void 로또의_당첨_통계를_구할_수_있다() {
        int numberOfTickets = 1;
        int lottoPrice = 1000;
        int totalPrice = lottoPrice * numberOfTickets;
        NumbersGenerator numbersGenerator = new NumbersGenerator.Fake(Set.of(1, 2, 3, 4, 5, 6));

        LottoTickets lottoTickets = LottoTickets.of(totalPrice, numbersGenerator);

        Set<Integer> winningNumbers = Set.of(1, 2, 3, 4, 5, 6);
        assertThat(lottoTickets.ranks(winningNumbers)).containsExactly(Map.entry(Rank.FIRST, 1L));
    }
}
