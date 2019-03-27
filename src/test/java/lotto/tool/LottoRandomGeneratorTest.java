package lotto.tool;

import lotto.domain.LottoTicket;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoRandomGeneratorTest {

    @Test
    public void 자동생성하기() {
        LottoGenerator lottoRandomGenerator = new LottoRandomGenerator(3);
        List<LottoTicket> lottoTickets = lottoRandomGenerator.generate();
        assertThat(lottoTickets.size()).isEqualTo(3);
    }
}