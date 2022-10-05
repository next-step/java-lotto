package lotto.step2.domain;

import lotto.step2fixture.domain.LottoNumberFixture;
import lotto.step2fixture.domain.LottoTicketFixture;
import lotto.step2fixture.domain.WinningLottoNumbersFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {
    @Test
    @DisplayName("로또 티켓 한 장 생성")
    void create() {
        assertThat(LottoTicketFixture.LOTTO_TICKET).isNotNull();
    }
    
    @Test
    @DisplayName("보너스 로또 번호 일치 확인")
    void confirm_bonus_number_match() {
        List<LottoNumber> winningLottoNumbersList = Arrays.asList(LottoNumberFixture.ONE, LottoNumberFixture.TWO, LottoNumberFixture.THREE, LottoNumberFixture.FOUR, LottoNumberFixture.FIVE, new LottoNumber(7));
        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers(winningLottoNumbersList, LottoNumberFixture.SIX);
        boolean isExistBonusLottoNumber = LottoTicketFixture.LOTTO_TICKET.isExistBonusLottoNumber(winningLottoNumbers);
        
        assertThat(isExistBonusLottoNumber).isTrue();
    }
    
    @Test
    @DisplayName("로또 번호 6개 일치 확인")
    void confirm_six_number_match() {
        int countMatchingNumber = LottoTicketFixture.LOTTO_TICKET.countMatchingNumber(WinningLottoNumbersFixture.WINNING_LOTTO_NUMBERS);
        boolean isExistBonusLottoNumber = LottoTicketFixture.LOTTO_TICKET.isExistBonusLottoNumber(WinningLottoNumbersFixture.WINNING_LOTTO_NUMBERS);
        LottoRank lottoRank = LottoRank.valueOf(countMatchingNumber, isExistBonusLottoNumber);
        
        assertThat(lottoRank).isEqualTo(LottoRank.FIRST);
    }
    
    @Test
    @DisplayName("로또 번호 5개, 보너스 번호 일치 확인")
    void confirm_five_number_and_bonus_number_match() {
        List<LottoNumber> winningLottoNumbersList = Arrays.asList(LottoNumberFixture.ONE, LottoNumberFixture.TWO, LottoNumberFixture.THREE, LottoNumberFixture.FOUR, LottoNumberFixture.FIVE, new LottoNumber(7));
        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers(winningLottoNumbersList, LottoNumberFixture.SIX);
        int countOfMatchNumber = LottoTicketFixture.LOTTO_TICKET.countMatchingNumber(winningLottoNumbers);
        boolean isExistBonusLottoNumber = LottoTicketFixture.LOTTO_TICKET.isExistBonusLottoNumber(winningLottoNumbers);
        LottoRank lottoRank = LottoRank.valueOf(countOfMatchNumber, isExistBonusLottoNumber);
        
        assertThat(lottoRank).isEqualTo(LottoRank.SECOND);
    }
    
    @Test
    @DisplayName("로또 번호 5개 일치 확인")
    void confirm_five_number_match() {
        List<LottoNumber> winningLottoNumbersList = Arrays.asList(LottoNumberFixture.ONE, LottoNumberFixture.TWO, LottoNumberFixture.THREE, LottoNumberFixture.FOUR, LottoNumberFixture.FIVE, new LottoNumber(7));
        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers(winningLottoNumbersList, LottoNumberFixture.THIRTY);
        int countOfMatchNumber = LottoTicketFixture.LOTTO_TICKET.countMatchingNumber(winningLottoNumbers);
        boolean isExistBonusLottoNumber = LottoTicketFixture.LOTTO_TICKET.isExistBonusLottoNumber(winningLottoNumbers);
        LottoRank lottoRank = LottoRank.valueOf(countOfMatchNumber, isExistBonusLottoNumber);
        
        assertThat(lottoRank).isEqualTo(LottoRank.THIRD);
    }
    
    @Test
    @DisplayName("로또 번호 4개 일치 확인")
    void confirm_four_number_match() {
        List<LottoNumber> winningLottoNumbersList = Arrays.asList(LottoNumberFixture.ONE, LottoNumberFixture.TWO, LottoNumberFixture.THREE, LottoNumberFixture.FOUR, new LottoNumber(7), new LottoNumber(8));
        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers(winningLottoNumbersList, LottoNumberFixture.THIRTY);
        int countOfMatchNumber = LottoTicketFixture.LOTTO_TICKET.countMatchingNumber(winningLottoNumbers);
        boolean isExistBonusLottoNumber = LottoTicketFixture.LOTTO_TICKET.isExistBonusLottoNumber(winningLottoNumbers);
        LottoRank lottoRank = LottoRank.valueOf(countOfMatchNumber, isExistBonusLottoNumber);
        
        assertThat(lottoRank).isEqualTo(LottoRank.FOURTH);
    }
    
    @Test
    @DisplayName("로또 번호 3개 일치 확인")
    void confirm_three_number_match() {
        List<LottoNumber> winningLottoNumbersList = Arrays.asList(LottoNumberFixture.ONE, LottoNumberFixture.TWO, LottoNumberFixture.THREE, new LottoNumber(7), new LottoNumber(8), new LottoNumber(9));
        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers(winningLottoNumbersList, LottoNumberFixture.THIRTY);
        int countOfMatchNumber = LottoTicketFixture.LOTTO_TICKET.countMatchingNumber(winningLottoNumbers);
        boolean isExistBonusLottoNumber = LottoTicketFixture.LOTTO_TICKET.isExistBonusLottoNumber(winningLottoNumbers);
        LottoRank lottoRank = LottoRank.valueOf(countOfMatchNumber, isExistBonusLottoNumber);
        
        assertThat(lottoRank).isEqualTo(LottoRank.FIFTH);
    }
    
    @Test
    @DisplayName("로또 번호 2개 일치 확인")
    void confirm_two_number_match() {
        List<LottoNumber> winningLottoNumbersList = Arrays.asList(LottoNumberFixture.ONE, LottoNumberFixture.TWO, new LottoNumber(7), new LottoNumber(8), new LottoNumber(9), new LottoNumber(10));
        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers(winningLottoNumbersList, LottoNumberFixture.THIRTY);
        int countOfMatchNumber = LottoTicketFixture.LOTTO_TICKET.countMatchingNumber(winningLottoNumbers);
        boolean isExistBonusLottoNumber = LottoTicketFixture.LOTTO_TICKET.isExistBonusLottoNumber(winningLottoNumbers);
        LottoRank lottoRank = LottoRank.valueOf(countOfMatchNumber, isExistBonusLottoNumber);
        
        assertThat(lottoRank).isEqualTo(LottoRank.MISS);
    }
    
    @Test
    @DisplayName("로또 번호 1개 일치 확인")
    void confirm_one_number_match() {
        List<LottoNumber> winningLottoNumbersList = Arrays.asList(LottoNumberFixture.ONE, new LottoNumber(7), new LottoNumber(8), new LottoNumber(9), new LottoNumber(10), new LottoNumber(11));
        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers(winningLottoNumbersList, LottoNumberFixture.THIRTY);
        int countOfMatchNumber = LottoTicketFixture.LOTTO_TICKET.countMatchingNumber(winningLottoNumbers);
        boolean isExistBonusLottoNumber = LottoTicketFixture.LOTTO_TICKET.isExistBonusLottoNumber(winningLottoNumbers);
        LottoRank lottoRank = LottoRank.valueOf(countOfMatchNumber, isExistBonusLottoNumber);
        
        assertThat(lottoRank).isEqualTo(LottoRank.MISS);
    }
    
    @Test
    @DisplayName("로또 번호 0개 일치 확인")
    void confirm_zero_number_match() {
        List<LottoNumber> winningLottoNumbersList = Arrays.asList(new LottoNumber(7), new LottoNumber(8), new LottoNumber(9), new LottoNumber(10), new LottoNumber(11), new LottoNumber(12));
        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers(winningLottoNumbersList, LottoNumberFixture.THIRTY);
        int countOfMatchNumber = LottoTicketFixture.LOTTO_TICKET.countMatchingNumber(winningLottoNumbers);
        boolean isExistBonusLottoNumber = LottoTicketFixture.LOTTO_TICKET.isExistBonusLottoNumber(winningLottoNumbers);
        LottoRank lottoRank = LottoRank.valueOf(countOfMatchNumber, isExistBonusLottoNumber);
        
        assertThat(lottoRank).isEqualTo(LottoRank.MISS);
    }
}