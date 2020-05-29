package lotto.domain.lotto;

import lotto.domain.generator.LottoNumberGenerator;
import lotto.domain.number.LottoNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("LottoTicket 클래스 테스트")
public class LottoTicketTest {

    @DisplayName("입력받은 갯수 만큼 LottoTicket을 생성할 수 있다.")
    @Test
    void createLottoTicket() {
        int lottoCount = 3;
        LottoTicket lottoTicket = new LottoTicket(lottoCount, new LottoNumberGenerator());

        assertAll(
                () -> assertThat(lottoTicket.getLottoNumbers()).hasSize(3),
                () -> assertThat(lottoTicket.getLottoNumbers().get(0).getClass()).isEqualTo(LottoNumbers.class)
        );
    }
}
