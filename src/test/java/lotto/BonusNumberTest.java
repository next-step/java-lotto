package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusNumberTest {

    @DisplayName(value = "보너스 번호가 45보다 크거나 1보다 작으면 예외")
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void 보너스_번호의_범위_체크(int number) {
        // when
        assertThatThrownBy(() -> {
            BonusNumber.newNumber(number);
            // then
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨번호가_5개가_아닐_때_false_반환() {
        // given
        int countOfMatch = 6;
        BonusNumber bonusNumber = BonusNumber.newNumber(1);

        // when
        boolean matchBonus = bonusNumber.isMatchBonus(countOfMatch, Arrays.asList(1, 2, 3, 4, 5, 6));

        // then
        assertThat(matchBonus).isFalse();
    }

    @DisplayName(value = "당첨번호가 5개이고, 보너스 번호가 당첨번호가 있다면 true, 아니면 false 반환")
    @ParameterizedTest
    @CsvSource(value = {"6,false", "7,true"})
    void 당첨번호가_5개_일_때(int ticketNumber, boolean expect) {
        // given
        int countOfMatch = 5;
        BonusNumber bonusNumber = BonusNumber.newNumber(7);
        List<Integer> ticketNumbers = Arrays.asList(1, 2, 3, 4, 5, ticketNumber);

        // when
        boolean matchBonus = bonusNumber.isMatchBonus(countOfMatch, ticketNumbers);

        // then
        assertThat(matchBonus).isEqualTo(expect);
    }
}