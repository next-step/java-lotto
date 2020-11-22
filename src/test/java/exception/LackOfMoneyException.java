package exception;

import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.Test;

public class LackOfMoneyException extends Throwable {

    @Test
    void test() {
        AssertionsForClassTypes.assertThatExceptionOfType(LackOfMoneyException.class)
                .isThrownBy(() -> {
                    throw new LackOfMoneyException();
                });
    }

}
