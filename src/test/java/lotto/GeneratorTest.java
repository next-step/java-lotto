package lotto;

import lotto.domain.Generator;
import lotto.domain.LottoTicket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GeneratorTest {

    @Test
    @DisplayName("6개의 숫자를 가진 로또를 생성한다")
   public void generate_lotto_ticket() {
        Generator generator = Generator.newGenerator();
        LottoTicket lottoTicket = generator.generateLottoTicket();
        assertThat(lottoTicket.getNumbers().size()).isEqualTo(6);
    }
}
