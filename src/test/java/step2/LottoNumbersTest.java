package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.LottoNumbers;
import step2.domain.LottoTicket;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

public class LottoNumbersTest {
    @DisplayName("로또번호 생성 확인")
    @Test
    void lott_shuffle() {
        LottoTicket lottoTicket = LottoNumbers.create(1);
        assertThat(lottoTicket.getLottoNumbersList().size()).isEqualTo(1);
    }
}
