package Calculator.domain;

import Calculator.domain.Delimiter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static Calculator.domain.Delimiter.DEFAULT_DELIMITER;
import static org.assertj.core.api.Assertions.assertThat;

public class DelimiterTest {

    private Delimiter delimiter;

    @BeforeEach
    void setUp() {
        //given
        delimiter = new Delimiter();

    }

    @Test
    void createTest() {
        //then
        assertThat(delimiter).isEqualTo(new Delimiter(DEFAULT_DELIMITER));
    }

}
