package lotto.step2.domain;

import lotto.step2fixture.domain.LottoNumberFixture;
import lotto.step2fixture.dto.LottoTicketDTOFixture;
import lotto.step2fixture.domain.LottoTicketFixture;
import lotto.step2fixture.domain.WinningLottoNumbersFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class WinningLottoNumbersTest {
    @Test
    @DisplayName("WinningLottoNumbers 객체 생성")
    void create() {
        assertThat(WinningLottoNumbersFixture.WINNING_LOTTO_NUMBERS).isNotNull();
    }
    
    @Test
    @DisplayName("보너스 로또 번호 존재 여부")
    void is_exist_bonus_lotto_number() {
        List<LottoNumber> lottoTicket = Arrays.asList(LottoNumberFixture.ONE, LottoNumberFixture.TWO, LottoNumberFixture.THREE, LottoNumberFixture.FOUR, LottoNumberFixture.FIVE, LottoNumberFixture.THIRTY);
        boolean isExistBonusNumber = WinningLottoNumbersFixture.WINNING_LOTTO_NUMBERS.isExistBonusLottoNumber(lottoTicket);
        
        assertThat(isExistBonusNumber).isTrue();
    }
    
    @Test
    @DisplayName("일치 번호 개수")
    void count_matching_number() {
        List<LottoNumber> lottoNumbers = LottoTicketDTOFixture.LOTTO_TICKET_DTO.getLottoTicket();
        int countMatchingNumber = WinningLottoNumbersFixture.WINNING_LOTTO_NUMBERS.countMatchingNumber(lottoNumbers);
    
        assertThat(countMatchingNumber).isEqualTo(6);
    }
    
    @Test
    @DisplayName("로또 당첨번호를 보너스 번호로 입력 시 예외")
    void bonus_number_exception() {
        List<LottoNumber> lottoTicket = LottoTicketFixture.LOTTO_TICKET.lottoTicketInformation().getLottoTicket();
        assertThatIllegalArgumentException().isThrownBy(() -> new WinningLottoNumbers(lottoTicket, LottoNumberFixture.SIX))
                .withMessage("입력하신 보너스 번호는 이미 존재하는 당첨 번호 입니다. 다시 입력해주세요.");
    }
}