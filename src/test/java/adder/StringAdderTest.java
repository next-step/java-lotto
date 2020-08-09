package adder;

import common.StringResources;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringAdderTest {

    @Test
    public void splitAndSum_null_또는_빈문자() {
        int result = StringAdder.splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = StringAdder.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void splitAndSum_숫자하나() throws Exception {
        int result = StringAdder.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void splitAndSum_쉼표구분자() throws Exception {
        int result = StringAdder.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void splitAndSum_쉼표_또는_콜론_구분자() throws Exception {
        int result = StringAdder.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_custom_구분자() throws Exception {
        int result = StringAdder.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_negative() throws Exception {

        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> StringAdder.splitAndSum("-1,2,3"))
                .withMessage(StringResources.ERR_NO_NEGATIVE);
    }

    @Test
    public void splitAndSum_another_character() throws Exception {

        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> StringAdder.splitAndSum("o,2,3"))
                .withMessage(StringResources.ERR_ONLY_NUMBER);
    }
}