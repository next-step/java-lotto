package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class NullCheckUtilTest {

    @DisplayName("인자가 null이면 예외가 발생한다.")
    @Test
    void validate() {
        assertThatThrownBy(() -> NullCheckUtil.validate(null))
                .isExactlyInstanceOf(NullCannotBeConstructorArgException.class)
                .hasMessage("Null은 생성자의 인자가 될 수 없습니다.");
    }
}
