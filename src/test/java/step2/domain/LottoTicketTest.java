package step2.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTicketTest {
    private Set<LottoNumber> numbers = new HashSet<>();

    @BeforeEach
    public void setNumber() {
        numbers.add(new LottoNumber(1));
        numbers.add(new LottoNumber(2));
        numbers.add(new LottoNumber(3));
        numbers.add(new LottoNumber(4));
        numbers.add(new LottoNumber(5));
        numbers.add(new LottoNumber(6));
    }

    @Test
    @DisplayName("반환된 값은 수정이 불가능한 컬렉션이다.")
    public void unmodifiableSet() {
        assertThatThrownBy(() -> {
            new LottoTicket(numbers).lottoTicket().add(new LottoNumber(7));
        }).isInstanceOf(UnsupportedOperationException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"1, 2, 3, 4, 5, 6 = 6",
        "1, 10, 13, 15, 20, 25 = 1",
        "2, 5, 6, 40, 43, 35 = 3",
        "3, 10, 4, 2, 1, 7 = 4"}, delimiter = '=')
    @DisplayName("지난 당첨번호를 인자로 받을 시 가지고 있는 번호와 일치하는 갯수를 반환한다")
    public void matchedWinningNumber(String input, int expected) {
        assertThat(new LottoTicket(numbers).matchedWinningNumber(new MatchedNumber(input))).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1: true", "2: true", "7: false", "8: false", "5: true"}, delimiter = ':')
    @DisplayName("인자로 보너스볼 번호를 받으면 로또에 포함 여부를 반환한다.")
    public void matchedBonusBallNumber(int input, boolean expected) {
        LottoTicket lottoTicket = new LottoTicket(numbers);

        assertThat(lottoTicket.matchedBonusBallNumber(new BonusBallNumber(input))).isEqualTo(expected);
    }
}
