package lotto_auto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottoTicketTest {

    @DisplayName("로또 티켓 생성 테스트")
    @Test
    public void createLottoNumberTest() {

        LottoTicket lottoTicket = new LottoTicket();
        LottoNumbers lottoNumbers = lottoTicket.getLottoNumbers();
        List<LottoNumber> export = lottoNumbers.export();
        assertAll(
                () -> assertThat(lottoNumbers).isNotNull(),
                () -> assertThat(export).isNotNull(),
                () -> assertThat(export.size()).isEqualTo(6)
        );
    }

}
