package stringpluscalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomSeparatorEnumTest {

    private final String BASE_TEST_INPUT = "//;\\n1;2;3";

    @Test
    @DisplayName("커스텀 구분자 찾기 테스트")
    void searchCustomSeparatorTest() {
        assertThat(
                CustomSeparatorEnum.searchCustomSeparator(BASE_TEST_INPUT)
        ).isEqualTo(";");
    }

    @Test
    @DisplayName("커스텀 구분자 설저웁분을 제외하고 가져오기 테스트")
    void withoutCustomSeparatorTest() {
        assertThat(
                CustomSeparatorEnum.withoutCustomSeparator(BASE_TEST_INPUT)
        ).isEqualTo("1;2;3");
    }

    @Test
    @DisplayName("커스텀 구분자 설정부분이 있는지 테스트")
    void hasCustomSeparatorTest() {
        assertThat(
                CustomSeparatorEnum.hasCustomSeparator(BASE_TEST_INPUT)
        ).isTrue();
    }
}
