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
            add(new Lotto(Arrays.asList(new LottoNumber(1),
                    new LottoNumber(2),
                    new LottoNumber(3),
                    new LottoNumber(4),
                    new LottoNumber(5),
                    new LottoNumber(6)
            )));
            add(new Lotto(Arrays.asList(new LottoNumber(7),
                    new LottoNumber(8),
                    new LottoNumber(9),
                    new LottoNumber(10),
                    new LottoNumber(11),
                    new LottoNumber(12)
            )));
        }};
        LottoTickets lottoTickets = new LottoTickets(Lottos);
        assertThat(lottoTickets.getLottoTickets()).isEqualTo(Lottos);
    }

}