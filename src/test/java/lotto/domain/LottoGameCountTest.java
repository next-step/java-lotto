package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoGameCountTest {
    @Test
    @DisplayName("LottoGameCount 생성자 테스트")
    void constructor() {
        assertThat(new LottoGameCount(10, 3)).isEqualTo(new LottoGameCount(10, 3));
    }

    @Test
    @DisplayName("수동으로 구매할 로또게임수가 전체 로또구매수 보다 클수 없다.")
    void invalidateLottoCount() {
        assertThatThrownBy(() -> {
            new LottoGameCount(1, 2);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("수동으로 구매한 로또가 있는지 테스트")
    void isPurchasedManual() {
        assertThat(new LottoGameCount(10, 3).isPurchasedManual()).isTrue();
    }
}

