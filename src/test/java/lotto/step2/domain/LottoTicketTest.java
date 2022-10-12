package lotto.step2.domain;

import lotto.step2fixture.domain.LottoNumberFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {
    public static final LottoTicket LOTTO_TICKET = new LottoTicket(Arrays.asList(LottoNumberFixture.ONE, LottoNumberFixture.TWO, LottoNumberFixture.THREE, LottoNumberFixture.FOUR, LottoNumberFixture.FIVE, LottoNumberFixture.SIX));
    
    @Test
    @DisplayName("로또 티켓 한 장 생성")
    void create() {
        assertThat(LottoTicketTest.LOTTO_TICKET).isNotNull();
    }
    
    @Test
    @DisplayName("보너스 로또 번호 일치 확인")
    void confirm_bonus_number_match() {
        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers("1,2,3,4,5,7");
        winningLottoNumbers.inputBonusNumber("6");
        boolean isExistBonusLottoNumber = LottoTicketTest.LOTTO_TICKET.isExistBonusLottoNumber(winningLottoNumbers);
        
        assertThat(isExistBonusLottoNumber).isTrue();
    }
    
    @Test
    @DisplayName("로또 번호 6개 일치 확인")
    void confirm_six_number_match() {
        int countMatchingNumber = LottoTicketTest.LOTTO_TICKET.countMatchingNumber(new WinningLottoNumbersTest().winningLottoNumbers);
        boolean isExistBonusLottoNumber = LottoTicketTest.LOTTO_TICKET.isExistBonusLottoNumber(new WinningLottoNumbersTest().winningLottoNumbers);
        LottoRank lottoRank = LottoRank.valueOf(countMatchingNumber, isExistBonusLottoNumber);
        
        assertThat(lottoRank).isEqualTo(LottoRank.FIRST);
    }
    
    @Test
    @DisplayName("로또 번호 5개, 보너스 번호 일치 확인")
    void confirm_five_number_and_bonus_number_match() {
        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers("1,2,3,4,5,7");
        winningLottoNumbers.inputBonusNumber("6");
        int countOfMatchNumber = LottoTicketTest.LOTTO_TICKET.countMatchingNumber(winningLottoNumbers);
        boolean isExistBonusLottoNumber = LottoTicketTest.LOTTO_TICKET.isExistBonusLottoNumber(winningLottoNumbers);
        LottoRank lottoRank = LottoRank.valueOf(countOfMatchNumber, isExistBonusLottoNumber);
        
        assertThat(lottoRank).isEqualTo(LottoRank.SECOND);
    }
    
    @Test
    @DisplayName("로또 번호 5개 일치 확인")
    void confirm_five_number_match() {
        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers("1,2,3,4,5,7");
        winningLottoNumbers.inputBonusNumber("30");
        int countOfMatchNumber = LottoTicketTest.LOTTO_TICKET.countMatchingNumber(winningLottoNumbers);
        boolean isExistBonusLottoNumber = LottoTicketTest.LOTTO_TICKET.isExistBonusLottoNumber(winningLottoNumbers);
        LottoRank lottoRank = LottoRank.valueOf(countOfMatchNumber, isExistBonusLottoNumber);
        
        assertThat(lottoRank).isEqualTo(LottoRank.THIRD);
    }
    
    @Test
    @DisplayName("로또 번호 4개 일치 확인")
    void confirm_four_number_match() {
        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers("1,2,3,4,7,8");
        winningLottoNumbers.inputBonusNumber("30");
        int countOfMatchNumber = LottoTicketTest.LOTTO_TICKET.countMatchingNumber(winningLottoNumbers);
        boolean isExistBonusLottoNumber = LottoTicketTest.LOTTO_TICKET.isExistBonusLottoNumber(winningLottoNumbers);
        LottoRank lottoRank = LottoRank.valueOf(countOfMatchNumber, isExistBonusLottoNumber);
        
        assertThat(lottoRank).isEqualTo(LottoRank.FOURTH);
    }
    
    @Test
    @DisplayName("로또 번호 3개 일치 확인")
    void confirm_three_number_match() {
        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers("1,2,3,7,8,9");
        winningLottoNumbers.inputBonusNumber("30");
        int countOfMatchNumber = LottoTicketTest.LOTTO_TICKET.countMatchingNumber(winningLottoNumbers);
        boolean isExistBonusLottoNumber = LottoTicketTest.LOTTO_TICKET.isExistBonusLottoNumber(winningLottoNumbers);
        LottoRank lottoRank = LottoRank.valueOf(countOfMatchNumber, isExistBonusLottoNumber);
        
        assertThat(lottoRank).isEqualTo(LottoRank.FIFTH);
    }
    
    @Test
    @DisplayName("로또 번호 2개 일치 확인")
    void confirm_two_number_match() {
        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers("1,2,7,8,9,10");
        winningLottoNumbers.inputBonusNumber("30");
        int countOfMatchNumber = LottoTicketTest.LOTTO_TICKET.countMatchingNumber(winningLottoNumbers);
        boolean isExistBonusLottoNumber = LottoTicketTest.LOTTO_TICKET.isExistBonusLottoNumber(winningLottoNumbers);
        LottoRank lottoRank = LottoRank.valueOf(countOfMatchNumber, isExistBonusLottoNumber);
        
        assertThat(lottoRank).isEqualTo(LottoRank.MISS);
    }
    
    @Test
    @DisplayName("로또 번호 1개 일치 확인")
    void confirm_one_number_match() {
        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers("1,7,8,9,10,11");
        winningLottoNumbers.inputBonusNumber("30");
        int countOfMatchNumber = LottoTicketTest.LOTTO_TICKET.countMatchingNumber(winningLottoNumbers);
        boolean isExistBonusLottoNumber = LottoTicketTest.LOTTO_TICKET.isExistBonusLottoNumber(winningLottoNumbers);
        LottoRank lottoRank = LottoRank.valueOf(countOfMatchNumber, isExistBonusLottoNumber);
        
        assertThat(lottoRank).isEqualTo(LottoRank.MISS);
    }
    
    @Test
    @DisplayName("로또 번호 0개 일치 확인")
    void confirm_zero_number_match() {
        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers("7,8,9,10,11,12");
        winningLottoNumbers.inputBonusNumber("30");
        int countOfMatchNumber = LottoTicketTest.LOTTO_TICKET.countMatchingNumber(winningLottoNumbers);
        boolean isExistBonusLottoNumber = LottoTicketTest.LOTTO_TICKET.isExistBonusLottoNumber(winningLottoNumbers);
        LottoRank lottoRank = LottoRank.valueOf(countOfMatchNumber, isExistBonusLottoNumber);
        
        assertThat(lottoRank).isEqualTo(LottoRank.MISS);
    }
}