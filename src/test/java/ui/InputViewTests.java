package ui;

import domain.Number;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTests {
    @DisplayName("커스텀 구분자가 있는 경우 커스텀 구분자를 포함한 regex 반환")
    @ParameterizedTest
    @MethodSource("stringIncludedCustomDivider")
    void getDividerPatternTest(String input, String divider, String target) {
        InputView inputView = InputView.create(input);
        assertThat(inputView.getDivider()).isEqualTo(divider);
        assertThat(inputView.getTargetString()).isEqualTo(target);
    }
    public static Stream<Arguments> stringIncludedCustomDivider() {
        return Stream.of(
                Arguments.of("//!\n112!3:5,523:123!1", "[,!:]", "112!3:5,523:123!1"),
                Arguments.of("//;\n112;3:5,523:123;1", "[,;:]", "112;3:5,523:123;1")
        );
    }

    @DisplayName("입력값 중 기본 구분자(:와 쉼표)를 제외한 숫자만 골라낸 콜렉션 출력")
    @ParameterizedTest
    @ValueSource(strings = {"112:3:5,523:123,1", "112:3:5:523:123:1", "112,3,5,523,123,1"})
    void compositeParser(String input) {
        InputView inputView = InputView.create(input);
        List<Number> numbers = inputView.extractNumbers();
        assertThat(numbers.get(0)).isEqualTo(new Number("112"));
        assertThat(numbers.get(3)).isEqualTo(new Number("523"));
    }

    @DisplayName("입력값 중 잘못된 값(숫자가 아니거나 음수)이 입력된 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"112:3:5,523:123,-1", "112:3:5,523:123,hello"})
    void parserFailWithInvalidInputs(String input) {
        assertThatThrownBy(() -> InputView.create(input).extractNumbers()).isInstanceOf(RuntimeException.class);
    }

    @DisplayName("숫자 하나짜리 입력에도 정상 처리 가능")
    @ParameterizedTest
    @ValueSource(strings = {"1", "5", "12"})
    void parseWithOneNumberStringValue(String input) {
        InputView inputView = InputView.create(input);
        List<Number> numbers = inputView.extractNumbers();

        assertThat(numbers.size()).isEqualTo(1);
        assertThat(numbers.get(0)).isEqualTo(new Number(input));
    }
}
