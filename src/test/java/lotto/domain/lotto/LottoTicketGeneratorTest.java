package lotto.domain.lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketGeneratorTest {

    @Test
    void lottoTicketGeneratorTest() {
        List<LottoNumber> lottoNumbers = LottoTicketGenerator.makeLottoTicket();
        lottoNumbers.stream().forEach(lottoNumber -> assertThat(lottoNumber.getValue()).isBetween(1, 45));
    }
}
