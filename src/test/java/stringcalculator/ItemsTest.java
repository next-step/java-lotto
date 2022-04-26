package stringcalculator;

import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("연산 항목 Items 테스트")
public class ItemsTest {

    public static final List<String> TEST_INPUTS = ExtractFormula.splitText("1 + 2 * 2");

    @Test
    @DisplayName("Items 생성 인자로 null이 들어오면 NullPointerException이 발생한다.")
    void nullTest() {
        Assertions.assertThatThrownBy(() -> new Items(null))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    @DisplayName("Items 의 길이가 3 미만일 경우 예외가 발생한다. ")
    void sizeFailTest() {
        Assertions.assertThatThrownBy(() -> new Items(Lists.newArrayList("1")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("size()는 사이즈를 반환한다.")
    void sizeTest() {
        Items items = new Items(TEST_INPUTS);

        assertThat(items.size()).isEqualTo(5);
    }

    @Test
    @DisplayName("getFirstOperand 는 리스트의 첫번째 피연산자를 반환한다.")
    void getFirstOperandTest() {
        Items items = new Items(TEST_INPUTS);

        assertThat(items.getFirstOperand()).isEqualTo(1);
    }

    @Test
    @DisplayName("getSecondOperand 는 리스트의 두번째 피연산자를 반환한다.")
    void getSecondOperandTest() {
        Items items = new Items(TEST_INPUTS);

        assertThat(items.getSecondOperand()).isEqualTo(2);
    }

    @Test
    @DisplayName("getOperator 는 리스트의 두번째 값인 연산자를 반환한다.")
    void getOperatorTest() {
        Items items = new Items(TEST_INPUTS);

        assertThat(items.getOperator()).isEqualTo("+");
    }

    @Test
    @DisplayName("of 메서드로 새로운 Items를 생성한다.")
    void ofTest() {
        // given
        Items items = new Items(TEST_INPUTS);

        // when
        Calculator calculator = new Calculator(items.getOperator());
        int baseNumber = calculator.calculate(items.getFirstOperand(), items.getSecondOperand());
        Items newItems = Items.of(baseNumber, items);

        // then
        assertThat(newItems.size()).isEqualTo(3);
        assertThat(newItems.getFirstOperand()).isEqualTo(baseNumber);
    }
}
