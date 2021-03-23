package step1.separator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SeparatorTest {

    @DisplayName("Separator 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {
        // given
        String inputValue = "//;\n1;2;3,4:5";

        // when
        Separator separator = new Separator(inputValue);

        // then
        assertThat(separator).isNotNull();
    }

}