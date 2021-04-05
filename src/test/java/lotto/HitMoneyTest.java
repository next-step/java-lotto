package lotto;

import lotto.domain.HitMoney;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HitMoneyTest {
    @DisplayName("HitMoney 인스턴스가 정상적으로 생성된다.")
    @Test
    void create() {
        assertThat(new HitMoney(1000)).isEqualTo(new HitMoney(1000));
    }

    @DisplayName("당첨금액의 합계를 반환한다.")
    @Test
    void sum() {
        HitMoney hitMoney = new HitMoney(5000);
        assertThat(hitMoney.sum(10000)).isEqualTo(new HitMoney(15000));
    }
}
