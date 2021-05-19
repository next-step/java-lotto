package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    @DisplayName("split이 delimeter를 기준으로 분리되는지 테스트")
    void arraySplit(){
        String[] result="1,2".split(",");
        assertThat(result).contains("1");
        assertThat(result).contains("2");
        assertThat(result).containsExactly("1","2");
    }

    @Test
    @DisplayName("split이 delimeter를 기준으로 특정 배열값만 분리되는지 테스트")
    void singleSplit(){
        String[] result="1".split(",");
        assertThat(result).isEqualTo(new String[]{"1"});
    }

    @Test
    @DisplayName("substring으로 내부값이 반환되는지 테스트")
    void subString(){
        String value="(1,2)";
        String result=value.substring(value.indexOf("(")+1,value.indexOf(")"));
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt이 특정위치의 문자를 반환하는지 테스트")
    void charAt(){
        String value="abc";
        assertThat(value.charAt(0)).isEqualTo('a');
        assertThat(value.charAt(1)).isEqualTo('b');
        assertThat(value.charAt(2)).isEqualTo('c');
    }

    @Test
    @DisplayName("charAt이 범위를 넘어가는 index에 예외를 발생시키는지 테스트")
    void charAtException(){
        String value="abc";
        assertThatThrownBy(()->{
            value.charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("index out of range: 3");
    }

}
