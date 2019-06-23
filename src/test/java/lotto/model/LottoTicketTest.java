package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static lotto.model.LottoTest.ofLotto;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {

    @DisplayName("한개 로또를 로또 티켓으로 생성")
    @Test
    void createTicket() {
        List<Lotto> lottos = Arrays.asList(ofLotto(1, 2, 3, 4, 5, 6));
        LottoTicket lottoTicket = LottoTicket.of(lottos);
        assertThat(lottoTicket.getLottos()).hasSize(1);
    }

    @DisplayName("2개 로또를 로또 티켓으로 생성")
    @Test
    void createTicketByManyLotto() {
        List<Lotto> lottos = Arrays.asList(ofLotto(1, 2, 3, 4, 5, 6),
                            ofLotto(1, 2, 3, 4, 5, 7));
        LottoTicket lottoTicket = LottoTicket.of(lottos);
        assertThat(lottoTicket.getLottos()).hasSize(2);
    }
}
