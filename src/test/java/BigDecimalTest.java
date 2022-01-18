import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class BigDecimalTest {


    @Test
    @DisplayName("BigDecimal 덧셈 단위 테스트")
    void addBigDecimal(){
        //given
        BigDecimal before = BigDecimal.ZERO;
        BigDecimal after;

        //when
        after = before.add(new BigDecimal(200));

        //then
        Assertions.assertThat(before.add(new BigDecimal(200))).isNotEqualTo(before);
        Assertions.assertThat(before.add(new BigDecimal(200))).isEqualTo(after);
    }
}
