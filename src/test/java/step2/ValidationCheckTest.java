package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class ValidationCheckTest {

    @BeforeEach
    public void setup() {

    }

    @Test
    public void 구매금액_입력_체크() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            ValidationCheck.inputPriceIsEmpty(null);
        });
    }

    @Test
    public void 당첨번호_입력_체크() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            ValidationCheck.inputLuckyNumberIsEmpty(null);
        });
    }

}
