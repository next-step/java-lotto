package step5.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.Lotto;

import static org.junit.jupiter.api.Assertions.*;

class LottoTicketTest {
    @DisplayName("로또 번호 개수 확인 : 7개의 로또 번호 (에러)")
    @Test
    void sevenLotto() {
        String lottoNumbers = "1, 2, 3, 4, 5, 6, 7";
        Assertions.assertThatThrownBy(() -> {
            new LottoTicket(lottoNumbers);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호 개수 확인 : 5개의 로또 번호 (에러)")
    @Test
    void fiveLotto() {
        String lottoNumbers = "1, 2, 3, 4, 5";
        Assertions.assertThatThrownBy(() -> {
            new LottoTicket(lottoNumbers);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호 개수 확인 : 7개의 로또 번호 (정상)")
    @Test
    void sixLotto() {
        String lottoNumbers = "1, 2, 3, 4, 5, 6";
        LottoTicket lottoTicket = new LottoTicket(lottoNumbers);
    }
}