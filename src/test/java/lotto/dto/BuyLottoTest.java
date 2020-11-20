package lotto.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BuyLottoTest {

    @DisplayName("BuyLotto 생성 테스트")
    @Test
    void of() {
        assertThat(BuyLotto.of("10000", "2"))
                .isEqualToComparingFieldByField(BuyLotto.of("10000", "2"));
    }
}
