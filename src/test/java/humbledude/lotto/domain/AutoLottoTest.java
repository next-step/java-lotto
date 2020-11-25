package humbledude.lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class AutoLottoTest {

    @Test
    public void autoLotto() {
        LottoNumbers ticket = AutoLotto.buildTicket();

        assertThat(ticket.getNumbers())
                .isInstanceOf(Set.class)
                .hasSize(6)
                .allSatisfy(n -> assertThat(n.getNumber()).isBetween(1, 45));
    }

    @Test
    public void autoLotto1() {
        LottoNumbers ticket = AutoLotto.buildTicket();

        ticket.getNumbers().add(LottoNumber.of(2));

        ticket.getNumbers().stream()
                .forEach(x -> System.out.println(x.getNumber()));
    }

}
