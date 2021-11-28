package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.domain.LottoTickets;
import lotto.domain.Money;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LottoTicketBoothTest {

    private LottoTicketBooth lottoTicketBooth;

    @BeforeEach
    void setUp() {
        lottoTicketBooth = LottoTicketBooth.getInstance();
    }

    @Test
    void 로또자동생성() {
        Money money = Money.of(10000, 0);
        assertThat(lottoTicketBooth.generate(money)).isInstanceOf(LottoTickets.class);
    }

    @Test
    void 로또수동생성() {
        List<String> manualLottoNumbers = new ArrayList<>(Arrays.asList("1, 2, 3, 4, 5, 6", "10, 1, 23, 45, 44, 32"));
        assertThat(lottoTicketBooth.generate(manualLottoNumbers)).isInstanceOf(LottoTickets.class);
    }

}
