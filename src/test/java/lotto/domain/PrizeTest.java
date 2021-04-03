package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PrizeTest {

    @Test
    @DisplayName("당첨 금액 생성")
    public void create() throws Exception {
        Prize prize = new Prize(1_000);
        assertThat(prize).isEqualTo(new Prize(1_000));
    }

    @Test
    @DisplayName("당첨 금액이 0원 미만일 경우")
    public void validateBound() throws Exception {
        assertThatIllegalArgumentException().isThrownBy(() -> new Prize(-1));
    }
}
