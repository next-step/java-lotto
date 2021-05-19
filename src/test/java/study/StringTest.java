package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

    @Test
    @DisplayName("요구사항1-1")
    void arraySplit(){
        String[] result="1,2".split(",");
        assertThat(result).contains("1");
        assertThat(result).contains("2");
        assertThat(result).containsExactly("1","2");
    }

    @Test
    @DisplayName("요구사항1-2")
    void singleSplit(){
        String[] result="1".split(",");
        assertThat(result).isEqualTo(new String[]{"1"});
    }

    @Test
    @DisplayName("요구사항2")
    void subString(){
        String value="(1,2)";
        String result=value.substring(value.indexOf("(")+1,value.indexOf(")"));
        assertThat(result).isEqualTo("1,2");
    }

}
