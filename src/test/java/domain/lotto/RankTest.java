package domain.lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class RankTest {
    @Test
    public void plus(){
        final Operator operator = new Operator();
        final int result = operator.operate(3,5);
        Assertions.assertThat(result).isEqualTo(8);
    }
}
