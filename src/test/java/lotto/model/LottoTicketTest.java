package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static lotto.model.LottoTest.ofLotto;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {

    @DisplayName("1등 1개, 2등 1개의 로또티켓의 당첨결과를 반환한다")
    @Test
    void getResult() {
        WinningLotto winningLotto = WinningLotto.of(
                ofLotto(1, 2, 3, 4, 5, 6),
                Number.of(7));

        List<Lotto> lottos = Arrays.asList(
                ofLotto(1, 2, 3, 4, 5, 6),
                ofLotto(1, 2, 3, 4, 5, 7)
        );
        LottoTicket lottoTicket = LottoTicket.of(lottos);


        LottoResult lottoResult = lottoTicket.result(winningLotto);

        assertThat(lottoResult.countOfPrize(Prize.FIRST)).isEqualTo(1);
        assertThat(lottoResult.countOfPrize(Prize.SECOND)).isEqualTo(1);
    }

    @DisplayName("1개 로또를 가진 로또 티켓으로 생성한다")
    @Test
    void createTicket() {
        List<Lotto> lottos = Arrays.asList(ofLotto(1, 2, 3, 4, 5, 6));
        LottoTicket lottoTicket = LottoTicket.of(lottos);
        assertThat(lottoTicket.getLottos()).hasSize(1);
    }

    @DisplayName("2개 로또를 가진 로또 티켓으로 생성한다")
    @Test
    void createTicketByManyLotto() {
        List<Lotto> lottos = Arrays.asList(
                ofLotto(1, 2, 3, 4, 5, 6),
                ofLotto(1, 2, 3, 4, 5, 7));

        LottoTicket lottoTicket = LottoTicket.of(lottos);
        assertThat(lottoTicket.getLottos()).hasSize(2);
    }
}