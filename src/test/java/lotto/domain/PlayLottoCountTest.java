package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayLottoCountTest {

    @DisplayName("생성할때 1보다 작은 수가 주어지면 예외가 발생한다.")
    @Test
    void less_than_1() {
        assertThatThrownBy(() -> new PlayLottoCount(0))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage("1보다 작은 수로 생성할 수 없습니다.");
    }
}
