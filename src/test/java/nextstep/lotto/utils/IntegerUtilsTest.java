package nextstep.lotto.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class IntegerUtilsTest {

    @Test
    @DisplayName("입력문자열의 int 변환 테스트")
    void transStringToIntTest(){
        assertThat(IntegerUtils.parsePositiveInt("1")).isEqualTo(1);
    }

    @Test
    @DisplayName("숫자가 아닌 문자의 int 변환 테스트")
    void transStringToInt_NotNumberFormat_Test(){
        assertThatThrownBy(() -> {
            IntegerUtils.parsePositiveInt("CleanCode");
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("음수의 int 변환 테스트")
    void transStringToInt_negativeNumber_Test(){
        assertThatThrownBy(() -> {
            IntegerUtils.parsePositiveInt("-1");
        }).isInstanceOf(RuntimeException.class);
    }
}
