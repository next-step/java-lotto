package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculatorItemsTest {

    @ValueSource(strings = {"", " ", "  "})
    @ParameterizedTest(name = "input: \"{0}\"")
    @DisplayName("빈문자열 입력시 예외발생")
    void test01(String input) {
        assertThatThrownBy(() -> new CalculatorItems(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("isNext 메서드를 통해 다음 값 접근이 가능한지 알 수 있다.")
    void test02() {
        CalculatorItems items = new CalculatorItems("2 + 3");
        assertThat(items.hasNext()).isTrue();
    }

    @Test
    @DisplayName("nextAsInt 메서드를 통해 현재의 항목을 int 타입으로 변환하여 가져온다.")
    void test03() {
        CalculatorItems items = new CalculatorItems("2 + 3");
        assertThat(items.nextAsInt()).isSameAs(2);
    }

    @Test
    @DisplayName("nextAsString 메서드를 통해 현재의 항목을 String 타입으로 변환하여 가져온다.")
    void test04() {
        CalculatorItems items = new CalculatorItems("2 + 3");
        items.nextAsInt();
        assertThat(items.nextAsString()).isEqualTo("+");
    }

    @Test
    @DisplayName("아이템의 다음 값이 존재하지 않을때 다음값을 접근하면 에러가 발생한다.")
    void test05() {
        CalculatorItems items = new CalculatorItems("2 + 3");
        items.nextAsInt();
        items.nextAsString();
        items.nextAsInt();
        assertThatThrownBy(items::nextAsString)
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    @DisplayName("nextAsInt 메서드 사용시 현재 하목이 String 타입인데 int로 변환하는 경우 에러가 발생한다.")
    void test06() {
        CalculatorItems items = new CalculatorItems("2 + 3");
        items.nextAsInt();
        assertThatThrownBy(items::nextAsInt)
                .isInstanceOf(IllegalStateException.class);
    }
}