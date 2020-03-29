package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CustomNumbersTest {

    @Test
    @DisplayName("CustomNumber List로 생성 시 입력 값들을 정확히 포함")
    void create_inputCustomNumberList_containsInput() {
        CustomNumber first = CustomNumber.of(0);
        CustomNumber second = CustomNumber.of(3);
        CustomNumbers customNumbers = new CustomNumbers(Arrays.asList(first, second));

        assertThat(customNumbers.getCustomNumbers()).containsExactly(first, second);
    }

    @Test
    @DisplayName("String 배열로 생성 시 입력 값들을 정확히 포함")
    void create_inputStringArray_containsInput() {
        String[] input = {"1", "5", "8"};
        CustomNumbers customNumbers = new CustomNumbers(input);

        assertThat(customNumbers.getCustomNumbers()).containsExactly(CustomNumber.of(1)
                , CustomNumber.of(5)
                , CustomNumber.of(8));
    }

    @Test
    @DisplayName("잘못된 입력일 시 throw RunTimeException")
    void create_inputStringInvalid_throwRuntimeException() {
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> {
            String[] input = {"1", "5", "ff"};
            new CustomNumbers(input);
        });
    }

    @Test
    @DisplayName("CustomNumber List로 sum 수행 시 입력 값의 합계와 일치")
    void sum_setCustomNumberList_sumValue() {
        CustomNumber first = CustomNumber.of(0);
        CustomNumber second = CustomNumber.of(3);
        CustomNumber third = CustomNumber.of(9);
        CustomNumbers customNumbers = new CustomNumbers(Arrays.asList(first, second, third));

        int result = customNumbers.sum();

        assertThat(result).isEqualTo(12);
    }
}
