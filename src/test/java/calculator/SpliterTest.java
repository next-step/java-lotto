package calculator;

import calculator.domain.Delimeter;
import calculator.domain.Spliter;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SpliterTest {

    @Test
    public void split(){
        Delimeter delimeter = new Delimeter("//;\\n1;2;3");
        assertThat(Spliter.split("//;\\n1;2;3", delimeter))
                .isEqualTo("1;2;3");
    }

    @Test
    public void split2(){
        Delimeter delimeter = new Delimeter("//;\\n1;2;3");
        assertThat(Spliter.split("//|\\n1;2;3", delimeter))
                .isEqualTo("1;2;3");
    }

}
