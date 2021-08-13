package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class ManualLottoTicketGeneratorTests {

    @Test
    @DisplayName("수동 로또 티켓 생성 테스트")
    void manualLottoTicketGeneratorTests() {
        LottoTicketGenerator manualLottoGenerator = new ManualLottoTicketGenerator(Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThat(manualLottoGenerator.execute()).isEqualTo(LottoTicket.of(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }
}
