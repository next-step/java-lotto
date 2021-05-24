package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

class StringClassStudyTest {

    @Test
    @DisplayName("요구사항 1 - 1. '1,2'을 split했을 때, 잘 분리되는지 확인")
    public void stringSplitByComma_green(){
        // given
        String given = "1,2";
        // when
        final String[] splitString = given.split(",");
        // than
        assertThat(splitString)
                .isNotEmpty()
                .hasSize(2)
                .contains("1", "2");
    }

    @Test
    @DisplayName("요구사항 1 - 2. '1'을 split했을 때, 1만 포함된 배열 반환 확")
    public void stringSplitByComma_edge(){
        // given
        String given = "1";
        // when
        final String[] splitString = given.split(",");
        // than
        assertThat(splitString)
                .isNotEmpty()
                .hasSize(1)
                .containsExactly(given);
    }
    @Test
    @DisplayName("요구사항 2. '(1,2)'을 substring()메소드를 활용해, '()'을 제거하고 '1,2'를 반환")
    public void removebrace_green(){
        // given :: 브레이스가 여러개면 어떡하지? 구멍!
        String given = "(1,2)";
        // when
        int rightBrace = given.indexOf("(");
        int leftBrace = given.indexOf(")");

        final String substring = given.substring(rightBrace+1,leftBrace);
        // than
        assertThat(substring)
                .isNotEmpty()
                .contains("1,2");
    }

    @Test
    @DisplayName("요구사항 3 - 1. 'abc'을 charAt() 메소드를 활용해, 특정 위치의 문자를 가져오기")
    public void charAt_green(){
        // given
        String given = "abc";
        // when
        char[] givenChars = given.toCharArray();
        int inbound = 0;
        while (inbound < given.length()){
            // than
            assertThat(givenChars)
                    .contains(given.charAt(inbound));
            inbound++;
        }
    }

    @Test
    @DisplayName("요구사항 3 - 2. 'abc'을 charAt() 메소드를 활용해, 위치 값을 벗어낫을때, StringIndexOutOfBoundsException 발생")
    public void charAt_red(){
        String given = "abc";
        // when
        assertThatThrownBy(() -> { given.charAt(given.length()); })
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: "+given.length());
    }
}