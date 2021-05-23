package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

public class LottoTicketGeneratorTest {

    @Test
    @DisplayName("로또 티켓 생성 테스트")
    void generateLottoTicket() {
        assertThat(new LottoTicketGenerator().generate()).isNotNull();
    }

    @Test
    @DisplayName("로또 티켓 입력하여 생성 테스트")
    void generateLottoTicket_shouldBeSameInput() {
        Set<Integer> lottoNumbers = new HashSet<>();
        for(int i = 1; i <= 6; i++) {
            lottoNumbers.add(i);
        }

        // 생성된 lottoTicket은 NULL이 될 수 없다.
        assertThat(new LottoTicketGenerator().generate(lottoNumbers)).isNotNull();
    }
}
