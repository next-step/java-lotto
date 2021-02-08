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

        List<Lotto> playersLottos = Arrays.asList(
                LottoFactory.createLotto(Arrays.asList(1,2,3,4,5,6)),
                LottoFactory.createLotto(Arrays.asList(1,2,3,4,5,7))
                );
        LottoTickets lottoTickets = LottoTickets.of(playersLottos);
        assertThat(lottoTickets.getLottoTickets()).isEqualTo(playersLottos);
    }

}