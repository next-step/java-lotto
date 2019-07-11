package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;
import lotto.strategy.LottoOrderedStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoTest {
    private static final int INPUT_PRICE_PURCHASED = 3000;
    private Lotto lotto;
    private LottoTicket ticket;
    private LottoTickets tickets;
    private List<Integer> orderedNumbers;

    @BeforeEach
    void setUp() {
        orderedNumbers = new LottoOrderedStrategy().generate();
        lotto = new Lotto(INPUT_PRICE_PURCHASED);
        ticket = new LottoTicket(orderedNumbers);
        tickets = lotto.generate(3, new LottoOrderedStrategy());
    }

    @Test
    void 구입금액만큼_로또를_발급받는다() {
        assertThat(tickets.size()).isEqualTo(3);
    }

    @Test
    void 발급한_로또는_숫자가_6개다() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new LottoTicket(Arrays.asList(1, 2, 3, 4, 5));
        });
    }
}
