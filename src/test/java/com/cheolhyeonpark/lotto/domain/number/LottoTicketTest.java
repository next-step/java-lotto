package com.cheolhyeonpark.lotto.domain.number;

import com.cheolhyeonpark.lotto.domain.LottoResult;
import com.cheolhyeonpark.lotto.domain.Rank;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LottoTicketTest {

    @Test
    public void getResult() {
        LottoTicket ticket = new LottoTicket();
        ticket.addNumbers(new Numbers("1, 2, 3, 4, 5, 7"));

        LottoResult result =
                ticket.getResult(new WinningNumbers(new Numbers("1, 2, 3, 4, 5, 6"), new Number(7)));

        assertThat(result.getCount(Rank.SECOND)).isEqualTo(1);
    }

    @Test
    public void size() {
        LottoTicket ticket = new LottoTicket();
        ticket.addNumbers(new Numbers("1, 2, 3, 4, 5, 7"));

        int result = ticket.size();

        assertThat(result).isEqualTo(1);
    }

    @Test
    public void getNumbers() {
        LottoTicket ticket = new LottoTicket();
        Numbers input = new Numbers("1, 2, 3, 4, 5, 7");
        ticket.addNumbers(input);

        Numbers result = ticket.getNumbers(0);

        assertThat(result.countSameNumbersAs(input)).isEqualTo(6);
    }
}