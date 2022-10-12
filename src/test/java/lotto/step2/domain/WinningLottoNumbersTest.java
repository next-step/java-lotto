package lotto.step2.domain;

import lotto.step2fixture.domain.LottoNumberFixture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class WinningLottoNumbersTest {
    public final WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers("1,2,3,4,5,6");
    private static final String EXCEPTION_MESSAGE = "올바른 입력 값이 아닙니다. 다시 입력해 주세요.";
    
    @BeforeEach
    void setUp() {
        winningLottoNumbers.inputBonusNumber("30");
    }
    
    @Test
    @DisplayName("WinningLottoNumbers 객체 생성")
    void create() {
        assertThat(winningLottoNumbers).isNotNull();
    }
    
    @Test
    @DisplayName("보너스 로또 번호 존재 여부")
    void is_exist_bonus_lotto_number() {
        List<LottoNumber> lottoTicket = Arrays.asList(LottoNumberFixture.ONE, LottoNumberFixture.TWO, LottoNumberFixture.THREE, LottoNumberFixture.FOUR, LottoNumberFixture.FIVE, LottoNumberFixture.THIRTY);
        boolean isExistBonusNumber = winningLottoNumbers.isExistBonusLottoNumber(lottoTicket);
        
        assertThat(isExistBonusNumber).isTrue();
    }
    
    @Test
    @DisplayName("일치 번호 개수")
    void count_matching_number() {
        List<LottoNumber> lottoNumbers = LottoTicketTest.LOTTO_TICKET.getLottoTicket();
        int countMatchingNumber = winningLottoNumbers.countMatchingNumber(lottoNumbers);
        
        assertThat(countMatchingNumber).isEqualTo(6);
    }
    
    @Test
    @DisplayName("로또 당첨번호를 보너스 번호로 입력 시 예외")
    void bonus_number_exception() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> winningLottoNumbers.inputBonusNumber("6"))
                .withMessage("입력하신 보너스 번호는 이미 존재하는 당첨 번호 입니다. 다시 입력해주세요.");
    }
    
    @Test
    @DisplayName("지난 주 당첨 번호 입력 값 반환")
    void winner_lotto_numbers_input() {
        final WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers("1, 5, 20, 39, 41, 45");
        List<LottoNumber> lottoNumbers = Arrays.asList(new LottoNumber(1), new LottoNumber(5), new LottoNumber(20), new LottoNumber(39), new LottoNumber(41), new LottoNumber(45));
        assertThat(winningLottoNumbers.countMatchingNumber(lottoNumbers)).isEqualTo(6);
    }
    
    @EmptySource
    @ParameterizedTest(name = "{displayName} : {0}")
    @DisplayName("지난 주 당첨 번호 - \"\" 입력 시 예외 던지기")
    void winner_lotto_numbers_input_null_or_empty_exception(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningLottoNumbers(input))
                .withMessage(EXCEPTION_MESSAGE);
    }
    
    @DisplayName("지난 주 당첨 번호 - 콤마 구분자가 아닌 경우 예외 던지기")
    @ParameterizedTest(name = "{displayName} : {0}")
    @ValueSource(strings = {"1, 2, 3. 4, 5, 6", "1, 2, 3$ 4, 5, 6", "1, 2, 3,, 4, 5, 6"})
    void winner_lotto_numbers_input_delimiter_exception(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningLottoNumbers(input))
                .withMessage(EXCEPTION_MESSAGE);
    }
    
    @DisplayName("지난 주 당첨 번호 - 숫자가 아닌 값 입력 시 예외 던지기")
    @ParameterizedTest(name = "{displayName} : {0}")
    @ValueSource(strings = {"1, 2, 3, 4, d, 6", "1, 2, 3, 4, , 6", "1, 2, 3, 4, %, 6"})
    void winner_lotto_numbers_input_number_format_exception(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningLottoNumbers(input))
                .withMessage(EXCEPTION_MESSAGE);
    }
    
    @Test
    @DisplayName("지난 주 당첨 번호 - 음수 입력 시 예외 던지기")
    void winner_lotto_numbers_input_negative_exception() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningLottoNumbers("1, 2, 3, 4, -5, 6"))
                .withMessage(EXCEPTION_MESSAGE);
    }
    
    @Test
    @DisplayName("지난 주 당첨 번호 - 0 입력 시 예외 던지기")
    void winner_lotto_numbers_input_zero_exception() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningLottoNumbers("1, 2, 0, 4, 5, 6"))
                .withMessage(EXCEPTION_MESSAGE);
    }
    
    @DisplayName("지난 주 당첨 번호 - 입력 형식이 맞지 않는 경우")
    @ParameterizedTest(name = "{displayName} : {0}")
    @ValueSource(strings = {"1, 2, 3 4, 5, 6", "1, 2, 3, 4, 5, ", "1, 2, 3, 4, 5"})
    void winner_lotto_numbers_input_different_format_exception(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningLottoNumbers(input))
                .withMessage(EXCEPTION_MESSAGE);
    }
    
    @DisplayName("보너스 당첨 번호 입력 값 반환")
    @ParameterizedTest(name = "{displayName} : {0}")
    @ValueSource(strings = {"1", "45"})
    void winning_lotto_bonus_numbers_input(String input) {
        final WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers("2,3,4,5,6, 7");
        winningLottoNumbers.inputBonusNumber(input);
        assertThat(winningLottoNumbers.isExistBonusLottoNumber(List.of(new LottoNumber(Integer.parseInt(input))))).isTrue();
    }
    
    @DisplayName("보너스 당첨 번호 - \"\" 입력 시 예외 던지기")
    @ParameterizedTest(name = "{displayName} : {0}")
    @EmptySource
    void winning_lotto_bonus_numbers_input_null_or_empty_exception(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> winningLottoNumbers.inputBonusNumber(input))
                .withMessage(EXCEPTION_MESSAGE);
    }
    
    @DisplayName("보너스 당첨 번호 - 숫자가 아닌 값 입력 시 예외 던지기")
    @ParameterizedTest(name = "{displayName} : {0}")
    @ValueSource(strings = {"d", " ", "%"})
    void winning_lotto_bonus_numbers_input_number_format_exception(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> winningLottoNumbers.inputBonusNumber(input))
                .withMessage(EXCEPTION_MESSAGE);
    }
    
    @DisplayName("보너스 당첨 번호 - 1 ~ 45 범위 초과")
    @ParameterizedTest(name = "{displayName} : {0}")
    @ValueSource(strings = {"0", "46"})
    void winning_lotto_bonus_numbers_input_range_exceed_exception(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> winningLottoNumbers.inputBonusNumber(input))
                .withMessage(EXCEPTION_MESSAGE);
    }
    
    @Test
    @DisplayName("보너스 당첨 번호 - 음수 입력")
    void winning_lotto_bonus_numbers_input_negative_exception() {
        assertThatIllegalArgumentException().isThrownBy(() -> winningLottoNumbers.inputBonusNumber("-1"))
                .withMessage(EXCEPTION_MESSAGE);
    }
}