package step5.winning;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import step5.lotto.LottoTicket;
import step5.utils.StringUtils;
import java.util.Set;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class WinningNumbersTest {
    @DisplayName("입력된 당첨번호가 null 이거나 비어있을경우 예외 확인")
    @ParameterizedTest
    @NullAndEmptySource
    void setWinningNumbers_null확인(String numbers){
        assertThatThrownBy(() -> {
            new WinningNumbers(numbers, 3);
        }).isInstanceOf(RuntimeException.class)
                .hasMessageContaining("당첨번호를 입력해주세요.");
    }

    @DisplayName("입력된 당첨번호가 쉼표로만 구분되어 었는지 확인")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4.5.6", "3,4,5:1:2:6","19 2,3,4,5,1"})
    void winningNumber_쉼표구분(String numbers) {
        assertThatThrownBy(() -> {
            new WinningNumbers(numbers, 3);
        }).isInstanceOf(RuntimeException.class)
                .hasMessageContaining("당첨번호는 쉼표(,)로 구분되어야합니다.");
    }

    @DisplayName("입력된 당첨번호가 6개 미만일경우 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4", "3,4,5", "1", "9,2,3,4,5"})
    void winningNumber_6개미만_예외발생(String numbers) {
        assertThatThrownBy(() -> {
            new WinningNumbers(numbers, 3);
        }).isInstanceOf(RuntimeException.class)
                .hasMessageContaining("당첨번호는 6자리 숫자로 구성되어야합니다.");
    }

    @DisplayName("당첨번호와 보너스번호 중복 예외 발생")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:6", "10,23,25,30,34,40:25", "11,13,15,28,29,38:29"}, delimiter = ':')
    void winningNumber_당첨번호_보너스번호_중복(String numbers, int bonusNumber) {
        assertThatThrownBy(() -> {
            new WinningNumbers(numbers, bonusNumber);
        }).isInstanceOf(RuntimeException.class)
                .hasMessageContaining("보너스볼은 당첨번호와 중복되서는 안됩니다.");
    }

    @DisplayName("보너스번호 당첨 결과 확인")
    @ParameterizedTest
    @CsvSource(value = {"2,4,5,10,11,12:true", "1,2,3,4,5,10:true",
                        "1,2,3,4,5,7:false", "1,2,3,4,5,6:false",
                        "10,11,12,23,34,45:true"}, delimiter = ':')
    void hasBonusNumber(String inputLottoNumber, boolean expected) {
        //given
        Set<Integer> lottoNumbers = StringUtils.processStringNumbers(inputLottoNumber);
        LottoTicket ticket = new LottoTicket();
        ticket.createManualLottoNumbers(lottoNumbers);
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6", 10);

        //when
        boolean result = winningNumbers.hasBonusNumber(ticket);

        //then
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("로또번호와 당첨번호 일치 개수 반환")
    @ParameterizedTest
    @CsvSource(value = {"2,4,5,10,11,12:3", "2,3,4,5,6,11:5", "1,2,3,4,5,6:6", "10,11,12,23,34,45:0"}, delimiter = ':')
    void calculateWinningPoints(String inputLottoNumbers, int result) {
        //given
        LottoTicket ticket = new LottoTicket();
        ticket.createManualLottoNumbers(StringUtils.processStringNumbers(inputLottoNumbers));

        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6", 9);

        //when
        int points = winningNumbers.calculateWinningPoints(ticket);

        //then
        assertThat(points).isEqualTo(result);
    }
}