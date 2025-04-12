package lotto.domain.service;

import lotto.domain.generator.LottoTicketGenerator;
import lotto.domain.generator.StaticLottoTicketGenerator;
import lotto.domain.model.LottoNumber;
import lotto.domain.model.LottoRequest;
import lotto.domain.model.LottoTicket;
import lotto.domain.model.LottoWallet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {
    @DisplayName("수동/자동 요청에 따라 로또를 구매한다.")
    @Test
    void buyTest() {
        LottoTicketGenerator lottoTicketGenerator = new StaticLottoTicketGenerator(List.of(1, 2, 3, 4, 5, 6));
        LottoRequest request = new LottoRequest(3000);
        request.addRequest(List.of(1, 2, 3, 4, 5, 6));

        LottoWallet lottoWallet = LottoMachine.buy(lottoTicketGenerator, request);
        List<LottoTicket> lottos = lottoWallet.getLottos();
        assertThat(lottos).hasSize(3);
        assertThat(lottos.get(0).getNumbers()).containsExactlyInAnyOrder(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)
        );
    }
}
