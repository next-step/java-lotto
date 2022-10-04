package lotto.step2.domain;

import lotto.step2.dto.LottoTicketDTOTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinningLottoNumbersTest {
    public static final WinningLottoNumbers WINNING_LOTTO_NUMBERS = new WinningLottoNumbers(Arrays.asList(LottoNumberTest.ONE, LottoNumberTest.TWO, LottoNumberTest.THREE, LottoNumberTest.FOUR, LottoNumberTest.FIVE, LottoNumberTest.SIX), LottoNumberTest.THIRTY);
    
    @Test
    @DisplayName("WinningLottoNumbers 객체 생성")
    void create() {
        assertThat(WINNING_LOTTO_NUMBERS).isNotNull();
    }
    
    @Test
    @DisplayName("보너스 로또 번호 존재 여부")
    void is_exist_bonus_lotto_number() {
        List<LottoNumber> lottoTicket = Arrays.asList(LottoNumberTest.ONE, LottoNumberTest.TWO, LottoNumberTest.THREE, LottoNumberTest.FOUR, LottoNumberTest.FIVE, LottoNumberTest.THIRTY);
        boolean isExistBonusNumber = WINNING_LOTTO_NUMBERS.isExistBonusLottoNumber(lottoTicket);
        
        assertThat(isExistBonusNumber).isTrue();
    }
    
    @Test
    @DisplayName("일치 번호 개수")
    void count_matching_number() {
        List<LottoNumber> lottoNumbers = LottoTicketDTOTest.LOTTO_TICKET_DTO.getLottoTicket();
        int countMatchingNumber = WINNING_LOTTO_NUMBERS.countMatchingNumber(lottoNumbers);
    
        assertThat(countMatchingNumber).isEqualTo(6);
    }
}