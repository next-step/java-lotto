package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketsTest {

    @DisplayName("constructor test")
    @Test
    void initTest() {
        List<Lotto> Lottos = new ArrayList<Lotto>(){{
            add(new Lotto(Arrays.asList(1,2,3,4,5,6)));
            add(new Lotto(Arrays.asList(6,7,8,9,10,11)));
        }};
        LottoTickets lottoTickets = new LottoTickets(Lottos);
        assertThat(lottoTickets.getLottoTickets()).isEqualTo(Lottos);
    }

}