package lotto.ui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PrizeInputViewTest {
    @DisplayName("쉼표로 구분된 문자열을 입력 받아서 객체 생성")
    @Test
    void inputTest() {
        PrizeInputView prizeInputView = new PrizeInputView("1, 2, 3, 4, 5, 6");
        assertThat(prizeInputView).isNotNull();
    }

    @DisplayName("null이나 빈 문자열을 입력 받으면 IllegalArgumnetException")
    @Test
    void validateInput() {
        assertThatThrownBy(() -> new PrizeInputView("")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new PrizeInputView("   ")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new PrizeInputView(null)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력받은 문자열을 int 컬렉션으로 변화 가능")
    @Test
    void convertToIntCollectionTest() {
        PrizeInputView prizeInputView = new PrizeInputView("1, 2, 3, 4, 5, 6");
        assertThat(prizeInputView.convertToIntCollection()).containsExactly(1, 2, 3, 4, 5, 6);
    }
}
