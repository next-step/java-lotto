package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @DisplayName("[요구사항 1] 1,2가 쉼표로 잘 분리되는지 테스트")
    @Test
    void split_1and2() {
        //Given + When
        String[] result = "1,2".split(",");

        //Then
        assertThat(result).containsExactly("1", "2");
    }

    @DisplayName("[요구사항 1] 1을 분리했을때 1만 포함하는지 테스트")
    @Test
    void split_only1() {
        //Given+When
        String[] result = "1".split(",");

        //Then
        assertThat(result).containsOnly("1");
    }

    @DisplayName("[요구사항 2] substring() 이용하여 (1,2)에서 괄호 제거")
    @Test
    void substring_remove_bracket() {
        //Given+When
        String result = "(1,2)".substring(1, 4);

        //Then
        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("[요구사항 3] charAt() 메소드 테스트 - 정상 범위인 경우")
    @Test
    void test_charAt() {
        //Given
        String str = "012";

        //When + Then
        assertThat(str.charAt(1)).isEqualTo('1');
    }

    @DisplayName("[요구사항 3] charAt() 메소드 테스트 - IndexOutOfBounds 예외 경우")
    @Test
    void test_charAt_IndexOutOfBounds() {
        //Given
        String str = "012";

        //When + Then
        assertThatThrownBy(() -> str.charAt(4)).isInstanceOf(IndexOutOfBoundsException.class);
    }
}
