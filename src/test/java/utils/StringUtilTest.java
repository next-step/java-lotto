package utils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringUtilTest {

    @Test
    void 공백_테스트() {
        String[] result = StringUtil.spliter("1, 2, 3, 4, 5, 6");

        assertThat(result.length).isEqualTo(6);
        assertThat(result).contains("1");
        assertThat(result).isEqualTo(new String[]{"1", "2", "3", "4", "5", "6"});
    }
}