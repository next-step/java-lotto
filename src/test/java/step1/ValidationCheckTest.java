package step1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class ValidationCheckTest {

    private ValidationCheck validationCheck;

    @BeforeEach
    public void setup() {
        validationCheck = new ValidationCheck();
    }

    @Test
    public void add_null_또는_빈문자()  {
        assertThat(validationCheck.inputNumberCheckIsEmpty(null)).isEqualTo(0);
        assertThat(validationCheck.inputNumberCheckIsEmpty("")).isEqualTo(0);
    }

    @Test
    public void add_negative() throws Exception {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            validationCheck.checkNegative(-1);
        });
    }

}
