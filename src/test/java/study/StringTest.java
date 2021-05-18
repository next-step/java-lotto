package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    String test;

    @BeforeEach
    void setUp(){
        test = "abc";
    }

    @Test
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void substring() {
        String result = "(1,2)".substring(1,4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt()을 사용하여 특정 위치의 문자를 가져온다.")
    void charAt() {
        assertThat(test.charAt(0)).isEqualTo('a');
        assertThat(test.charAt(1)).isEqualTo('b');
        assertThat(test.charAt(2)).isEqualTo('c');
    }

    @Test
    @DisplayName("charAt()을 사용할 때 문자의 인덱스를 벗어나면 StringIndexOutOfBoundsException 이 발생한다.")
    void stringIndexOutOfBoundsException() {
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    test.charAt(3);
                }).withMessageMatching("String index out of range: \\d+");
    }

}
