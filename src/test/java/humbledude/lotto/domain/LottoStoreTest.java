package humbledude.lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoStoreTest {

    @Test
    public void buyAutoTickets() {
        long budget = 14_023;
        LottoStore store = new LottoStore();
        List<LottoTicket> lottoTicketList = store.buyAutoTickets(budget);

        assertThat(lottoTicketList).hasSize(14);
    }

    @Test
    public void howManyCanIBuy() {
        long budget = 14_023;
        LottoStore store = new LottoStore();

        assertThat(store.howManyCanIBuy(budget)).isEqualTo(14);
    }

    @ParameterizedTest
    @CsvSource({"1;2;3;4;5;6,2000000000", "1;2;3;4;5;45,1500000", "1;2;3;4;44;45,50000", "1;2;3;43;44;45,5000", "1;2;42;43;44;45,0"})
    public void claimPrize(String numbers, int expetedPrize) {
        Set<Integer> testcaseNumbers = Stream.of(numbers.split(";"))
                .map(Integer::valueOf)
                .collect(Collectors.toSet());

        LottoTicket myTicket = new LottoTicket(LottoNumbers.of(testcaseNumbers));
        LottoWinningNumbers winningNumbers = new LottoWinningNumbers(LottoNumbers.of(1, 2, 3, 4, 5, 6));

        LottoStore store = new LottoStore();
        store.setWinningNumbers(winningNumbers);

        assertThat(store.claimPrize(myTicket).getPrize()).isEqualTo(expetedPrize);
    }

    @Test
    public void claimPrizeForMultipleTickets() {
        // 1등 + 2등 + 3등 + 꽝
        List<LottoTicket> tickets = Stream.of(
                LottoNumbers.of(1, 2, 3, 4, 5, 6),
                LottoNumbers.of(1, 2, 3, 4, 5, 45),
                LottoNumbers.of(1, 2, 3, 4, 44, 45),
                LottoNumbers.of(40, 41, 42, 43, 44, 45))
                .map(LottoTicket::new)
                .collect(Collectors.toList());

        LottoWinningNumbers winningNumbers = new LottoWinningNumbers(LottoNumbers.of(1, 2, 3, 4, 5, 6));

        LottoStore store = new LottoStore();
        store.setWinningNumbers(winningNumbers);

        Map<LottoPrize, List<LottoTicket>> result = store.claimPrizeForMultipleTickets(tickets);

        assertThat(result.get(LottoPrize.FIRST)).hasSize(1);
        assertThat(result.get(LottoPrize.SECOND)).hasSize(1);
        assertThat(result.get(LottoPrize.THIRD)).hasSize(1);
        assertThat(result.get(LottoPrize.BLANK)).hasSize(1);
    }
}
