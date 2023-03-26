package calculator;

import calculator.domain.Delimeter;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DelimeterTest {

    @Test
    public void isExistCustomDelimeter(){
        Delimeter delimeter = new Delimeter("//;\\n1;2;3");
        assertThat(delimeter.isExistCustomDelimeter())
                .isEqualTo(true);
    }

    @Test
    public void isNotExistCustomDelimeter(){
        Delimeter delimeter = new Delimeter("1;2;3");
        assertThat(delimeter.isExistCustomDelimeter())
                .isEqualTo(false);
    }
}
