package Calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static Calculator.Delimiter.DEFAULT_DELIMETER;
import static org.assertj.core.api.Assertions.assertThat;

public class DelimiterTest {

    private Delimiter delimiter;

    @BeforeEach
    void setUp(){
        //given
        delimiter = new Delimiter();

    }

    @Test
    void createTest(){
        //then
        assertThat(delimiter).isEqualTo(new Delimiter(DEFAULT_DELIMETER));
    }

}
