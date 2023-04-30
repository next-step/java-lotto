package lotto;

import lotto.domain.LottoGenerator;
import lotto.domain.LottoTickets;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGeneratorTest {
    @DisplayName("구입 금액에 해당하는 로또번호(자동)을 발급한다")
    @Test
    void generate() {
        LottoTickets lottoTickets = LottoGenerator.generate(3);
        assertThat(lottoTickets.size()).isEqualTo(3);
    }
}
