package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class LottoTicketTest {

    private List<LottoNumber> lottoNumbers;

    @BeforeEach
    public void setUp() {
        lottoNumbers = List.of(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)
        );
    }

    @Test
    void 로또_티켓은_6개의_숫자를_가져야한다() {
        // given
        LottoTicket lottoTicket = new LottoTicket(lottoNumbers);

        //then
        assertThat(lottoTicket.getTicketSize()).isEqualTo(6);
    }

    @Test
    void 보너스_당첨번호를_구한다() {
        //given
        boolean expected = true;
        LottoNumber bonusNumber = new LottoNumber(3);

        LottoTicket lottoTicket = LottoTicket.createManualLotto(lottoNumbers);
        //when
        boolean actual = lottoTicket.hasBonusNumber(bonusNumber);

        //then
        assertThat(actual).isEqualTo(expected);
    }
}
