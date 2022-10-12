package lotto.step2.domain;

import lotto.step2fixture.domain.LottoNumberFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

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
    
    @Test
    @DisplayName("구분자 콤마 아닐 시 예외")
    void delimiter_input_exception() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoTicket("1, 2, 3. 4,5, 6"))
                .withMessage("올바른 입력 값이 아닙니다. 다시 입력해 주세요.");
    }
    
    @Test
    @DisplayName("범위 벗어날 시 예외")
    void exceeded_input_exception() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoTicket("1, 2, 3, 4,5, 46"))
                .withMessage("올바른 입력 값이 아닙니다. 다시 입력해 주세요.");
    }
    
    @ParameterizedTest(name = "{displayName} : {0}")
    @DisplayName("숫자가 아닐 시 예외")
    @ValueSource(strings = {"1, 2, 3, d,5, 6", "1, 2, 3, ㅁ,5, 6", "1, 2, 3, %,5, 6", "1, 2, 3, ,5, 6"})
    void not_number_input_exception(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoTicket(input))
                .withMessage("올바른 입력 값이 아닙니다. 다시 입력해 주세요.");
    }
    
    @Test
    @DisplayName("음수일 시 예외")
    void negative_input_exception() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoTicket("-1, 2, 3, 4,5, 6"))
                .withMessage("올바른 입력 값이 아닙니다. 다시 입력해 주세요.");
    }
    
    @Test
    @DisplayName("음수일 시 예외")
    void exceeded_count_input_exception() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoTicket("1, 2, 3, 4,5, 6, 7"))
                .withMessage("올바른 입력 값이 아닙니다. 다시 입력해 주세요.");
    }
}