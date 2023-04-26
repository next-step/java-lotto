package stringcalculator;

import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import stringcalculator.domain.Experssion;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class ExperssionTest {

    @ParameterizedTest
    @NullAndEmptySource
    void NULL또는빈값(String expression) {
        assertThatThrownBy(() -> {
            Experssion experssion = new Experssion(expression);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("수식이 입력되지 않았습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"4 4", "+ 3", "4 + 4 5", "3 +", "+ 3 3", "3 + 4 & 5", "3 + 4 4 5"})
    void 수식오류(String expression) {
        assertThatThrownBy(() -> {
            Experssion experssion = new Experssion(expression);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("입력한 수식이 형식이 맞지 않거나, 지원하지 않는 연산자 입니다");
    }

    @Test
    @DisplayName("수식계산")
    void 수식계산() {
        Experssion experssion = new Experssion("3 + 4 - 2 * 6 / 5");

        Assertions.assertThat(experssion.reduce()).isEqualTo(6);
    }
}
