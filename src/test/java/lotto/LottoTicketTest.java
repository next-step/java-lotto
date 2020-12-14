package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

class LottoTicketTest {

    @Test
    @DisplayName("로또 티켓 생성 테스트")
    void lotto_ticket_count_test() {
        // given
        Set<LottoNumber> lottoTicket = new HashSet<>();
        lottoTicket.add(LottoNumber.ofNumber(1));
        lottoTicket.add(LottoNumber.ofNumber(2));
        lottoTicket.add(LottoNumber.ofNumber(3));
        lottoTicket.add(LottoNumber.ofNumber(43));
        lottoTicket.add(LottoNumber.ofNumber(44));
        lottoTicket.add(LottoNumber.ofNumber(45));

        // when & then
        assertThat(lottoTicket.size()).isEqualTo(6);
    }

    @Test
    @DisplayName("로또 번호 중복 테스트")
    void invalid_lotto_number_test() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            // given
            Set<LottoNumber> lottoNumbers = new HashSet<>();
            lottoNumbers.add(LottoNumber.ofNumber(1));
            lottoNumbers.add(LottoNumber.ofNumber(1));
            lottoNumbers.add(LottoNumber.ofNumber(3));
            lottoNumbers.add(LottoNumber.ofNumber(43));
            lottoNumbers.add(LottoNumber.ofNumber(44));
            lottoNumbers.add(LottoNumber.ofNumber(45));

            // when & then
            LottoTicket lottoTicket = new LottoTicket(lottoNumbers);

        }).withMessageMatching("로또 넘버 갯수가 중복 되었거나 6개가 아닙니다.");
    }

}
