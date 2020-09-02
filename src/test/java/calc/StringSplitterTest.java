package calc;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringSplitterTest {

    @Test
    @DisplayName("default split test ")
    public void test(){
        //given when
        String[] tokens = StringSplitter.split("1,2:3");

        //then
        assertThat(tokens).containsExactly(new String[]{"1","2","3"});
    }

    @Test
    @DisplayName("custom delimeter split test")
    public void test2(){
        //given when
        String[] tokens = StringSplitter.split("//;\n1;2;3");

        //then
        assertThat(tokens).containsExactly(new String[]{"1","2","3"});
    }

    @Test
    @DisplayName("null string split test")
    public void test3(){
        //given when
        String[] tokens = StringSplitter.split(null);

        //then
        assertThat(tokens).containsExactly(new String[0]);
    }

    @Test
    @DisplayName("empty string split test")
    public void test4(){
        //given when
        String[] tokens = StringSplitter.split("");

        //then
        assertThat(tokens).containsExactly(new String[0]);
    }
}
