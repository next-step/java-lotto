package Lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTicketTest {

    @Test
    @DisplayName("로또번호는 6자리의 번호로 이루어져야 한다.")
    void validateLottoSizeTest() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int i = 1; i < 8; i++) {
            lottoNumbers.add(new LottoNumber(i));
        }

        assertThatThrownBy(() -> new LottoTicket(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 6자리여야 합니다.");
    }

    @Test
    @DisplayName("로또 번호는 중복번호가 될 수 없습니다.")
    void DuplicationLottoNumberTest() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            lottoNumbers.add(new LottoNumber(i));
        }
        lottoNumbers.add(new LottoNumber(1));

        assertThatThrownBy(() -> new LottoTicket(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 중복이 될 수 없습니다.");
    }

}
