package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BonusBallTest {

    @Test
    @DisplayName("보너스 볼 생성")
    public void create() throws Exception {
        BonusBall bonusBall = new BonusBall(1);
        assertThat(bonusBall).isEqualTo(new BonusBall(1));
    }

    @Test
    @DisplayName("보너스 볼 번호 일치하는지 확인")
    public void isSame() throws Exception {
        BonusBall bonusBall = new BonusBall(1);
        assertThat(bonusBall.isSame(1)).isTrue();
        assertThat(bonusBall.isSame(2)).isFalse();
    }
}
