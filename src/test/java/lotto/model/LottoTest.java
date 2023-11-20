package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTest {

    @Test
    @DisplayName("로또 번호는 매번 다르게 생성됨")
    public void 로또_번호_랜덤_생성() {
        Lotto lotto = new Lotto();
        Lotto lotto1 = new Lotto();
        Assertions.assertThat(lotto)
                .isNotEqualTo(lotto1);
    }
}
