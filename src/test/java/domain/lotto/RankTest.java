package domain.lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class RankTest {
    @Test
    public void equals(){
        Assertions.assertThat(Rank.FIRST == Rank.FIRST).isEqualTo(true);
    }
    @Test
    public void frist(){
        Assertions.assertThat(Rank.FIRST == Rank.FIRST).isEqualTo(true);
    }
    @Test
    public void plus(){
        final Operator operator = new Operator();
        final int result = operator.operate(3,5);
        Assertions.assertThat(result).isEqualTo(8);
    }
}
