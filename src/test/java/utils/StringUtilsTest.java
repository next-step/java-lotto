package utils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringUtilsTest {
    @Test
    void testSplitWith(){
        String[] splits = StringUtils.splitWith("1,2",",");
        assertThat(splits).isNotEmpty().containsExactly("1","2");
    }

    @Test
    void testSplitFromNull(){
        String[] splitsFromNull = StringUtils.splitWith(null,",");
        assertThat(splitsFromNull).isNull();
    }

    @Test
    void testIsEmpty(){
        assertThat(StringUtils.isEmpty("")).isTrue();
        assertThat(StringUtils.isEmpty("1")).isFalse();
        assertThat(StringUtils.isEmpty(" ")).isTrue();
        assertThat(StringUtils.isEmpty(null)).isTrue();

    }
}
