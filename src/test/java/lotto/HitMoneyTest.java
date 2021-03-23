package lotto;

import lotto.domain.HitMoney;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class HitMoneyTest {
    @DisplayName("당첨금액을 생성한다.")
    @Test
    public void hitMoney() {
        HitMoney hitMoney = new HitMoney(5000);
        assertThat(hitMoney.toString()).isEqualTo("5000");
    }
}
