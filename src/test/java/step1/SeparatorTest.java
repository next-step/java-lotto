package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("분리기 테스트")
public class SeparatorTest {

    @Test
    @DisplayName("문자열을 쉼표(,), 콜론(:)으로 분리한다")
    void 문자열_쉼표_또는_콜론_분리() {
        String formula = "1 : 3 , 4 : 3";

        assertThat(Separator.split(formula)).doesNotContain(":", ",");
    }
}
