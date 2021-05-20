package study;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class StringStudyTest {

    @Test
    void split_1Comma2() {
        String _1Comma2 = "1,2";
        String[] tokens = _1Comma2.split(",");
        assertThat(tokens).containsExactly("1", "2");
    }

    @Test
    void split_1() {
        String _1 = "1";
        String[] tokens = _1.split(",");
        assertThat(tokens).containsExactly("1");
    }

    @Test
    void substring() {
        String _1Comma2 = "(1,2)";
        String substring = _1Comma2.substring(1, _1Comma2.length() - 1);
        assertThat(substring).isEqualTo("1,2");
    }

    @ParameterizedTest
    @CsvSource({"abc,0,a", "abc,1,b", "abc,2,c"})
    void charAt(String abc, int index, char expected) {
        assertThat(abc.charAt(index)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"abc,-1", "abc,3"})
    void charAt_when_index_out_of_bounds(String abc, int index) {
        assertThatExceptionOfType(IndexOutOfBoundsException.class).isThrownBy(() -> abc.charAt(index));
    }
}
