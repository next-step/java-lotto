package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketsTest {

    @DisplayName("constructor test")
    @Test
    void initTest() {
        //  TODO: 팩토리 메소드를 만드려다보니 너무 지저분해짐. 나중에 해결필
        List<Lotto> playersLottos = new ArrayList<Lotto>(){{
            add(Lotto.of(LottoFactory.createListOfLottoNumber(new int[]{1,2,3,4,5,6})
            ));
            add(Lotto.of(LottoFactory.createListOfLottoNumber(new int[]{1,2,3,4,5,6})
            ));
        }};
        LottoTickets lottoTickets = LottoTickets.of(playersLottos);
        LottoMatcher lottoMatcher = new LottoMatcher();
        assertThat(lottoTickets.getLottoTickets()).isEqualTo(playersLottos);
    }

}