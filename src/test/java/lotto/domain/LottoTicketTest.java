package lotto.domain;

import lotto.domain.LottoTicket;
import lotto.utils.LottoRandomNumberUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {

    @Test
    @DisplayName("로또 티켓 생성")
    public void create() throws Exception {
        List<Integer> lottoNumbers = LottoRandomNumberUtil.lottoNumbers();
        LottoTicket lottoTicket = new LottoTicket(new LottoNumbers(lottoNumbers));
        assertThat(lottoTicket).isEqualTo(new LottoTicket(new LottoNumbers(lottoNumbers)));
    }
}
