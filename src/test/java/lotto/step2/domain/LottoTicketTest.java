package lotto.step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {
    public static final LottoTicket LOTTO_TICKET = new LottoTicket(Arrays.asList(LottoNumberTest.ONE, LottoNumberTest.TWO, LottoNumberTest.THREE, LottoNumberTest.FOUR, LottoNumberTest.FIVE, LottoNumberTest.SIX));
    
    @Test
    @DisplayName("로또 티켓 한 장 생성")
    void create() {
        assertThat(LOTTO_TICKET).isNotNull();
    }
    
    @Test
    @DisplayName("보너스 로또 번호 일치 확인")
    void confirm_bonus_number_match() {
        List<LottoNumber> winningLottoNumbersList = Arrays.asList(LottoNumberTest.ONE, LottoNumberTest.TWO, LottoNumberTest.THREE, LottoNumberTest.FOUR, LottoNumberTest.FIVE, new LottoNumber(7));
        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers(winningLottoNumbersList, LottoNumberTest.SIX);
        boolean isExistBonusLottoNumber = LOTTO_TICKET.isExistBonusLottoNumber(winningLottoNumbers);
        
        assertThat(isExistBonusLottoNumber).isTrue();
    }
    
    @Test
    @DisplayName("로또 번호 6개 일치 확인")
    void confirm_six_number_match() {
        int countMatchingNumber = LOTTO_TICKET.countMatchingNumber(WinningLottoNumbersTest.WINNING_LOTTO_NUMBERS);
        boolean isExistBonusLottoNumber = LOTTO_TICKET.isExistBonusLottoNumber(WinningLottoNumbersTest.WINNING_LOTTO_NUMBERS);
        LottoRank lottoRank = LottoRank.valueOf(countMatchingNumber, isExistBonusLottoNumber);
        
        assertThat(lottoRank).isEqualTo(LottoRank.FIRST);
    }
    
    @Test
    @DisplayName("로또 번호 5개, 보너스 번호 일치 확인")
    void confirm_five_number_and_bonus_number_match() {
        List<LottoNumber> winningLottoNumbersList = Arrays.asList(LottoNumberTest.ONE, LottoNumberTest.TWO, LottoNumberTest.THREE, LottoNumberTest.FOUR, LottoNumberTest.FIVE, new LottoNumber(7));
        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers(winningLottoNumbersList, LottoNumberTest.SIX);
        int countOfMatchNumber = LOTTO_TICKET.countMatchingNumber(winningLottoNumbers);
        boolean isExistBonusLottoNumber = LOTTO_TICKET.isExistBonusLottoNumber(winningLottoNumbers);
        LottoRank lottoRank = LottoRank.valueOf(countOfMatchNumber, isExistBonusLottoNumber);
        
        assertThat(lottoRank).isEqualTo(LottoRank.SECOND);
    }
    
    @Test
    @DisplayName("로또 번호 5개 일치 확인")
    void confirm_five_number_match() {
        List<LottoNumber> winningLottoNumbersList = Arrays.asList(LottoNumberTest.ONE, LottoNumberTest.TWO, LottoNumberTest.THREE, LottoNumberTest.FOUR, LottoNumberTest.FIVE, new LottoNumber(7));
        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers(winningLottoNumbersList, LottoNumberTest.THIRTY);
        int countOfMatchNumber = LOTTO_TICKET.countMatchingNumber(winningLottoNumbers);
        boolean isExistBonusLottoNumber = LOTTO_TICKET.isExistBonusLottoNumber(winningLottoNumbers);
        LottoRank lottoRank = LottoRank.valueOf(countOfMatchNumber, isExistBonusLottoNumber);
        
        assertThat(lottoRank).isEqualTo(LottoRank.THIRD);
    }
    
    @Test
    @DisplayName("로또 번호 4개 일치 확인")
    void confirm_four_number_match() {
        List<LottoNumber> winningLottoNumbersList = Arrays.asList(LottoNumberTest.ONE, LottoNumberTest.TWO, LottoNumberTest.THREE, LottoNumberTest.FOUR, new LottoNumber(7), new LottoNumber(8));
        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers(winningLottoNumbersList, LottoNumberTest.THIRTY);
        int countOfMatchNumber = LOTTO_TICKET.countMatchingNumber(winningLottoNumbers);
        boolean isExistBonusLottoNumber = LOTTO_TICKET.isExistBonusLottoNumber(winningLottoNumbers);
        LottoRank lottoRank = LottoRank.valueOf(countOfMatchNumber, isExistBonusLottoNumber);
        
        assertThat(lottoRank).isEqualTo(LottoRank.FOURTH);
    }
    
    @Test
    @DisplayName("로또 번호 3개 일치 확인")
    void confirm_three_number_match() {
        List<LottoNumber> winningLottoNumbersList = Arrays.asList(LottoNumberTest.ONE, LottoNumberTest.TWO, LottoNumberTest.THREE, new LottoNumber(7), new LottoNumber(8), new LottoNumber(9));
        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers(winningLottoNumbersList, LottoNumberTest.THIRTY);
        int countOfMatchNumber = LOTTO_TICKET.countMatchingNumber(winningLottoNumbers);
        boolean isExistBonusLottoNumber = LOTTO_TICKET.isExistBonusLottoNumber(winningLottoNumbers);
        LottoRank lottoRank = LottoRank.valueOf(countOfMatchNumber, isExistBonusLottoNumber);
        
        assertThat(lottoRank).isEqualTo(LottoRank.FIFTH);
    }
    
    @Test
    @DisplayName("로또 번호 2개 일치 확인")
    void confirm_two_number_match() {
        List<LottoNumber> winningLottoNumbersList = Arrays.asList(LottoNumberTest.ONE, LottoNumberTest.TWO, new LottoNumber(7), new LottoNumber(8), new LottoNumber(9), new LottoNumber(10));
        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers(winningLottoNumbersList, LottoNumberTest.THIRTY);
        int countOfMatchNumber = LOTTO_TICKET.countMatchingNumber(winningLottoNumbers);
        boolean isExistBonusLottoNumber = LOTTO_TICKET.isExistBonusLottoNumber(winningLottoNumbers);
        LottoRank lottoRank = LottoRank.valueOf(countOfMatchNumber, isExistBonusLottoNumber);
        
        assertThat(lottoRank).isEqualTo(LottoRank.MISS);
    }
    
    @Test
    @DisplayName("로또 번호 1개 일치 확인")
    void confirm_one_number_match() {
        List<LottoNumber> winningLottoNumbersList = Arrays.asList(LottoNumberTest.ONE, new LottoNumber(7), new LottoNumber(8), new LottoNumber(9), new LottoNumber(10), new LottoNumber(11));
        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers(winningLottoNumbersList, LottoNumberTest.THIRTY);
        int countOfMatchNumber = LOTTO_TICKET.countMatchingNumber(winningLottoNumbers);
        boolean isExistBonusLottoNumber = LOTTO_TICKET.isExistBonusLottoNumber(winningLottoNumbers);
        LottoRank lottoRank = LottoRank.valueOf(countOfMatchNumber, isExistBonusLottoNumber);
        
        assertThat(lottoRank).isEqualTo(LottoRank.MISS);
    }
    
    @Test
    @DisplayName("로또 번호 0개 일치 확인")
    void confirm_zero_number_match() {
        List<LottoNumber> winningLottoNumbersList = Arrays.asList(new LottoNumber(7), new LottoNumber(8), new LottoNumber(9), new LottoNumber(10), new LottoNumber(11), new LottoNumber(12));
        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers(winningLottoNumbersList, LottoNumberTest.THIRTY);
        int countOfMatchNumber = LOTTO_TICKET.countMatchingNumber(winningLottoNumbers);
        boolean isExistBonusLottoNumber = LOTTO_TICKET.isExistBonusLottoNumber(winningLottoNumbers);
        LottoRank lottoRank = LottoRank.valueOf(countOfMatchNumber, isExistBonusLottoNumber);
        
        assertThat(lottoRank).isEqualTo(LottoRank.MISS);
    }
}