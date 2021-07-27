package lotto.domain;

import lotto.exception.IllegalLottoNumberCountException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class LottoNumbersTest {

    @DisplayName("로또 번호의 숫자는 6개여야 한다.")
    @Test
    void lotto_number_validation() {
        assertThatThrownBy(() -> LottoNumbers.of(("1,2,3,4,5")))
                .isInstanceOf(IllegalLottoNumberCountException.class);
    }

    @DisplayName("티겟이 당첨번호와 몇개 일치하는지 판별한다.")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:6","1,2,3,4,5,12:5","1,2,3,4,11,21:4","1,2,3,12,13,14:3", "10,11,12,13,14,15:0"}, delimiter = ':')
    void count_one_ticket(String input, int expected) {
        LottoNumbers winTicket = LottoNumbers.of("1,2,3,4,5,6");
        LottoNumbers buyTicket = LottoNumbers.of(input);
        int matchCount = winTicket.match(buyTicket);

        assertThat(matchCount).isEqualTo(expected);
    }
}