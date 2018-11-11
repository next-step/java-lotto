package lotto.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PrizeMoneyTypeTest {

    @Test
    public void 매칭_3개일때_금액() {
        Integer prizeMoney = PrizeMoneyType.MATCH_3.getPrizeMoney();
        assertThat(prizeMoney).isEqualTo(5000);
    }


}