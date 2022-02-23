package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;

class LottoMachineTest {
    public static final String DELIMITER = ",";

    @DisplayName("구매 금액만큼 로또를 구매한다")
    @Test
    void 로또_구매_개수() {
        Ticket ticket = Ticket.of(5000, 0);
        Lottos lottos = LottoMachine.purchase(ticket, new ArrayList<>());

        assertThat(lottos.get()).hasSize(5);
    }

    @DisplayName("정해진 숫자만큼 수동 로또와 자동 로또를 구매한다")
    @Test
    void 수동_로또_확인() {
        Ticket ticket = Ticket.of(5000, 2);
        String[] manualNumbers1 = "1,2,3,4,5,6".split(DELIMITER);
        String[] manualNumbers2 = "11,12,13,14,15,16".split(DELIMITER);

        List<String[]> manualLottos = Arrays.asList(
                manualNumbers1,
                manualNumbers2
        );

        Lottos lottos = LottoMachine.purchase(ticket, manualLottos);

        Lotto manualLotto1 = Lotto.from(manualNumbers1);
        Lotto manualLotto2 = Lotto.from(manualNumbers2);

        assertThat(lottos.get().get(0).getLottoNumbers())
                .isEqualTo(manualLotto1.getLottoNumbers());

        assertThat(lottos.get().get(1).getLottoNumbers())
                .isEqualTo(manualLotto2.getLottoNumbers());
    }

}
