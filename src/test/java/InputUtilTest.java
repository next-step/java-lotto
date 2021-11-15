import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import util.InputUtil;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

public class InputUtilTest {
    @Test
    @DisplayName("String input을 Array로 잘 반환하는지 test ")
    void inputUtilTest() {
        String input = "//;\n1;2;3";
        assertThat(InputUtil.paresNumber(input)).contains("1","2","3");
        String input2 = "1;2;3";
        assertThat(InputUtil.paresNumber(input2)).contains("1","2","3");
    }
}
