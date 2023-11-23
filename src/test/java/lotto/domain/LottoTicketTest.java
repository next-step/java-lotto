package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

public class LottoTicketTest {

    @DisplayName("로또 티켓의 숫자가 지정한 숫자와 같지 않다면 IllegalArgumentException을 던진다.")
    @Test
    void throw_IllegalArgumentException_when_lotto_ticket_numbers_ne_count() {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> new LottoTicket(1, 2, 3, 4, 5));
    }

    @DisplayName("로또 티켓의 숫자중 중복된 값이 있다면 IllegalArgumentException을 던진다.")
    @Test
    void throw_IllegalArgumentException_when_lotto_ticket_numbers_duplicate() {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> new LottoTicket(1, 2, 3, 4, 5, 5));
    }

    @DisplayName("당첨번호와 로또번호가 몇 개 일치 하는지 계산한다.")
    @ParameterizedTest
    @MethodSource("winningNumbersAndLottoNumbers")
    void calc_match_count(LottoTicket winningNums, int expected) {
        LottoTicket lottoTicket = new LottoTicket(1, 2, 3, 4, 5, 6);
        assertThat(lottoTicket.calcMatchCount(winningNums)).isEqualTo(expected);
    }

    static Stream<Arguments> winningNumbersAndLottoNumbers() {
        return Stream.of(
            Arguments.arguments(new LottoTicket(1, 2, 3, 4, 5, 6), 6),
            Arguments.arguments(new LottoTicket(1, 2, 3, 4, 5, 7), 5),
            Arguments.arguments(new LottoTicket(1, 2, 3, 4, 8, 7), 4),
            Arguments.arguments(new LottoTicket(1, 2, 3, 9, 8, 7), 3),
            Arguments.arguments(new LottoTicket(1, 2, 10, 9, 8, 7), 2),
            Arguments.arguments(new LottoTicket(1, 11, 10, 9, 8, 7), 1),
            Arguments.arguments(new LottoTicket(7, 8, 9, 10, 11, 12), 0)
        );
    }

    @DisplayName("보너스 번호가 포함되어있으면 true, 아니면 false를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"7:true", "8:false", "9:true"}, delimiter = ':')
    void is_match_bonus_num(int num, boolean expected) {
        assertThat(new LottoTicket(1, 2, 3, 7, 5, 9).isMatchBonusNum(new LottoNumber(num)))
            .isEqualTo(expected);
    }
}

