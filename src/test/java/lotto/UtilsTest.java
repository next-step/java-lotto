package lotto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class UtilsTest {
    @Test
    @DisplayName("0이하의 수 입력시 에러")
    void non_positive_input() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Utils.toInt("-1");
        });
    }

    @Test
    @DisplayName("숫자가 아닌 값 입력시 에러")
    void non_math_input() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Utils.toInt("hi");
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "1, 2, 3"})
    @DisplayName("리스트로 바꿀 숫자열은 ','로 구분하며 빈칸 여부는 영향을 주지 않는다. ")
    void make_list(String input) {

        assertThat(Utils.toList(input)).isEqualTo(Arrays.asList(1,2,3));
    }

}
