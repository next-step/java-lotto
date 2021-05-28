package step5.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class StringUtilsTest {
    @DisplayName("String 쉼표로 구분된 문자열을 set으로 반환")
    @Test
    void processStringNumbers() {
        Set<Integer> list = StringUtils.processStringNumbers("1,2,3,4,5,6");
        assertThat(list).containsExactly(1,2,3,4,5,6);
    }
}