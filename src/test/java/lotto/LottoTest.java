package lotto;

import org.junit.Test;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    @Test
    public void 로또_0장구매() {
        Lotto lotto = new Lotto(0);
        List<Ticket> tickets = lotto.getTickets();
        assertThat(tickets.size()).isEqualTo(0);
    }

    @Test
    public void 로또_4장구매() {
        Lotto lotto = new Lotto(4);
        List<Ticket> tickets = lotto.getTickets();
        assertThat(tickets.size()).isEqualTo(4);
    }

    @Test
    public void randNum() {
        List<Integer> collect = new Random().ints(10000, 1, 46)
                .boxed()
                .collect(Collectors.toList());
        System.out.println(collect.toString());
        boolean a = collect.stream().anyMatch(integer -> integer.equals(45));
        boolean b = collect.stream().anyMatch(integer -> integer.equals(46));
        assertThat(a).isTrue();
        assertThat(b).isFalse();
    }

}
