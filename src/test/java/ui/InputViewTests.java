package ui;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTests {
    private InputView inputView;

    @BeforeEach
    void setup() {
        inputView = new InputView();
    }

    @DisplayName("입력값 중 기본 구분자(:와 쉼표)를 제외한 숫자만 골라낸 콜렉션 출력")
    @ParameterizedTest
    @ValueSource(strings = {"112:3:5,523:123,1", "112:3:5:523:123:1", "112,3,5,523,123,1"})
    void compositeParser(String input) {
        List<Integer> numbers = inputView.extractNumbers(input);
        assertThat(numbers.get(0)).isEqualTo(112);
        assertThat(numbers.get(3)).isEqualTo(523);
    }

    @DisplayName("입력값 중 잘못된 값(숫자가 아니거나 음수)이 입력된 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"112:3:5,523:123,-1", "112:3:5,523:123,hello"})
    void parserFailWithInvalidInputs(String input) {
        assertThatThrownBy(() -> inputView.extractNumbers(input)).isInstanceOf(IllegalArgumentException.class);
    }
}
