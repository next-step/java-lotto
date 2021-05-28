package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StudyTest {

    @Test
    void splite() {
        String data = "1,2";
        String[] result = data.split(",");
        assertThat(result).contains("1");
        assertThat(result).containsExactly("1","2");
    }

    @Test
    void substringTest() {
        String data = "(1,2)";
        int startIndex = data.indexOf("(")+1;
        int endIndex = data.indexOf(")");
        String result = data.substring(startIndex,endIndex);
        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("길이 이상 위치의 char값 가져올때 StringIndexOutOfBoundsException 발생 확인")
    @Test
    void charAtTest() {
        String data = "abc";
        assertThatThrownBy(() -> data.charAt(3)).isInstanceOf(StringIndexOutOfBoundsException.class);
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class).isThrownBy(() -> data.charAt(4));

    }


}
