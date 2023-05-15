package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

/**
 * 1. 숫자로 된 금액을 입력한다.
 * 2. 당첨번호 문자열을 입력한다.
 */

public class InputViewTest {
    @DisplayName("올바른 금액을 입력했는 경우 성공 테스트")
    @Test
    void right_price_input_test() {
        InputView inputView = new InputView(14000);
        assertThat(inputView.getPrice()).isEqualTo(new Money(14000));
    }


    @DisplayName("6개의 당첨 번호를 입력했을 경우 성공 테스트")
    @ParameterizedTest
    @MethodSource("provideIntListForCorrectValue")
    void right_won_numbers_input_test(String input, String expected) {
        InputView inputView = new InputView(input);
        assertThat(inputView.getWonNumbers()).isEqualTo(new Lotto(expected));
    }

    @DisplayName("잘못된 6개의 당첨 번호를 입력했을 경우 성공 테스트")
    @ParameterizedTest
    @MethodSource("provideIntListForIncorrectValue")
    void wrong_won_numbers_input_test(String input) {
        assertThatThrownBy(() -> {
            InputView inputView = new InputView(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> provideIntListForCorrectValue() {
        return Stream.of(
                Arguments.of("1, 2, 3, 4, 5, 6", "1, 2, 3, 4, 5, 6"),
                Arguments.of("11, 12, 13, 14, 15, 16", "11, 12, 13, 14, 15, 16"),
                Arguments.of("45, 44, 43, 42, 41, 40", "45, 44, 43, 42, 41, 40")
        );
    }

    private static Stream<Arguments> provideIntListForIncorrectValue() {
        return Stream.of(
                Arguments.of("0, 2, 3, 4, 5, 6"),
                Arguments.of("1, 1, 2, 3, 4, 4"),
                Arguments.of("47, 41, 43, 42, 41, 40")
        );
    }
}
