package lotto.generator;

import lotto.domain.LottoTicket;
import lotto.domain.generator.LottoNumberRandomGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberRandomGeneratorTest {
    @Test
    @DisplayName("생성한 로또번호의 개수는 LottoTicket에 정의된 개수와 같아야 한다.")
    public void 생성한_로또번호의_개수는_LottoTicket에_정의된_개수와_같아야_한다() {
        assertThat(new LottoNumberRandomGenerator().generate())
                .hasSize(LottoTicket.LOTTO_NUMBERS_SIZE);
    }
}
