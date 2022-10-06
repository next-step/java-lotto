package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

/**
 * Created by seungwoo.song on 2022-10-06
 */
class BuyTest {

    @Test
    void 생성() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Buy(1000, 300).getCount());
    }

    @Test
    void 구매장수() {
        assertThat(new Buy(1000, 2000).getCount()).isEqualTo(2);
    }
}