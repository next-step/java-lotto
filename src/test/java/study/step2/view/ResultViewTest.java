package study.step2.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class ResultViewTest {

    @DisplayName("로또구입금액만큼 로또를 발급하는 경우")
    @ParameterizedTest
    @CsvSource(value = {"14000:14", "2000:2", "50000:50"}, delimiter = ':')
    void 로또구입금액만큼_로또를_발급하는_경우(int input, int expected) {
        assertThat(ResultView.printTicketCount(input)).isEqualTo(expected);
    }

    @DisplayName("로또구입금액은 천단위의 양의 정수인 경우")
    @ParameterizedTest
    @ValueSource(ints = {14001, 2001, 50001})
    void 로또구입금액은_천단위의_양의_정수인_경우(int input) {
        assertThatThrownBy(()->ResultView.printTicketCount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
