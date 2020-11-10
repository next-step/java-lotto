package humbledude.lotto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoStoreTest {

    @Test
    public void buyAutoTickets() {
        int budget = 14_023;
        LottoStore store = new LottoStore();
        List<LottoTicket> lottoTicketList = store.buyAutoTickets(budget);

        assertThat(lottoTicketList).hasSize(14);
    }

    @ParameterizedTest
    @CsvSource({"1;2;3;4;5;6,2000000000", "1;2;3;4;5;45,1500000", "1;2;3;4;44;45,50000", "1;2;3;43;44;45,5000", "1;2;42;43;44;45,0"})
    public void claimReward(String numbers, int expetedPrize) {
        Set<Integer> testcaseNumbers = Stream.of(numbers.split(";"))
                .map(Integer::valueOf)
                .collect(Collectors.toSet());

        LottoTicket myTicket = new LottoTicket(LottoNumbers.of(testcaseNumbers));
        LottoWinningNumbers winningNumbers = new LottoWinningNumbers(LottoNumbers.of(1, 2, 3, 4, 5, 6));

        LottoStore store = new LottoStore();
        store.setWinningNumbers(winningNumbers);

        assertThat(store.claimPrize(myTicket)).isEqualTo(expetedPrize);
    }
}
