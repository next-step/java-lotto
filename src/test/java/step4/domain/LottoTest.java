package step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.controller.LottoTicketMaker;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    @DisplayName("로또 갯수 대로 입력되는지")
    public void 로또_갯수_대로_입력되는지() {
        int manualLottoQty = 1;

        List<Lotto> manualLottoNumbers = new ArrayList<>();

        Lotto lotto = new Lotto();
        lotto.getLottos().clear();
        IntStream.of(1, 2, 3, 7, 8, 9)
                .forEach(i -> lotto.getLottos().add(i));

        manualLottoNumbers.add(lotto);

        LottoTicketMaker lottoTicketMaker = LottoTicketMaker.of(14000, manualLottoQty, manualLottoNumbers);
        Lottos lottos = lottoTicketMaker.getLottoTicket();

        assertThat(lottos.getLottos().size()).isEqualTo(14);
    }
}
