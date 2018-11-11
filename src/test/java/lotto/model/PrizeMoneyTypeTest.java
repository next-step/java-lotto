package lotto.model;

        import org.junit.Test;

        import static org.assertj.core.api.Assertions.assertThat;

public class PrizeMoneyTypeTest {

    @Test
    public void 매칭_3개일때_금액() {
        Integer prizeMoney = PrizeType.FIFTH.getPrizeMoney();
        assertThat(prizeMoney).isEqualTo(5000);
    }

    @Test
    public void 매칭_5개_보너스볼_매칭() {
        Integer prizeMoney = PrizeType.valueOf(5, true).getPrizeMoney();
        assertThat(prizeMoney).isEqualTo(30000000);
    }

    @Test
    public void 매칭_5개_보너스볼_매칭안됨() {
        Integer prizeMoney = PrizeType.valueOf(5, false).getPrizeMoney();
        assertThat(prizeMoney).isEqualTo(1500000);
    }
}