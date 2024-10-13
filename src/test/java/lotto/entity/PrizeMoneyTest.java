package lotto.entity;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class PrizeMoneyTest {

    @Test
    void 맞히지_못함() {
        PrizeMoney result = PrizeMoney.findByCount(2);

        assertThat(result).isEqualTo(PrizeMoney.LOSE);
    }

    @Test
    void 당첨() {
        assertAll(
                () -> assertThat(PrizeMoney.findByCount(3)).isEqualTo(PrizeMoney.THREE),
                () -> assertThat(PrizeMoney.findByCount(4)).isEqualTo(PrizeMoney.FOUR),
                () -> assertThat(PrizeMoney.findByCount(5)).isEqualTo(PrizeMoney.FIVE),
                () -> assertThat(PrizeMoney.findByCount(6)).isEqualTo(PrizeMoney.SIX)
        );
    }

    @Test
    void 합계_계산(){
        BigDecimal fivePrizeMoney = PrizeMoney.THREE.getPrizeMoney();
        BigDecimal sum = PrizeMoney.FOUR.sum(fivePrizeMoney);

        assertThat(sum).isEqualTo(BigDecimal.valueOf(55000));
    }


}
