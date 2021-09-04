package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {

    @DisplayName("내가 구매한 복권이 2등인지 확인할 수 있다.")
    @Test
    void matchTest() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto("1,2,3,4,5,6"));
        LottoTicket lottoTicket = new LottoTicket(lottos);
        Lotto lastWinningLotto = new Lotto("1,2,3,4,5,7");
        LottoRank second = LottoRank.SECOND;
        int expected = 1;

        LottoResult lottoResult = lottoTicket.matchWinning(lastWinningLotto);
        int actual = lottoResult.getMatchCount(second);

        assertThat(actual).isEqualTo(expected);
    }
}
