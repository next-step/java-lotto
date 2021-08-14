package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("로또 당첨번호 테스트")
class WinningLottoTicketTest {

    List<Integer> winningLottoNumbers;

    @BeforeEach
    void setUp() {
        winningLottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
    }

    @Test
    @DisplayName("보너스번호가 당첨번호와 겹칠때 예외처리")
    void winningLottoNumbersConstructorExceptionTest() {
        // given
        int bonusNumber = 1;

        // when
        // then
        assertThatThrownBy(() -> new WinningLottoTicket(winningLottoNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("bonus number must not in winning numbers");
    }

    @ParameterizedTest(name = "{0} -> {1}")
    @CsvSource(value = {"1:true", "8:false"}, delimiter = ':')
    @DisplayName("주어진 로또번호가 당첨번호에 포함하는지 확인")
    void winningLottoNumbersContainsTest(int lottoNumber, boolean expected) {
        // given
        WinningLottoTicket winningLottoTicket = new WinningLottoTicket(winningLottoNumbers, 45);

        // when
        boolean actual = winningLottoTicket.contains(new LottoNumber(lottoNumber));

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest(name = "{0} -> {1}")
    @CsvSource(value = {"7:true", "8:false"}, delimiter = ':')
    @DisplayName("주어진 로또티켓에 보너스 번호가 있는지 확인")
    void bonusTest(int bonusNumber, boolean expected) {
        // given
        LottoTicket lottoTicket = new LottoTicket(1, 2, 3, 4, 5, 7);
        WinningLottoTicket winningLottoTicket = new WinningLottoTicket(winningLottoNumbers, bonusNumber);

        // when
        boolean actual = winningLottoTicket.containsBonusNumber(lottoTicket);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}