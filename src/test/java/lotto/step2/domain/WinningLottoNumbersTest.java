package lotto.step2.domain;

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
        List<LottoNumber> lottoTicket = LottoTicketTest.LOTTO_TICKET.lottoTicketInformation().getLottoTicket();
        lottoTicket.set(0, LottoNumberTest.THIRTY);
        boolean isExistBonusNumber = WINNING_LOTTO_NUMBERS.isExistBonusLottoNumber(lottoTicket);
        assertThat(isExistBonusNumber).isTrue();
    }
}